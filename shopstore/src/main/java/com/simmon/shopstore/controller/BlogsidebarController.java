package com.simmon.shopstore.controller;


import com.simmon.shopstore.entity.BComment;
import com.simmon.shopstore.entity.BLeavingMessage;
import com.simmon.shopstore.entity.BTag;
import com.simmon.shopstore.entity.BlogType;
import com.simmon.shopstore.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/shopstore")
public class BlogsidebarController {
    @Autowired
    private BlogService BlogService;

    @GetMapping("/toBlogSidebar")
    public String toBlogSidebar(Model model){
        List<BTag> BTaglist =BlogService.getBTag();
        List<BComment> BCommentList = BlogService.getBComment();
        List<BlogType> BlogTypeList = BlogService.getBlogType();
        List<BLeavingMessage> BLeavingMessageList = BlogService.getBLeavingMessage();

        model.addAttribute("BLeavingMessageList",BLeavingMessageList);
        model.addAttribute("BlogTypeList",BlogTypeList);
        model.addAttribute("BCommentList",BCommentList);
        model.addAttribute("BTaglist",BTaglist);
        return "blogsidebar";
    }



}
