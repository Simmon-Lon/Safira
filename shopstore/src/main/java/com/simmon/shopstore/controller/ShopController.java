package com.simmon.shopstore.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.simmon.shopstore.entity.comments;
import com.simmon.shopstore.entity.img;
import com.simmon.shopstore.entity.product;
import com.simmon.shopstore.entity.type;
import com.simmon.shopstore.entity.temp;
import com.simmon.shopstore.service.impl.ShopServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.List;

@Controller

public class ShopController {
    @Autowired
    private ShopServiceImpl shopService;

    /*查询商品产展示页
     * */
    @RequestMapping(value = "/shopList", method = RequestMethod.GET)
    public String ShopList(Model model, @RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,@RequestParam(value = "username",defaultValue = "null") String username) {
        PageHelper.startPage(pageNumber, 10);
        List<product> slist = shopService.getAllProduct();
        System.out.println("我爱你你发啥都能放假手动滑稽付女士DAU积分"+username);
        PageInfo<product> page = new PageInfo(slist, 10);
        //查询分类
        List<type> types = shopService.selectType();
        model.addAttribute("pageInfo", page);
        //查询类别表 传到页面
        model.addAttribute("types", types);
        model.addAttribute("username",username);
        return "shop-list";
    }

    //商品详情页的展示
    @RequestMapping(value = "/productdetails",method = RequestMethod.GET)
    public String productdetails(Model model, @RequestParam(value = "pid") Integer pid, HttpServletRequest request,
               @RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber, @RequestParam(value = "tid") Integer tid,
                                 @RequestParam(value = "username",defaultValue = "null") String username) {
        //查询所有商品的集合
        List<product> slist = shopService.getAllProduct();
        //根据iid查询大小图片
        List<img> BigImg = shopService.selectBigImgAll(pid);
        List<img> SmallImg = shopService.selectSmallImgAll(pid);
        product product = shopService.selectPidProduct(pid);
        //进入sql判断  当pname=null时
        String pname = null;
        List<product> tlist = shopService.selectidProduct(tid, pname);
        model.addAttribute("slist", slist);
        PageHelper.startPage(pageNumber, 5);
        PageInfo<product> page = new PageInfo(slist, 5);
        /*评论表*/
        List<comments> comments = shopService.selectComments(pid);
        System.out.println(username+"我是商品详情页");
        model.addAttribute("username",username);
        model.addAttribute("comments", comments);
        model.addAttribute("pageInfo", page);
        model.addAttribute("slist", slist);
        model.addAttribute("product", product);
        model.addAttribute("tidproduct", tlist);
        //传送查询的图片信息
        model.addAttribute("big", BigImg);
        model.addAttribute("small", SmallImg);
        return "product-details";
    }
    /*
     * 查询以pid的值返回的数据
     * 跳转到详情展示页
     * */
    @RequestMapping(value = "/productpid", method = RequestMethod.GET)
    public String productdetailspid(Model model, @RequestParam(value = "pid") Integer pid, @RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber) {
        List<product> slist = shopService.getAllProduct();
        Collections.shuffle(slist);
        product product = shopService.selectPidProduct(pid);
        model.addAttribute("slist", slist);
        PageHelper.startPage(pageNumber, 5);
        PageInfo<product> page = new PageInfo(slist, 5);
        model.addAttribute("pageInfo", page);
        model.addAttribute("slist", slist);
        model.addAttribute("product", product);
        return "product-details";
    }

    @RequestMapping(value = "/searchs", method = RequestMethod.POST)
    public String searchTid(HttpServletRequest request, Model model, @RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,@RequestParam(value = "username",defaultValue = "null") String username) {

        PageHelper.startPage(pageNumber, 8);
        Integer tid = Integer.parseInt(request.getParameter("searchtid"));
        String pname = request.getParameter("searchpname");
        List<type> types = shopService.selectType();
        if (tid == 0 && pname == "") {
            List<product> search = shopService.getAllProduct();
            PageInfo<product> page = new PageInfo(search, 8);
            model.addAttribute("username",username);
            model.addAttribute("types", types);
            model.addAttribute("pageInfo", page);
            return "shop-list";
        }
        if (tid != 0 && pname != "") {
            List<product> search = shopService.getAllProduct();
            PageInfo<product> page = new PageInfo(search, 8);
            model.addAttribute("username",username);
            model.addAttribute("types", types);
            model.addAttribute("pageInfo", page);
            return "shop-list";
        }
        List<product> search = shopService.selectidProduct(tid, pname);
        PageInfo<product> page = new PageInfo(search, 8);
        model.addAttribute("username",username);
        model.addAttribute("types", types);
        model.addAttribute("pageInfo", page);
        return "shop-list";
    }
    /*综合查询类*/
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String searchAll(
            @RequestParam(value = "tid", defaultValue = "0") Integer tid
            , @RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber
            , @RequestParam(value = "pice", defaultValue = "1") Integer pice
            , @RequestParam(value = "score", defaultValue = "1") Integer score, Model model,
            @RequestParam("username") String username,
            HttpServletRequest request) {
        //公共部分 类别表显示需求
        //查询分类
        List<type> types = shopService.selectType();
        //查询类别表 传到页面
        model.addAttribute("types", types);
        /*价格为1代表高价格排序*/
        if (tid == 0) {
            if (pice == 1) {
                PageHelper.startPage(pageNumber, 8);
                List<product> hig = shopService.searchHigPrice();
                PageInfo<product> page = new PageInfo(hig, 8);
                model.addAttribute("pageInfo", page);
                model.addAttribute("username",username);
                return "shop-list";
            }
            /*低价格排序*/
            if (pice == 0) {
                PageHelper.startPage(pageNumber, 8);
                List<product> low = shopService.searchLowPrice();
                PageInfo<product> page = new PageInfo(low, 8);
                model.addAttribute("pageInfo", page);
                model.addAttribute("username",username);
                return "shop-list";
            }
            /*默认排序*/
            if (pice == 2) {
                PageHelper.startPage(pageNumber, 8);
                List<product> product = shopService.getAllProduct();
                Collections.shuffle(product);
                PageInfo<product> page = new PageInfo(product, 8);
                model.addAttribute("pageInfo", page);
                model.addAttribute("username",username);
                return "shop-list";
            }
            /*按评分高排序*/
            if (score == 1) {
                PageHelper.startPage(pageNumber, 8);
                List<product> scores = shopService.searchScore();
                PageInfo<product> page = new PageInfo(scores, 8);
                model.addAttribute("pageInfo", page);
                model.addAttribute("username",username);
                return "shop-list";
            }
        } else {
            PageHelper.startPage(pageNumber, 8);
            List<product> tlist = shopService.selectidProduct(tid, null);
            PageInfo<product> page = new PageInfo(tlist, 8);
            model.addAttribute("pageInfo", page);
            model.addAttribute("username",username);
            //传送查询的图片信息
            return "shop-list";
        }
        return "shop-list";
    }
    @RequestMapping(value = "/picess", method = RequestMethod.POST)
    public String pices(Model model, HttpServletRequest request, @RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
                        @RequestParam(value = "tid", defaultValue = "0") Integer tid, @RequestParam(value = "mins", defaultValue = "null") String mins,
                        @RequestParam(value = "maxs", defaultValue = "null") String maxs,@RequestParam("username") String username) {
        /*获得最大值最小值  根据价格区间查询  默认最大最小*/
        String picesId = request.getParameter("picesId");
        //将分类查询返回到商品展示页
        List<type> types = shopService.selectType();
        model.addAttribute("types", types);
        model.addAttribute("username",username);
        //查询分类(我们给了默认值 0 当为0是就说明tid为空了  我们则自己定义获得最大值最小值区间 返回给页面)
        if (tid == 0 || tid == null) {
            PageHelper.startPage(pageNumber, 8);
            product p = new product();
            p.setMaxs(maxs);
            p.setMins(mins);
            List<product> picess = shopService.selectPices(p);
            Collections.shuffle(picess);
            PageInfo<product> page = new PageInfo(picess, 8);
            model.addAttribute("pageInfo", page);
            model.addAttribute("username",username);
            return "shop-list";
        }
        return "shop-list";
    }

    @RequestMapping("/a")
    public String a(Model model){
        return "addtemp";
    }
/*合作增加*/
    @RequestMapping("/addtemp")
    public String addComments(Model model,
     @RequestParam("name") String name,
      @RequestParam("phone") String phone,
      @RequestParam("email") String email,
      @RequestParam("tempname") String tempname,
      @RequestParam("address") String address,
       @RequestParam("Reason") String Reason
    ) {
        temp temp = new temp();
        temp.setName(name);
        temp.setPhone(phone);
        temp.setEmail(email);
        temp.setAddress(address);
        temp.setTempname(tempname);
        temp.setReason(Reason);
        int result =  shopService.addT(temp);
        List<temp> list = shopService.selectT();
        model.addAttribute("list",list);
        return "wishlist";
    }
    @RequestMapping("/temps")
    public String selec(Model model
    ) {
        return "addtemp";
    }
    /*查询合作*/
    @RequestMapping("/selectT")
    public String selectT(Model model
    ) {
        List<temp> list = shopService.selectT();
        model.addAttribute("list",list);
        return "wishlist";
    }
}
