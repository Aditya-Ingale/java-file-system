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

    public void write(byte[] src, int offset, int length){
        System.arraycopy(src, offset, this.data, 0, length);
        this.isFree = false;
    }

    public byte[] getData(){
        return data;
    }
    
    public void clear(){
        this.isFree = true;
    }
}