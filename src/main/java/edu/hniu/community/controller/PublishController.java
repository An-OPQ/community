package edu.hniu.community.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import edu.hniu.community.domain.Question;
import edu.hniu.community.service.PublishService;
import edu.hniu.community.service.UserInfoService;
import edu.hniu.community.vo.PublishSubmitVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/publish")
public class PublishController {

    @Autowired
    PublishService publishService;

    @Autowired
    UserInfoService userInfoService;

    @Value("${PageHelper.pageSize}")
    private int pageSize;

    @PostMapping("/submit")
    public Object publishMessage(@RequestBody PublishSubmitVo publishSubmitVo) {
        //根据Session中获取的email的值，来查找id。再把id插入question的createId列中。
        long userId = userInfoService.getIdByEmail(publishSubmitVo.getEmail());
        publishSubmitVo.setCreatorid(userId);
        return publishService.publishMessage(publishSubmitVo);
    }

    /**
     * 查询所有的帖子
     *
     * @return
     */
    @GetMapping("/getPublishMessage")
    public Object getPublishMessage(@RequestParam Integer pageNo) {
        PageHelper.startPage(pageNo, pageSize);
        List<Question> questionList = publishService.getPublishMessage();
        PageInfo<Question> pageInfo = new PageInfo<Question>(questionList);
        return pageInfo;
    }

    @PutMapping("/updateViewCount")
    public Object updateViewCount(@RequestParam Integer id) {
        return publishService.updateViewCount(id);
    }

    @PutMapping("/updateCommentCount")
    public Object updateCommentCount(@RequestParam Integer id) {
        return publishService.updateCommentCount(id);
    }

    @PutMapping("/addLikeCount")
    public Object addLikeCount(@RequestParam Integer id) {
        return publishService.addLikeCount(id);
    }

    @PutMapping("/lessLikeCount")
    public Object lessLikeCount(@RequestParam Integer id) {
        return publishService.lessLikeCount(id);
    }


}
