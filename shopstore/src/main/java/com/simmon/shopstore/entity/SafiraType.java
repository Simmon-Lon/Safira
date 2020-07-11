package com.simmon.shopstore.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class SafiraType implements Serializable {
    private static final long serialVersionUID = -12162661695575466L;
    /**
     * 类别编号
     */
    private Integer tid;
    /**
     * 类别名称
     */
    private String tname;

    /*public SafiraType(Integer tid, String tname) {
        this.tid = tid;
        this.tname = tname;
    }

    public SafiraType() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }*/
}

