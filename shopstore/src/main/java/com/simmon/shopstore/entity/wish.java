package com.simmon.shopstore.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class wish {
    private Integer wid;
    private String wname;
    private double wprice;
    private String wimgSrc;
    private Integer goods;
    private Integer pid;
    private Integer uid;
    private String orderTime;
}
