package edu.hniu.community.service;

import edu.hniu.community.domain.Question;
import edu.hniu.community.vo.PublishSubmitVo;

import java.util.List;

public interface PublishService {
    /**
     * 帖子发布
     * @param publishSubmitVo
     * @return
     */
    boolean publishMessage(PublishSubmitVo publishSubmitVo);

    /**
     * 查询所有帖子
     * @return
     */
    List<Question> getPublishMessage();
}
