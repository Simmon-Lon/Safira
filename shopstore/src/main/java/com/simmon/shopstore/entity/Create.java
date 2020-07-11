package com.simmon.shopstore.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Create {
    private Integer cid;
    private  Integer uid;
    private String  pname;
    private double pice;
    private Integer count;
    private double total;
}
