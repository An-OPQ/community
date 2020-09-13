package edu.hniu.community.dao;

import edu.hniu.community.domain.Question;
import edu.hniu.community.vo.PublishSubmitVo;

import java.util.List;

public interface PublishDao {

    /**
     * 帖子发布
     *
     * @param publishSubmitVo
     * @return
     */
    int publishMessage(PublishSubmitVo publishSubmitVo);


    /**
     * 查询所有帖子
     *
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
}
