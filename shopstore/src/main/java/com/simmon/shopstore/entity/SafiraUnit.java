package com.simmon.shopstore.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class SafiraUnit implements Serializable {
    private static final long serialVersionUID = -66497830229823538L;
    /**
     * 单位id
     */
    private Integer unitId;
    /**
     * 单位名称
     */
    private String unitName;

    /*public SafiraUnit(Integer unitId, String unitName) {
        this.unitId = unitId;
        this.unitName = unitName;
    }

    public SafiraUnit() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }*/
}
