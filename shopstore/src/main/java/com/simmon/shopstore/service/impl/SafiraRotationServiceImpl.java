package com.simmon.shopstore.service.impl;


import com.simmon.shopstore.entity.SafiraImg;
import com.simmon.shopstore.entity.SafiraProduct;
import com.simmon.shopstore.entity.SafiraType;
import com.simmon.shopstore.entity.SearchProduct;
import com.simmon.shopstore.repository.SafiraRotationMapper;
import com.simmon.shopstore.service.SafiraRotationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SafiraRotationServiceImpl implements SafiraRotationService {

    @Autowired
    SafiraRotationMapper mapper;

    @Override
    public List<SafiraImg> getSafiraImgn() {
        System.out.println("查询图片"+mapper.getSafiraImgn());
        return mapper.getSafiraImgn();
    }

    @Override
    public List<SafiraType> getType() {
        System.out.println("商品分类"+mapper.getType());
        return mapper.getType();
    }

    @Override
    public List<SafiraProduct> getSafiraProduct() {
        System.out.println("商品信息:"+mapper.getSafiraProduct());
        return mapper.getSafiraProduct();
    }

    @Override
    public List<SearchProduct> searchSafiraProduct(String pname) {
        System.out.println("搜索"+mapper.searchSafiraProduct(pname));
        return mapper.searchSafiraProduct(pname);
    }


}
