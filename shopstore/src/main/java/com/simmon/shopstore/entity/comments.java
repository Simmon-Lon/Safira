package com.simmon.shopstore.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class comments {
    private Integer pid;
    private String context;
    private Integer i_Id;
    private Integer Score;
    private String times;
    private Integer uid;
    private user user;

}
