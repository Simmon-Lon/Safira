package com.simmon.shopstore.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class user{
    /**
    * 用户编号
    */
    private Integer uid;
    /**
    * 用户账号
    */
    private String account;
    /**
    * 用户密码
    */
    private String password;
    /**
    * 姓名
    */
    private String name;
    /**
    * 头像(引用img表的id注册时（随机生成
    */
    private String iId;
    /**
    * 余额
    */
    private Object money;
    /**
    * 信誉度
    */
    private Integer credibility;
    /**
    * 邮箱
    */
    private String email;
    /**
    * 生日
    */
    private Object birthday;
    /**
    * 送货地址1
    */
    private String address1;
    /**
    * 创建者
    */
    private Integer createby;
    /**
    * 创建时间
    */
    private Date createbydate;
    /**
    * 修改者
    */
    private Integer modifyby;
    /**
    * 修改时间
    */
    private Date modifydate;
    /**
    * 账户状态，启用或者停用
    */
    private Object status;
    /**
    * 乐观锁
    */
    private Integer version;
    /**
    * 在线状态
    */
    private Object online;
    /**
    * 用户身份
    */
    private Integer identity;
}