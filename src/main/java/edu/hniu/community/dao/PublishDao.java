package edu.hniu.community.dao;

import edu.hniu.community.domain.Question;
import edu.hniu.community.vo.PublishSubmitVo;

import java.util.List;

public interface PublishDao {

    /**
     * 帖子发布
     * @param publishSubmitVo
     * @return
     */
    int publishMessage(PublishSubmitVo publishSubmitVo);


    /**
     * 查询所有帖子
     * @return
     */
    List<Question> getPublishMessage();
}
