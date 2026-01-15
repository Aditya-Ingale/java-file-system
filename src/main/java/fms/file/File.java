package fms.file;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import fms.permission.Permission;

public class File{
    //fields only
    private String name;
    private long size;

    //ordered list of blacks that make up the file
    private List<Integer> blockIds;

    private Permission permission;

    private LocalDateTime createdAt;
    private LocalDateTime lastModifiedAt;

    public File(String name, Permission permission){
        this.name = name;
        this.permission = permission;
        this.size = 0;
        this.blockIds = new ArrayList<>();
        this.createdAt = LocalDateTime.now();
        this.lastModifiedAt = this.createdAt;
    }

    public Permission getPermission(){
        return permission;
    }

    public List<Integer> getBlockIds(){
        return blockIds;
    }

    public void updateSize(long delta){
        this.size += delta;
        this.lastModifiedAt = java.time.LocalDateTime.now();
    }
}