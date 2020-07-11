package com.simmon.shopstore.service;



import com.simmon.shopstore.entity.SafiraImg;
import com.simmon.shopstore.entity.SafiraProduct;
import com.simmon.shopstore.entity.SafiraType;
import com.simmon.shopstore.entity.SearchProduct;

import java.util.List;

public interface SafiraRotationService {
    //查询播图片的方法 safira_img
    List<SafiraImg> getSafiraImgn();

    //主页查询分类 safira_type
    List<SafiraType> getType();

    //查询具体商品 safira_product
    List<SafiraProduct> getSafiraProduct();
    //搜索
    List<SearchProduct> searchSafiraProduct(String pname);
}
