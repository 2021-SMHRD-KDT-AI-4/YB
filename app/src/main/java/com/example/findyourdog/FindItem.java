package com.example.findyourdog;

public class FindItem {

    String filename;
    String notice;
    String kind;
    String tel;
    String shelter;
    String board_type;

    public FindItem(String filename, String notice, String kind, String tel, String shelter, String board_type) {
        this.filename = filename;
        this.notice = notice;
        this.kind = kind;
        this.tel = tel;
        this.shelter = shelter;
        this.board_type = board_type;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getShelter() {
        return shelter;
    }

    public void setShelter(String shelter) {
        this.shelter = shelter;
    }

    public String getBoard_type() {
        return board_type;
    }

    public void setBoard_type(String board_type) {
        this.board_type = board_type;
    }
}
