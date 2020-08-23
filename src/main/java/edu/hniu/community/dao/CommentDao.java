package edu.hniu.community.dao;

import edu.hniu.community.domain.Comment;
import edu.hniu.community.domain.UserInfo;

import java.util.List;

public interface CommentDao {

    /**
     * 查询question
     * @param id
     * @return
     */
    List<UserInfo> getAllComment(long id);

    /**
     * 发布评论
     * @return
     */
    int publishComment(Comment comment);
}