package edu.hniu.community.dao;

import edu.hniu.community.domain.Comment;
import edu.hniu.community.domain.Question;
import edu.hniu.community.domain.QuestionType;
import edu.hniu.community.domain.UserInfo;

import java.util.List;

public interface CommentDao {

    /**
     * 查询question
     *
     * @param id
     * @return
     */
    List<UserInfo> getAllComment(long id);

    /**
     * 发布评论
     *
     * @return
     */
    int publishComment(Comment comment);

    /**
     * 查询所有的评论
     * @param questionId
     * @return
     */
    List<UserInfo> getAllCommentByQuestion(long questionId);

    /**
     *  question的编辑
     * @param id
     * @return
     */
    Question getQuestionAndModel(long id);
}
