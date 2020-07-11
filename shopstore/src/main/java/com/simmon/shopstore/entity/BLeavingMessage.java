package com.simmon.shopstore.entity;

import lombok.Data;

import java.util.Date;

/**
 * 留言表
 */
@Data
public class BLeavingMessage {
    private int lId;//留言表id
    private String lPeople;//留言人
    private Date lTime;//留言时间
    private String lContemt;//留言内容

    /*public int getlId() {
        return lId;
    }

    public void setlId(int lId) {
        this.lId = lId;
    }

    public String getlPeople() {
        return lPeople;
    }

    public void setlPeople(String lPeople) {
        this.lPeople = lPeople;
    }

    public Date getlTime() {
        return lTime;
    }

    public void setlTime(Date lTime) {
        this.lTime = lTime;
    }

    public String getlContemt() {
        return lContemt;
    }

    public void setlContemt(String lContemt) {
        this.lContemt = lContemt;
    }

    public BLeavingMessage() {
    }

    public BLeavingMessage(int lId, String lPeople, Date lTime, String lContemt) {
        this.lId = lId;
        this.lPeople = lPeople;
        this.lTime = lTime;
        this.lContemt = lContemt;
    }*/
}
