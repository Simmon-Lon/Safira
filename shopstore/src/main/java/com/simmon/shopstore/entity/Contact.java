package com.simmon.shopstore.entity;

import lombok.Data;

@Data
public class Contact {
    private Integer cid;
    private String cname;
    private String cemail;
    private String originalPrice;
    private String discountPirce;
}
