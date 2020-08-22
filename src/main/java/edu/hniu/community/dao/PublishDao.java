package edu.hniu.community.dao;

import edu.hniu.community.vo.PublishSubmitVo;

public interface PublishDao {

    /**
     * 帖子发布
     * @param publishSubmitVo
     * @return
     */
    int publishMessage(PublishSubmitVo publishSubmitVo);
}
