package com.toandev.danhmuc;

import javax.persistence.*;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cate_id")
    private int cateId;

    public int getCateId() {
        return cateId;
    }

    public void setCateId(int cateId) {
        this.cateId = cateId;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public String getMotaDanhMuc() {
        return motaDanhMuc;
    }

    public void setMotaDanhMuc(String motaDanhMuc) {
        this.motaDanhMuc = motaDanhMuc;
    }

    @Column(name = "cate_name")
    private String cateName;

    @Column(name = "mota_danh_muc")
    private String motaDanhMuc;


}

