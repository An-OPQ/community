package edu.hniu.community.service.impl;

import edu.hniu.community.dao.PublishDao;
import edu.hniu.community.service.PublishService;
import edu.hniu.community.vo.PublishSubmitVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublishServiceImpl implements PublishService {

    @Autowired
    PublishDao publishDao;

    @Override
    public boolean publishMessage(PublishSubmitVo publishSubmitVo) {
        return publishDao.publishMessage(publishSubmitVo)>0;
    }
}
