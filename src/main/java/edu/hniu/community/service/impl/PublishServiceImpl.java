package edu.hniu.community.service.impl;

import edu.hniu.community.dao.PublishDao;
import edu.hniu.community.domain.Question;
import edu.hniu.community.service.PublishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return publishDao.publishMessage(question) > 0;
    }

    @Override
    public List<Question> getPublishMessage() {
        return publishDao.getPublishMessage();
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
    public List<Question> getPublishMessageByModel(int modelId) {
        return publishDao.getPublishMessageByModel(modelId);
    }

    @Override
    public boolean updateQuestion(Question question) {
        return publishDao.updateQuestion(question)>0;
    }
}
