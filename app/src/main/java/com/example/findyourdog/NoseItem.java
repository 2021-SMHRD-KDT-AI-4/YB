package com.example.findyourdog;

public class NoseItem {

    private String filename;
    private String name;

    public NoseItem(String filename, String name) {
        this.filename = filename;
        this.name = name;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
