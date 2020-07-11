package com.simmon.shopstore.service;

import com.simmon.shopstore.entity.*;

import java.util.List;



public interface ShopService {
    /*查询所有的产品数据*/
    List<product> getAllProduct();
    /*查询分类表*/
    List<type> selectType();
    /*根据pid查询产品*/
    product selectPidProduct(Integer pid);
    /*根据tid类别查询*/
    List<product> selectidProduct(Integer tid,String pname);
    /*查询大图*/
    List<img> selectBigImgAll(Integer iid);
    /*查询小图*/
    List<img> selectSmallImgAll(Integer iid);
    /*低分查询*/
    List<product> searchLowPrice();
    /*高分查询*/
    List<product> searchHigPrice();
    /*高评分查询*/
    List<product> searchScore();
    /*价格之间的查询*/
    List<product> selectPices(product p);
    /*查询最大值*/
    int selectMax();
    /*查询最小值*/
    int selectMin();
    /*查询评论*/
    List<comments> selectComments(Integer pid);
    /*购物车增加*/
    int addCart(Carts carts);
    //根据查询用户名查找到id
    Login selectLoginuser(String username);
    /*查询用户添加到购物车的商品*/
    List<Carts> selectCart(Integer uid);
    /*删除购物车商品*/
    int deleteCart(Integer cid);
    /*数量更新*/
    int updateCountProduct(Integer count,Integer cid);
    /*增加团队*/
    int addT(temp temp);
    /*查询团队*/
    List<temp> selectT();
}
