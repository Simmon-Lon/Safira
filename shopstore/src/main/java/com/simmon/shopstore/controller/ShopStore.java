package com.simmon.shopstore.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.simmon.shopstore.entity.*;
import com.simmon.shopstore.repository.contactRepository;
import com.simmon.shopstore.repository.faqRepository;
import com.simmon.shopstore.repository.loginRepository;
import com.simmon.shopstore.repository.serviceRepository;
import com.simmon.shopstore.service.SafiraRotationService;
import com.simmon.shopstore.service.ShopService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/shopstore")
public class ShopStore {
    @Autowired
    private contactRepository contactRepository;
    @Autowired
    private faqRepository faqRepository;
    @Autowired
    private loginRepository loginRepository;
    @Autowired
    private serviceRepository serviceRepository;
    @Autowired
    private SafiraRotationService SafiraRotationService;
    @Autowired
    private ShopService shopService;

    @GetMapping("/{url}")
    public String login(@PathVariable("url") String url){
        return url;
    }

    @GetMapping("/service")
    public String service(Model model){
        List<Service> list=serviceRepository.findAll();
        model.addAttribute("list",list);
        return "services";
    }

    @PostMapping("/register")
    public String register(String lusername,String lpassword,Model model,@RequestParam(value = "pageNumber",defaultValue = "1") Integer pageNumber,
                           @RequestParam(value = "tid",defaultValue = "0") Integer tid){
        Subject subject= SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken(lusername,lpassword);
        try{
            subject.login(token);
            Login login=(Login) subject.getPrincipal();
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
            Collections.shuffle(wetilme);
            PageHelper.startPage(pageNumber,8);
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
            model.addAttribute("username",lusername);
            subject.getSession().setAttribute("username",login);

            return "index-4";
        }catch (UnknownAccountException e){
            e.printStackTrace();
            model.addAttribute("msg","用户名错误");
            return "login";
        }catch (IncorrectCredentialsException e){
            e.printStackTrace();
            model.addAttribute("msg","密码错误");
            return "login";
        }
    }


    @PostMapping("/logon")
    public String logon(String lusername,String lpassword){
        Login login=new Login();
        login.setLusername(lusername);
        login.setLpassword(lpassword);
        loginRepository.logon(login);
        return "login";
    }

    @GetMapping("/faq")
    public String faq(Model model){
        model.addAttribute("list",faqRepository.findAll());
        return "faq";
    }

    @PostMapping("/save")
    public String save(String cname,String cemail,String originalPrice,String discountPirce,Model model){
        Contact contact=new Contact();
        contact.setCname(cname);
        contact.setCemail(cemail);
        contact.setOriginalPrice(originalPrice);
        contact.setDiscountPirce(discountPirce);
        contactRepository.save(contact);
        model.addAttribute("msg","发送成功");
        return "contact";
    }

    @GetMapping("/logout")
    public String logout(){
        Subject subject=SecurityUtils.getSubject();
        subject.logout();
        return "login";
    }
}
