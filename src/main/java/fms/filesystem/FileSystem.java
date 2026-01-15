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
        long TOTAL_MEMORY = 20L * 1024 * 1024;  // 20 MB
        int BLOCK_SIZE = 1024;                      // 1 KB

        this.files = new HashMap<>();

        this.storageManager = new StorageManager(TOTAL_MEMORY, BLOCK_SIZE);

        int totalBlocks = (int) (TOTAL_MEMORY / BLOCK_SIZE);
        this.spaceManager = new SpaceManager(totalBlocks);
    }

    public void createFile(String path, fms.permission.Permission permission){
    if(files.containsKey(path)){
        throw new RuntimeException("File already exixts: " + path);
    }

    //extract file name from path(simple verison)
    String fileName = path;

    File file = new File();
    //temporary: fields will be set next step

    files.put(path, file);
}
}