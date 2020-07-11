package com.simmon.shopstore.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 评论表
 */
@Data
public class BComment implements Serializable {
    private int cId;//评论id
    private String cName;//评论名称
    private String cContent;//评论内容
    private Date cTiem;//评论时间
    private String cEmail;//邮箱
    private String cWebSite;//评论人网站
    private String cImg;//图片

    /*public BComment() {
    }

    public BComment(int cId, String cName, String cContent, Date cTiem, String cEmail, String cWebSite, String cImg) {
        this.cId = cId;
        this.cName = cName;
        this.cContent = cContent;
        this.cTiem = cTiem;
        this.cEmail = cEmail;
        this.cWebSite = cWebSite;
        this.cImg = cImg;
    }

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcContent() {
        return cContent;
    }

    public void setcContent(String cContent) {
        this.cContent = cContent;
    }

    public Date getcTiem() {
        return cTiem;
    }

    public void setcTiem(Date cTiem) {
        this.cTiem = cTiem;
    }

    public String getcEmail() {
        return cEmail;
    }

    public void setcEmail(String cEmail) {
        this.cEmail = cEmail;
    }

    public String getcWebSite() {
        return cWebSite;
    }

    public void setcWebSite(String cWebSite) {
        this.cWebSite = cWebSite;
    }

    public String getcImg() {
        return cImg;
    }

    public void setcImg(String cImg) {
        this.cImg = cImg;
    }*/
}
