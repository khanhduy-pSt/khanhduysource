package com.example.junoshop.Model;

public class ItemSanPham {


    public int id;

    public ItemSanPham(int id, String tensp, String hinhsp, String giasp) {
        this.id = id;
        this.tensp = tensp;
        this.hinhsp = hinhsp;
        this.giasp = giasp;
    }

    public String tensp,hinhsp;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public String getHinhsp() {
        return hinhsp;
    }

    public void setHinhsp(String hinhsp) {
        this.hinhsp = hinhsp;
    }

    public String getGiasp() {
        return giasp;
    }

    public void setGiasp(String giasp) {
        this.giasp = giasp;
    }

    public String giasp;

}
