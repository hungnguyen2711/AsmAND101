package com.example.asm.model;

public class PhongBan {
    private int imgPhongban;
    private String tenPb;

    public PhongBan(int imgPhongban, String tenPb) {
        this.imgPhongban = imgPhongban;
        this.tenPb = tenPb;
    }

    public int getImgPhongban() {
        return imgPhongban;
    }

    public void setImgPhongban(int imgPhongban) {
        this.imgPhongban = imgPhongban;
    }

    public String getTenPb() {
        return tenPb;
    }

    public void setTenPb(String tenPb) {
        this.tenPb = tenPb;
    }
}
