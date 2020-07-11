package com.simmon.shopstore.controller;

import com.simmon.shopstore.entity.BComment;
import com.simmon.shopstore.entity.BLeavingMessage;
import com.simmon.shopstore.entity.BTag;
import com.simmon.shopstore.entity.BlogType;
import com.simmon.shopstore.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/shopstore")
public class BologController {

    @Autowired
    private BlogService BlogService;

    @PostMapping("/doBComment")
    public String doBComment(String cContent, String cName,
                             String cEmail,String cWebSite){
        System.out.println("cContent:"+cContent+"---cName:"+cName+"---cEmail:"+cEmail+"---cWebSite"+cWebSite);
        BComment bComment=new BComment();
        bComment.setCContent(cContent);
        bComment.setCName(cName);
        bComment.setCEmail(cEmail);
        bComment.setCWebSite(cWebSite);

        int ok = BlogService.insertBComment(bComment);
        System.out.println(BlogService.insertBComment(bComment));
        return "redirect:/shopstore/toBlogDetails";
    }
    @GetMapping("/toBlogDetails")
    public String blogDetails(Model model){
        List<BTag> BTaglist =BlogService.getBTag();
        List<BComment> BCommentList = BlogService.getBComment();
        List<BlogType> BlogTypeList = BlogService.getBlogType();
        List<BLeavingMessage> BLeavingMessageList = BlogService.getBLeavingMessage();

        model.addAttribute("BLeavingMessageList",BLeavingMessageList);
        model.addAttribute("BlogTypeList",BlogTypeList);
        model.addAttribute("BCommentList",BCommentList);
        model.addAttribute("BTaglist",BTaglist);

        return "blogdetails";
    }



}
