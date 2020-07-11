package com.simmon.shopstore.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchProduct {

    //SafiraUnit
    private Integer unitId;
    private String unitName;

    //SafiraType
    private Integer tid;
    //类别名称
    private String tname;

    //SafiraProduct
    // 商品id主键(非空 25)p+两位数随机数+当前日期
    private String pid;
    // 商品名称
    private String pname;
    //类别名称
    //商品图片
    private String iId;
    // 商品评分
    private Integer pScore;
    //商品描述
    private String describe;
    //原价
    private Object originalprice;
   //折扣价
    private Object discountpirce;
    // 创建者
    private Integer createby;
    //创建时间
    private Date createbydate;
    //修改者
    private Integer modifyby;
    // 修改时间
    private Date modifydate;

    //SafiraImg
    private String Iid;
    private int size;
    private String src;
}
