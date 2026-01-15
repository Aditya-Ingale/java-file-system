# Java In-Memory File Management System

## 1. Project Overview

This project implements an **in-memory file management system** using Java.
It simulates how a real operating system file system works internally,
without using Java’s built-in file APIs.

All data is stored in **memory (RAM)** using custom abstractions such as
blocks, files, and space managers.

The system supports:
- File creation
- Writing (append & overwrite)
- Reading
- Deletion
- Permission management
- Command-line interaction (CLI)

This project focuses on **system design, correctness, and abstraction**.

---

## 2. High-Level Architecture

The system is composed of the following core components:

- **FileSystem** – Public API and coordinator
- **File** – Logical representation of a file
- **Block** – Smallest unit of storage
- **StorageManager** – Owns and manages blocks
- **SpaceManager** – Tracks free blocks efficiently
- **Permission** – Access control model

Each component has a **single responsibility**.

---

## 3. Design Principles

### 3.1 Clarity
Each class has a clear role.
No class performs responsibilities outside its scope.

### 3.2 Correctness
The system always maintains valid state:
- Blocks are either free or owned
- File size matches written data
- Permissions are enforced

### 3.3 Clear Abstraction
Higher-level components do not depend on low-level details.
For example:
- FileSystem does not manipulate block memory directly
- StorageManager does not track free space

---

## 4. Data Model Explanation

### 4.1 Block

A `Block` is the smallest unit of storage.

Fields:
- `blockId` (final, private)
- `byte[] data`
- `boolean isFree`

#### Why `blockId` exists
- Identifies a block uniquely
- Files reference blocks using IDs, not objects
- Decouples files from physical storage

#### Why `blockId` is `final`
- A block’s identity must never change
- Prevents accidental reassignment

#### Why fields are `private`
- Prevents external modification
- Enforces controlled access
- Protects invariants

#### Why `byte[] data`
- Memory stores raw bytes
- All file types reduce to bytes internally

---

### 4.2 File

A `File` represents a logical file, not raw data.

Fields:
- `name`
- `size`
- `List<Integer> blockIds`
- `Permission permission`
- `createdAt`, `lastModifiedAt`

#### Why File stores block IDs instead of data
- Keeps file abstraction lightweight
- Storage details belong to StorageManager
- Matches real OS file systems (inode → blocks)

#### Why size is stored explicitly
- Avoids recalculating from blocks
- Enables fast read operations

---

### 4.3 Permission

Permission controls access to files.

Fields:
- `canRead`
- `canWrite`
- `canExecute`

The system enforces permissions before:
- Reading
- Writing
- Modifying files

This mimics real OS permission models.

---

### 4.4 StorageManager

StorageManager owns **all blocks**.

Fields:
- `totalMemory`
- `blockSize`
- `Map<Integer, Block> blocks`

Responsibilities:
- Create blocks at startup
- Provide access to blocks
- Clear blocks when freed

#### Why StorageManager does NOT track free blocks
- Violates single responsibility
- Free space tracking belongs to SpaceManager

---

### 4.5 SpaceManager

SpaceManager tracks free blocks efficiently.

Fields:
- `Queue<Integer> freeBlockIds`

Responsibilities:
- Provide free block IDs in O(1)
- Accept released blocks

#### Why Queue is used
- Constant-time allocation and release
- Predictable behavior

---

## 5. File Operations Flow

### createFile
- Validate path
- Create empty File
- No blocks allocated

### writeFile (APPEND)
- Validate file and permissions
- Calculate required blocks
- Allocate blocks from SpaceManager
- Write data into blocks
- Update file metadata

### writeFile (OVERWRITE)
- Free existing blocks
- Clear file metadata
- Reuse append logic

### readFile
- Validate permissions
- Read blocks in order
- Combine bytes into result

### deleteFile
- Free all file blocks
- Return blocks to SpaceManager
- Remove file entry

### changePermission
- Replace Permission object
- No storage impact

---

## 6. Invariants

The system always guarantees:
- A block is either free or owned, never both
- A file references only allocated blocks
- StorageManager is the single owner of blocks
- SpaceManager is the single owner of free space
- Permissions are checked before access

---

## 7. CLI Design

The CLI is a thin layer over FileSystem.

Supported commands:
- `create <path>`
- `write <path> append <data>`
- `write <path> overwrite <data>`
- `read <path>`
- `delete <path>`
- `chmod <path> r|w|x`
- `exit`

CLI responsibilities:
- Parse input
- Call FileSystem APIs
- Display output or errors

---

## 8. Limitations

- In-memory only (no persistence)
- Single-threaded
- No directory hierarchy
- No journaling or crash recovery

These are intentional design limits.

---

## 9. Possible Extensions

- Disk persistence
- Directory support
- Journaling
- Concurrency & locking
- Disk-based block storage

---

## 10. Conclusion

This project demonstrates:
- System-level thinking
- Correct abstraction
- Manual resource management
- Clean API design

It models the **core logic of a real file system** in a safe, understandable way.
