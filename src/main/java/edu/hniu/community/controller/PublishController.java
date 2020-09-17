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

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

/**
 * @author jerry
 */
@RestController
@RequestMapping("/publish")
public class PublishController {

    @Autowired
    PublishService publishService;

    @Autowired
    UserInfoService userInfoService;

    @Value("${PageHelper.questionPageSize}")
    private int questionPageSize;

    @PostMapping("/submit")
    public Object publishMessage(@RequestBody Question question) {
        System.out.println(question);
        return publishService.publishMessage(question);
    }

    /**
     * 查询所有的帖子
     *
     * @return
     */
    @GetMapping("/getPublishMessage")
    public Object getPublishMessage(@RequestParam Integer pageNo) {
        PageHelper.startPage(pageNo, questionPageSize);
        List<Question> questionList = publishService.getPublishMessage();
        PageInfo<Question> pageInfo = new PageInfo<Question>(questionList);
        return pageInfo;
    }

    /**
     * 查询所有的帖子根据模块来查询
     *
     * @return
     */
    @GetMapping("/getPublishMessageByModel/{pageNo}/{modelId}")
    public Object getPublishMessageByModel(@PathVariable Integer pageNo, @PathVariable int modelId) {
        PageHelper.startPage(pageNo, questionPageSize);
        List<Question> questionList = publishService.getPublishMessageByModel(modelId);
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
