package com.acc.gp.quick.note.model;

import java.util.Date;

public class Note {
    private int id;
    private int folderId;
    private String title;
    private String content;
    private long noteCreated;
    private long noteUpdated;
    private String imagePath;
    private String backgroundColor;

    public Note() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFolderId() {
        return folderId;
    }

    public void setFolderId(int folderId) {
        this.folderId = folderId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getNoteCreated() {
        return noteCreated;
    }

    public void setNoteCreated(long noteCreated) {
        this.noteCreated = noteCreated;
    }

    public long getNoteUpdated() {
        return noteUpdated;
    }

    public void setNoteUpdated(long noteUpdated) {
        this.noteUpdated = noteUpdated;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }
}
