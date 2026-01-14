package fms.file;

import java.time.LocalDateTime;
import java.util.List;

import fms.permission.Permission;

public class File{
    //fields only
    private String name;
    private long size;

    //ordered list of blacks that make up the file
    private List<Interger> blockIds;

    private Permission permission;

    private LocalDateTime createAt;
    private LocalDateTime lastModifiedAt;
}