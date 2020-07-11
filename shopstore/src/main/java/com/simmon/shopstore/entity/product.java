package com.simmon.shopstore.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class product {
    private Integer pid;
    private String pname;
    private Integer tid;
    private String i_Id;
    private Integer pScore;
    private String describe;
    private String sourceaddress;
    private Double originalPrice;
    private Double discountPirce;
    private Integer unitIid;
    private Integer createby;
    private String createbyDate;
    private Integer modifyby;
    private String modifyDate;
    private type type;
    private unit unit;
    private comments comments;
    private user user;
    private img img;
    private String maxs;
    private String mins;
}
