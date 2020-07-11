package com.simmon.shopstore.service.impl;


import com.simmon.shopstore.entity.*;
import com.simmon.shopstore.repository.ShopDao;
import com.simmon.shopstore.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {
    @Autowired
    private ShopDao shopDao;

    @Override
    public List<product> getAllProduct() {
        List<product> slist = shopDao.getAllProduct();
        System.out.println(slist+"222");
        if (slist != null){
            return slist;
        }else{
            return null;
        }
    }

    @Override
    public List<type> selectType() {
        return shopDao.selectType();
    }

    @Override
    public product selectPidProduct(Integer pid) {
        return shopDao.selectPidProduct(pid);
    }

    @Override
    public List<product> selectidProduct(Integer tid,String pname) {
        System.out.println(tid+"tid"+pname+"pname");
        return shopDao.selectidProduct(tid,pname);
    }

    @Override
    public List<img> selectBigImgAll(Integer iid) {
        return shopDao.selectBigImgAll(iid);
    }

    @Override
    public List<img> selectSmallImgAll(Integer iid) {
        return shopDao.selectSmallImgAll(iid);
    }

    @Override
    public List<product> searchLowPrice() {
        return shopDao.searchLowPrice();
    }

    @Override
    public List<product> searchHigPrice() {
        return shopDao.searchHigPrice();
    }

    @Override
    public List<product> searchScore() {
        return shopDao.searchScore();
    }

    @Override
    public List<product> selectPices(product p) {
        return shopDao.selectPices(p);
    }

    @Override
    public int selectMax() {
        return shopDao.selectMax();
    }

    @Override
    public int selectMin() {
        return shopDao.selectMin();
    }

    @Override
    public List<comments> selectComments(Integer pid) {
        return shopDao.selectComments(pid);
    }

    @Override
    public int addCart(Carts carts) {
        return shopDao.addCart(carts);
    }

    @Override
    public Login selectLoginuser(String username) {
        return shopDao.selectLoginuser(username);
    }

    @Override
    public List<Carts> selectCart(Integer uid) {
        return shopDao.selectCart(uid);
    }

    @Override
    public int deleteCart(Integer cid) {
        return shopDao.deleteCart(cid);
    }

    @Override
    public int updateCountProduct(Integer count ,Integer cid) {
        return shopDao.updateCountProduct(count ,cid);
    }

    @Override
    public int addT(temp temp) {
        return shopDao.addT(temp);
    }

    @Override
    public List<temp> selectT() {
        return shopDao.selectT();
    }
}
