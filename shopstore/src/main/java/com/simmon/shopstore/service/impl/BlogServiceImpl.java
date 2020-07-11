package com.simmon.shopstore.service.impl;


import com.simmon.shopstore.entity.BComment;
import com.simmon.shopstore.entity.BLeavingMessage;
import com.simmon.shopstore.entity.BTag;
import com.simmon.shopstore.entity.BlogType;
import com.simmon.shopstore.repository.BlogMapper;
import com.simmon.shopstore.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    BlogMapper mapper;

    @Override
    public List<BComment> getBComment() {
        System.out.println("博客留言表:"+mapper.getBComment());
        return mapper.getBComment();
    }

    @Override
    public List<BTag> getBTag() {
        System.out.println("标签："+mapper.getBTag());
        return mapper.getBTag();
    }

    @Override
    public List<BlogType> getBlogType() {
        System.out.println("类别表："+mapper.getBlogType());
        return mapper.getBlogType();
    }

    @Override
    public List<BLeavingMessage> getBLeavingMessage() {
        System.out.println("留言表："+mapper.getBLeavingMessage());
        return mapper.getBLeavingMessage();
    }

    @Override
    public int insertBComment(BComment bComment) {

        System.out.println("增加成功："+mapper.insertBComment(bComment));
        return mapper.insertBComment(bComment);
    }



}
