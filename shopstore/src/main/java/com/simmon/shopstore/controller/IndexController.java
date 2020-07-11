package com.simmon.shopstore.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.simmon.shopstore.entity.SafiraImg;
import com.simmon.shopstore.entity.SafiraProduct;
import com.simmon.shopstore.entity.SafiraType;
import com.simmon.shopstore.entity.product;
import com.simmon.shopstore.entity.type;
import com.simmon.shopstore.service.SafiraRotationService;
import com.simmon.shopstore.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/shopstore")
public class IndexController {
    //轮播
    @Autowired
    private SafiraRotationService SafiraRotationService;
    @Autowired
    private ShopService shopService;

    @GetMapping("/index")
    public String index(Model model,@RequestParam(value = "pageNumber",defaultValue = "1") Integer pageNumber,@RequestParam(value = "tid",defaultValue = "0") Integer tid){
        List<SafiraType> Typelists = SafiraRotationService.getType();
        List<SafiraImg> ImgList = SafiraRotationService.getSafiraImgn();
        List<SafiraProduct> ProductList = SafiraRotationService.getSafiraProduct();
        //轮播
        List<product> productlu = shopService.getAllProduct();
        Collections.shuffle(productlu);
        //畅销产品
        List<product> productchang = shopService.getAllProduct();
        Collections.shuffle(productchang);
        //新产品
        List<product> lists = shopService.getAllProduct();
        Collections.shuffle(lists);
        //我们的产品
        List<product> weproduct = shopService.getAllProduct();
        Collections.shuffle(weproduct);
        //时间位置我们的产品
        List<product> wetilme = shopService.getAllProduct();
        //查询type表
        List<type> types = shopService.selectType();
        //根据tid查询
        if (tid!=0) {
            PageHelper.startPage(pageNumber, 8);
            List<product> tlist = shopService.selectidProduct(tid, null);
            PageInfo<product> page = new PageInfo(tlist, 8);
            model.addAttribute("pageInfo", page);
            return "shop-list";
        }

        PageInfo<product> pageInfo = new PageInfo(lists,8);
        model.addAttribute("types",types);
        model.addAttribute("wetilme",wetilme);
        model.addAttribute("weproduct",weproduct);
        model.addAttribute("productchang",productchang);
        model.addAttribute("productlu",productlu);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("Typelists",Typelists);
        model.addAttribute("ProductList",ProductList);
        model.addAttribute("ImgList",ImgList);

        return "index-4";
    }

}
