# Java In-Memory File Management System

## 1. Project Overview
- What the project is
- Why it exists
- In-memory vs disk-based

## 2. High-Level Architecture
- FileSystem
- StorageManager
- SpaceManager
- File
- Block
- Permission

## 3. Core Design Principles
- Clarity
- Correctness
- Clear Abstraction

## 4. Data Model Explanation
### 4.1 Block
- blockId
- why private
- why final
- byte[] data
- isFree

### 4.2 File
- name
- size
- blockIds
- permissions
- timestamps

### 4.3 StorageManager
- totalMemory
- blockSize
- blocks map

### 4.4 SpaceManager
- freeBlockIds queue
- O(1) allocation logic

## 5. File Operations Flow
- createFile
- writeFile (append)
- writeFile (overwrite)
- readFile
- deleteFile
- changePermission

## 6. Invariants
- Memory safety
- Block ownership
- Permission enforcement

## 7. CLI Design
- Supported commands
- Parsing logic
- Error handling

## 8. Limitations
- In-memory only
- Single-threaded
- No persistence

## 9. Possible Extensions
- Disk persistence
- Directories
- Journaling
- Concurrency
