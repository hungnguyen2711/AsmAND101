package com.example.asm.model;

import java.io.Serializable;

public class NhanVien implements Serializable {

    private String maNv;
    private String hoTen;
    private String tenPb;

    public NhanVien(String maNv, String hoTen, String tenPb) {
        this.maNv = maNv;
        this.hoTen = hoTen;
        this.tenPb = tenPb;
    }

    public String getMaNv() {
        return maNv;
    }

    public void setMaNv(String maNv) {
        this.maNv = maNv;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getTenPb() {
        return tenPb;
    }

    public void setTenPb(String tenPb) {
        this.tenPb = tenPb;
    }
}
