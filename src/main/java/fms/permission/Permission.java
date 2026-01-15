package fms.permission;

public class Permission {
    //fields only
    private boolean canRead;
    private boolean canWrite;
    private boolean canExecute;

    public Permission(boolean canRead, boolean canWrite, boolean canExecute){
        this.canRead = canRead;
        this.canWrite = canWrite;
        this.canExecute = canExecute;
    }

    public boolean canWrite(){
        return canWrite;
    }

    public boolean canRead(){
        return canRead;
    }
}