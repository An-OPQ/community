package edu.hniu.community.dao;

import edu.hniu.community.domain.Question;
import edu.hniu.community.vo.searchQuestionVo;

import java.util.List;

/**
 * @author jerry
 */
public interface PublishDao {

    /**
     * 帖子发布
     *
     * @param question
     * @return
     */
    int publishMessage(Question question);


    /**
     * 查询所有帖子
     *
     * @return
     */
    List<Question> getPublishMessage();

    /**
     * 搜索帖子
     * @param searchQuestionVo
     * @return
     */
    List<Question> searchQuestion(searchQuestionVo searchQuestionVo);

    /**
     * 更新阅读数
     *
     * @param id
     * @return
     */
    int updateViewCount(Integer id);

    /**
     * 更新回复数
     *
     * @param id
     * @return
     */
    int updateCommentCount(Integer id);

    /**
     * add点赞数
     *
     * @param id
     * @return
     */
    int addLikeCount(Integer id);

    /**
     * less点赞数
     * @param id
     * @return
     */
    int lessLikeCount(Integer id);

    /**
     * 更新question
     * @param question
     * @return
     */
    int updateQuestion(Question question);
}
