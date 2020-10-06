package edu.hniu.community.service.impl;

import edu.hniu.community.dao.PublishDao;
import edu.hniu.community.domain.Question;
import edu.hniu.community.service.PublishService;
import edu.hniu.community.vo.searchQuestionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author jerry
 */
@Service
public class PublishServiceImpl implements PublishService {

    @Autowired
    PublishDao publishDao;

    @Override
    public boolean publishMessage(Question question) {
        return publishDao.publishMessage(question)>0;
    }

    @Override
    public List<Question> getPublishMessage() {
        return publishDao.getPublishMessage();
    }

    @Override
    public List<Question> searchQuestion(searchQuestionVo searchQuestionVo) {
        System.out.println(searchQuestionVo.toString());
        return publishDao.searchQuestion(searchQuestionVo);
    }

    @Override
    public boolean updateViewCount(Integer id) {
        return publishDao.updateViewCount(id)>0;
    }

    @Override
    public boolean updateCommentCount(Integer id) {
        return publishDao.updateCommentCount(id)>0;
    }

    @Override
    public boolean addLikeCount(Integer id) {
        return publishDao.addLikeCount(id)>0;
    }

    @Override
    public boolean lessLikeCount(Integer id) {
        return publishDao.lessLikeCount(id)>0;
    }

    @Override
    public boolean updateQuestion(Question question) {
        return publishDao.updateQuestion(question)>0;
    }

    @Override
    public boolean addQuestionLikeCount(Integer id) {
        return publishDao.addQuestionLikeCount(id)>0;
    }

    @Override
    public boolean lessQuestionLikeCount(Integer id) {
        return publishDao.lessQuestionLikeCount(id)>0;
    }
}
