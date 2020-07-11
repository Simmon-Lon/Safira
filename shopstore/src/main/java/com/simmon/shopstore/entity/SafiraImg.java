package com.simmon.shopstore.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class SafiraImg implements Serializable {
    private static final long serialVersionUID = -12162661695575466L;
    private String Iid;
    private int size;
    private String src;

    /*public SafiraImg(String iid, int size, String src) {
        Iid = iid;
        this.size = size;
        this.src = src;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getIid() {
        return Iid;
    }

    public void setIid(String iid) {
        Iid = iid;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public SafiraImg() {
    }*/
}
