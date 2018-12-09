package com.acc.gp.quick.note.model;

import java.util.Date;

public class Folder {
    private int folderId;
    private String folderName;

    public Folder() {
    }

    public int getFolderId() {
        return folderId;
    }

    public void setFolderId(int folderId) {
        this.folderId = folderId;
    }

    public String getFolderName() {
        return folderName;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }
}
