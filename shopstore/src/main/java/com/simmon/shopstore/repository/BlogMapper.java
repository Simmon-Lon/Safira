package com.simmon.shopstore.repository;


import com.simmon.shopstore.entity.BComment;
import com.simmon.shopstore.entity.BLeavingMessage;
import com.simmon.shopstore.entity.BTag;
import com.simmon.shopstore.entity.BlogType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogMapper {
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
