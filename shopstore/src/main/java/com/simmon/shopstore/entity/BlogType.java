package com.simmon.shopstore.entity;

import lombok.Data;

/**
 * 博客分类表
 */
@Data
public class BlogType {
    private int bId;//分类id
    private String bName;//分类名称

    /*public int getbId() {
        return bId;
    }

    public void setbId(int bId) {
        this.bId = bId;
    }

    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName;
    }

    public BlogType() {
    }

    public BlogType(int bId, String bName) {
        this.bId = bId;
        this.bName = bName;
    }*/
}
