package edu.hniu.community.service;

import edu.hniu.community.domain.Question;

import java.util.List;

/**
 * @author jerry
 */
public interface PublishService {
    /**
     * 帖子发布
     * @param question
     * @return
     */
    boolean publishMessage(Question question);

    /**
     * 查询所有帖子
     * @return
     */
    List<Question> getPublishMessage();

    /**
     * 查询所有帖子根据模块来查询
     * @param modelId
     * @return
     */
    List<Question> getPublishMessageByModel(int modelId);

    /**
     * 更新阅读数
     * @param id
     * @return
     */
    boolean updateViewCount(Integer id);

    /**
     * 更新回复数
     *
     * @param id
     * @return
     */
    boolean updateCommentCount(Integer id);

    /**
     * 更新点赞数
     *
     * @param id
     * @return
     */
    boolean addLikeCount(Integer id);

    /**
     * less点赞数
     * @param id
     * @return
     */
    boolean lessLikeCount(Integer id);
}
