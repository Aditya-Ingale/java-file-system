package fms.block;

public class Block {
    // fields only
    private final int blockId;
    private byte[] data;
    private boolean isFree;

    public Block(int blockId, int blockSize){
        this.blockId = blockId;
        this.data = new byte[blockSize];
        this.isFree = true;
    }
}