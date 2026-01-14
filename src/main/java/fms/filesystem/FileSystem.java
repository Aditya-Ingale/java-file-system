package fms.filesystem;

import java.util.HashMap;
import java.util.Map;

import fms.file.File;
import fms.space.SpaceManager;
import fms.storage.StorageManager;

public class FileSystem {
    // fields only

    //maps file path th file object
    private Map<String, File> files;
    private StorageManager storageManager;
    private SpaceManager spaceManager;

    public FileSystem(){
        // system-wide constant
        long TOTAL_MEMORY = 20L * 1024 * 1024; //20 MB
        int BLOCK_SIZE = 1024;

        this.files = new HashMap<>();

        this.storageManager = new StorageManager(TOTAL_MEMORY, BLOCK_SIZE);

        int totalBlocks = (int) (TOTAL_MEMORY / BLOCK_SIZE);
        this.spaceManager = new SpaceManager(totalBlocks);
    }
}