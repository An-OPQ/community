package edu.hniu.community.service;

import edu.hniu.community.vo.PublishSubmitVo;

public interface PublishService {
    /**
     * 帖子发布
     * @param publishSubmitVo
     * @return
     */
    boolean publishMessage(PublishSubmitVo publishSubmitVo);
}
