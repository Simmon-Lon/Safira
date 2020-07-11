package com.simmon.shopstore.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Carts {
    @Generated()
    private Integer cid;
    private String cname;
    private double pPrice;
    private String imgSrc;
    private String mode;
    private Integer pid;
    private Integer uid;
    private Integer status;
    private String orderTime;
    private Integer count;
}
