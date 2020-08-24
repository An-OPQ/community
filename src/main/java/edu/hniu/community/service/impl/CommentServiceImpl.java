package edu.hniu.community.service.impl;

import edu.hniu.community.dao.CommentDao;
import edu.hniu.community.domain.Comment;
import edu.hniu.community.domain.Question;
import edu.hniu.community.domain.UserInfo;
import edu.hniu.community.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentDao commentDao;

    @Override
    public List<UserInfo> getAllComment(long id) {
        return commentDao.getAllComment(id);
    }

    @Override
    public boolean publishComment(Comment comment) {
        return commentDao.publishComment(comment)>0;
    }

    @Override
    public List<Comment> getAllCommentByQuestion(long questionId) {
        return commentDao.getAllCommentByQuestion(questionId);
    }
}
