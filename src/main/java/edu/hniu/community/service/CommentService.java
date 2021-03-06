package edu.hniu.community.service;

import edu.hniu.community.domain.Comment;
import edu.hniu.community.domain.UserInfo;

import java.util.List;

public interface CommentService {


    /**
     * 查询question
     *
     * @param id
     * @return
     */
    List<UserInfo> getAllComment(long id);

    /**
     * 发布评论
     * @return
     */
    boolean publishComment(Comment comment);

    /**
     * 查询所有的评论
     * @param questionId
     * @return
     */
    List<UserInfo> getAllCommentByQuestion(long questionId);
}
