package edu.hniu.community.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import edu.hniu.community.domain.Advert;
import edu.hniu.community.domain.UserInfo;
import edu.hniu.community.service.ManagementService;
import edu.hniu.community.toolkit.MD5;
import edu.hniu.community.toolkit.UpdateTokenByCookie;
import edu.hniu.community.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author jerry
 */
@RestController
@RequestMapping("/management")
public class ManagementController {

    @Autowired
    ManagementService managementService;

    @Value("${PageHelper.questionPageSize}")
    private int questionPageSize;

    @Value("${PageHelper.usermangerPageSize}")
    private int usermangerPageSize;

    @Autowired
    UpdateTokenByCookie updateTokenByCookie;

    /**
     * 对前端输入密码加密，再去验证。
     * 同时更新Cookie中的Token（令牌）到数据库中
     * @param userInfo
     * @param response
     * @param request
     * @return
     */
    @PostMapping("/loginCheck")
    public Object loginCheck(@RequestBody UserInfo userInfo, HttpServletResponse response, HttpServletRequest request) {
        userInfo = MD5.encode(userInfo);
        boolean flag = managementService.loginCheck(userInfo);
        updateTokenByCookie.updateTokenByCookie(flag, userInfo, response, request);
        return flag;
    }

    /**
     * 涉及多个用户的权限，service层统一查询所有。controller统一返回结果。前端控制权限发送不同的参数
     * @return
     */
    @PostMapping("getAllUserinfo")
    public Object getAllUserinfo(@RequestBody AuthoritySearchVo authoritySearchVo) {
        PageHelper.startPage(authoritySearchVo.getPageNo(), usermangerPageSize);
        List<userAndRoleListVo> userAndRoleListVoList = managementService.getAllUserinfo(authoritySearchVo.getArray());
        return new PageInfo<>(userAndRoleListVoList);
    }

    @DeleteMapping("/deleteUser")
    public Object deleteUser(@RequestParam Integer id) {
        return managementService.deleteUser(id);
    }

    /**
     * 管理员权限下修改用户密码
     *
     * @param userInfo
     */
    @PutMapping("/resetPassword")
    public Object resetPassword(@RequestBody UserInfo userInfo) {
        userInfo = MD5.encode(userInfo);
        return managementService.resetPassword(userInfo);
    }

    /**
     * 接受前端添加用户的参数，最后插入到数据库中
     * @param userInfo
     * @return
     */
    @PostMapping("/addUserInfo")
    public Object addUserInfo(@RequestBody UserInfo userInfo) {
        userInfo = MD5.encode(userInfo);
        return managementService.addUserInfo(userInfo);
    }

    /**
     * 查询所有的role表格
     * @return
     */
    @GetMapping("/getAddzuId")
    public Object getAddzuId() {
        return managementService.getAddzuId();
    }

    /**
     * 查询所有的question，返回List结果集
     * @return
     */
    @GetMapping("/getAllQusetion")
    public Object getAllQusetion(@RequestParam Integer pageNo) {
        PageHelper.startPage(pageNo, questionPageSize);
        List<QuestionListVo> questionListVos = managementService.getAllQusetion();
        return new PageInfo<QuestionListVo>(questionListVos);
    }

    /**
     * 获取前端传递的ID,再返回删除后TRUE or FALSE
     * @param id
     * @return
     */
    @DeleteMapping("/deleteQuestion")
    public Object deleteQuestion(@RequestParam Integer id) {
        return managementService.deleteQuestion(id);
    }

    /**
     * 查询所有的板块
     * @return
     */
    @GetMapping("/getAllTagName")
    public Object getAllTagName() {
        return managementService.getAllTagName();
    }

    /**
     * 删除板块
     * @param id
     * @return
     */
    @DeleteMapping("/deleteTagById/{id}")
    public Object deleteTagById(@PathVariable(name = "id") int id) {
        return managementService.deleteTagById(id);
    }

    @PostMapping("/addTag")
    public Object addTag(@RequestBody QuestionTypeVo questionTypeVo) {
        return managementService.addTag(questionTypeVo);
    }

    @PostMapping("/publishNotice")
    public Object publishNotice(@RequestBody NoticeVo noticeVo) {
        return managementService.publishNotice(noticeVo);
    }

    @GetMapping("/getNotice")
    public Object getNotice() {
        return managementService.getNotice();
    }

    /**
     * 更新通知，返回TRUE orFALSE
     * @param noticeVo
     * @return
     */
    @PutMapping("/updateNotice")
    public Object updateNotice(@RequestBody NoticeVo noticeVo) {
        return managementService.updateNotice(noticeVo);
    }

    /**
     * 发布广告，将前端传递的参数保存到数据库
     * @param advert
     * @return
     */
    @PostMapping("/publishAdvert")
    public Object publishAdvert(@RequestBody Advert advert) {
        return managementService.publishAdvert(advert);
    }

    @PostMapping("/searchQuestion")
    public Object searchQuestion(@RequestBody searchQuestionVo searchQuestionVo) {
        PageHelper.startPage(searchQuestionVo.getPageNo(), questionPageSize);
        List<QuestionListVo> questionListVos = managementService.searchQuestion(searchQuestionVo);
        return new PageInfo<>(questionListVos);
    }

    /**
     * 批量删除，接受前端参数数组。
     * @param array
     * @return
     */
    @DeleteMapping("/deleteBatch")
    public Object deleteBatch(@RequestBody int[] array) {
        return managementService.deleteBatch(array);
    }

    /**
     * 模糊查询，接收前端参数。并将查询的结果返回给前端
     * @param searchUserVo
     * @return
     */
    @PostMapping("/searchUser")
    public Object searchUser(@RequestBody searchUserVo searchUserVo) {
        PageHelper.startPage(searchUserVo.getPageNo(), usermangerPageSize);
        List<userAndRoleListVo> userAndRoleListVoList = managementService.searchUser(searchUserVo);
        return new PageInfo<>(userAndRoleListVoList);
    }

    @GetMapping("/getAllComment")
    public Object getAllComment(@RequestParam Integer pageNo) {
        PageHelper.startPage(pageNo, questionPageSize);
        List<AllCommentVo> allCommentVoList = managementService.getAllComment();
        return new PageInfo<>(allCommentVoList);
    }

    @DeleteMapping("/deleteComment")
    public Object deleteComment(@RequestBody AllCommentVo allCommentVo) {
        return managementService.deleteComment(allCommentVo);
    }

    /**
     * 置顶精华帖
     *
     * @param id
     * @return
     */
    @GetMapping("/topPost")
    public Object topPost(@RequestParam long id) {
        return managementService.topPost(id);
    }
}
