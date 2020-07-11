package com.simmon.shopstore.service;



import com.simmon.shopstore.entity.BComment;
import com.simmon.shopstore.entity.BLeavingMessage;
import com.simmon.shopstore.entity.BTag;
import com.simmon.shopstore.entity.BlogType;

import java.util.List;

public interface BlogService {

    //查询 博客评论表 bComment
    List<BComment> getBComment();

    //查询 博客标签 bTag
    List<BTag> getBTag();

    //查询分类表 blogtype
    List<BlogType> getBlogType();

    //查询留言
    List<BLeavingMessage> getBLeavingMessage();

    //增加一条评论
    int insertBComment(BComment bComment);
}
