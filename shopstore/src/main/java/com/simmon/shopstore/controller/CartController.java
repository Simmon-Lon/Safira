package com.simmon.shopstore.controller;


import com.simmon.shopstore.entity.Carts;
import com.simmon.shopstore.entity.Login;
import com.simmon.shopstore.entity.product;
import com.simmon.shopstore.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import java.text.DecimalFormat;
import java.util.List;

/*
 * 购物车
 *
 * */

@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    ShopService shopService;
    @Autowired
    StringRedisTemplate stringRedisTemplate;


    /*
     * 购物车
     *
     * */
    @RequestMapping("/addCart")
    public String addCart(@RequestParam(value = "username", defaultValue = "null") String username,
                          @RequestParam(value = "pid") Integer pid,@RequestParam(value = "count",defaultValue = "0") Integer count,
                          Model model) {
        System.out.println("ere67865" + username);
        if (username.equals("null") || username == "null") {
            return  "login";
        }else {
            Login login = shopService.selectLoginuser(username);
            Carts carts = new Carts();
            product pidList = shopService.selectPidProduct(pid);
            carts.setCname(pidList.getPname());
            if (pidList.getDiscountPirce() == 0) {
                carts.setPPrice(pidList.getOriginalPrice());
            } else {
                carts.setPPrice(pidList.getDiscountPirce());
            }
            if (count!=0){
                carts.setCount(count);
            }
            carts.setImgSrc(pidList.getImg().getSrc());
            carts.setMode(pidList.getUnit().getUnitName());
            carts.setPid(pidList.getPid());
            carts.setUid(login.getLid());
            int temp = shopService.addCart(carts);
            System.out.println("我是增加购物车页面" + temp);
            List<Carts> clist = shopService.selectCart(login.getLid());
            /*计算价格*/
            double prices = 0;
            for (Carts c : clist) {
                prices = prices + (c.getPPrice() * c.getCount());
            }
            DecimalFormat df = new DecimalFormat("0.00");
            df.format(prices);
            model.addAttribute("prices", (int) prices);
            model.addAttribute("username", username);
            model.addAttribute("pidList", clist);
            return "cart";
        }
    }




    @RequestMapping(value = "/addCartP",method = RequestMethod.POST)
    public String addCartP(@RequestParam(value = "username", defaultValue = "null") String username,
                          @RequestParam(value = "pid") Integer pid,@RequestParam(value = "count",defaultValue = "0") Integer count,
                          Model model) {
        if (username.equals("null") || username == "null") {
            return  "login";
        }else {
            Login login = shopService.selectLoginuser(username);
            Carts carts = new Carts();
            product pidList = shopService.selectPidProduct(pid);
            carts.setCname(pidList.getPname());
            if (pidList.getDiscountPirce() == 0) {
                carts.setPPrice(pidList.getOriginalPrice());
            } else {
                carts.setPPrice(pidList.getDiscountPirce());
            }
            carts.setImgSrc(pidList.getImg().getSrc());
            carts.setMode(pidList.getUnit().getUnitName());
            carts.setCount(count);
            carts.setPid(pidList.getPid());
            carts.setUid(login.getLid());
            int temp = shopService.addCart(carts);
            System.out.println("我是增加购物车页面" + temp);
            List<Carts> clist = shopService.selectCart(login.getLid());
            /*计算价格*/
            double prices = 0;
            for (Carts c : clist) {
                prices = prices + (c.getPPrice() * c.getCount());
            }
            DecimalFormat df = new DecimalFormat("0.00");
            df.format(prices);
            model.addAttribute("prices", (int) prices);
            model.addAttribute("username", username);
            model.addAttribute("pidList", clist);
            return "cart";
        }
    }





    /*删除购物车的产品*/
    @RequestMapping("/deleteCart")
    public String deleteCart(@RequestParam("cid") Integer cid, @RequestParam("username") String username, Model model) {
        int temp = shopService.deleteCart(cid);
        Login login = shopService.selectLoginuser(username);
        List<Carts> clist = shopService.selectCart(login.getLid());
        /*计算价格*/
        double prices = 0;
        for (Carts c : clist) {
            prices = prices + (c.getPPrice()*c.getCount());
        }
        DecimalFormat df = new DecimalFormat("0.00");
        df.format(prices);
        model.addAttribute("prices", (int) prices);
        model.addAttribute("username", username);
        model.addAttribute("pidList", clist);
        return "cart";
    }

    /*数量增加*/
    @RequestMapping(value = "/countCart")
        public String countCart(Model model,@RequestParam("cid") Integer cid, @RequestParam("count") Integer count,@RequestParam("username") String username){
        //map集合用来存放返回值
        Carts carts = new Carts();
        carts.setCount(count);
        carts.setCid(cid);
        int temp = shopService.updateCountProduct(count,cid);
        Login login = shopService.selectLoginuser(username);
        List<Carts> clist = shopService.selectCart(login.getLid());
        /*计算价格*/
        double prices = 0;
        for (Carts c : clist) {
            prices = prices + (c.getPPrice()*c.getCount());
        }
        DecimalFormat df = new DecimalFormat("0.00");
        df.format(prices);
        model.addAttribute("prices", (int) prices);
        model.addAttribute("username", username);
        model.addAttribute("pidList", clist);
        return "cart";
    }

    /*查看购物车*/
    @RequestMapping("/selectCart")
    public String selectScart(Model model,@RequestParam(value = "username",defaultValue = "null") String username){
        if (username == null|| username.equals("null")){
            return  "login";
        }
        Login login = shopService.selectLoginuser(username);

        List<Carts> clist = shopService.selectCart(login.getLid());
        /*计算价格*/
        double prices = 0;
        for (Carts c : clist) {
            prices = prices + (c.getPPrice() * c.getCount());
        }
        DecimalFormat df = new DecimalFormat("0.00");
        df.format(prices);
        model.addAttribute("username",username);
        model.addAttribute("prices",prices);
        model.addAttribute("pidList",clist);
        return "cart";
    }

    /*
    * 结算页面
    *
    * */
    @RequestMapping("/checkout")
    public String checkout(Model model,@RequestParam("username") String username){
        Login login = shopService.selectLoginuser(username);
        List<Carts> clist = shopService.selectCart(login.getLid());
        /*计算价格*/
        double prices = 0;
        for (Carts c : clist) {
            prices = prices + (c.getPPrice() * c.getCount());
        }
        DecimalFormat df = new DecimalFormat("0.00");
        df.format(prices);
        model.addAttribute("username",username);
        model.addAttribute("prices",prices);
        model.addAttribute("pidList",clist);
        return "checkout";
    }
    /*心愿单*/
    @RequestMapping("/wish")
    public  String Wish(Model model){

        return  "wishlist";
    }





}
