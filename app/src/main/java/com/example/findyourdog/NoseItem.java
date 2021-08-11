package com.example.findyourdog;

public class NoseItem {

    private String num;
    private String filename;
    private String name;

    public NoseItem(String num, String filename, String name) {
        this.num = num;
        this.filename = filename;
        this.name = name;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
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
