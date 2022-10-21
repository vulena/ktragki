package com.ltdd.btthgk;

public class Items {
    String ten,gia;
    int anh;

    public Items(String ten, String gia, int anh) {
        this.ten = ten;
        this.gia = gia;
        this.anh = anh;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public int getAnh() {
        return anh;
    }

    public void setAnh(int anh) {
        this.anh = anh;
    }
}
