package fms.filesystem;

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
}