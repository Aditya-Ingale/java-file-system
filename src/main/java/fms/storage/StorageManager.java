package fms.storage;

import java.util.map;

import fms.block.Block;

public class StorageManager{
    //fields only

    //total memory limit in bytes (20 MB)
    private final long totalMemory;

    //size of each block in bytes (1 KB)
    private final int blockSize;

    //all blocks managed by the system
    private Map<Interger, Block> blocks;

    public StorageManager(long totalMemory, int blockSize){
        this.totalMemory = totalMemory;
        this.blockSize = blockSize;
        this.blocks = new Hasmap<>();

        int totalBlocks = (int) (totalMemory / blockSize);

        for(int i = 0; i < totalBlocks; i++){
            blocks.put(i, new Block(i, blockSize));
        }
    }
}