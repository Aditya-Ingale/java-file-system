package fms.space;

import java.util.LinkedList;
import java.util.Queue;

public class SpaceManager{
    //fields only

    //stores IDs of free block for O(1) allocation
    private Queue<Integer> freeBlockIds;

    public SpaceManager(int totalBlocks){
        this.freeBlockIds = new LinkedList<>();

        //initally, all blocks are free
        for(int i = 0; i < totalBlocks; i++){
            freeBlockIds.add(i);
        }
    }

    public Integer getFreeBlock(){
        return freeBlockIds.poll();
    }

    public void releaseBlock(int blockId){
        freeBlockIds.add(blockId);
    }
}