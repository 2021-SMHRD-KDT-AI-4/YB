package com.example.findyourdog;

public class PictureItem {
    private String kind;
    private String filename;
    private String gender;

    public PictureItem(String kind, String filename, String gender) {
        this.kind = kind;
        this.filename = filename;
        this.gender = gender;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
