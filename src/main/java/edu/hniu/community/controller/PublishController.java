package edu.hniu.community.controller;

import edu.hniu.community.service.PublishService;
import edu.hniu.community.service.UserInfoService;
import edu.hniu.community.vo.PublishSubmitVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/publish")
public class PublishController {

    @Autowired
    PublishService publishService;

    @Autowired
    UserInfoService userInfoService;

    @PostMapping("/submit")
    public Object publishMessage(@RequestBody PublishSubmitVo publishSubmitVo) {
        //根据Session中获取的email的值，来查找id。再把id插入question的createId列中。
        long userId = userInfoService.getIdByEmail(publishSubmitVo.getEmail());
        publishSubmitVo.setCreatorid(userId);
        return publishService.publishMessage(publishSubmitVo);
    }
}
