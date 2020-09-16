package edu.hniu.community.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import edu.hniu.community.domain.Notice;
import edu.hniu.community.domain.QuestionType;
import edu.hniu.community.domain.UserInfo;
import edu.hniu.community.service.ManagementService;
import edu.hniu.community.toolkit.MD5;
import edu.hniu.community.toolkit.UpdateTokenByCookie;
import edu.hniu.community.vo.NoticeVo;
import edu.hniu.community.vo.QuestionListVo;
import edu.hniu.community.vo.QuestionTypeVo;
import edu.hniu.community.vo.userAndRoleListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

/**
 * @author jerry
 */
@RestController
@RequestMapping("/management")
public class ManagementController {

    @Autowired
    ManagementService managementService;

    @Value("${PageHelper.usermangerPageSize}")
    private int usermangerPageSize;


    @Autowired
    UpdateTokenByCookie updateTokenByCookie;

    @PostMapping("/loginCheck")
    public Object loginCheck(@RequestBody UserInfo userInfo, HttpServletResponse response, HttpServletRequest request) {
        userInfo = MD5.encode(userInfo);
        boolean falg = managementService.loginCheck(userInfo);
        updateTokenByCookie.updateTokenByCookie(falg, userInfo, response, request);
        return falg;
    }

    /**
     * 涉及多个用户的权限，service层统一查询所有。controller分类
     *
     * @return
     */
    @GetMapping("getAllUserinfo")
    public Object getAllUserinfo(@RequestParam Integer pageNo) {
        PageHelper.startPage(pageNo, usermangerPageSize);
        List<userAndRoleListVo> userAndRoleListVoList = managementService.getAllUserinfo();
        PageInfo<userAndRoleListVo> userAndRoleListVoPageInfo = new PageInfo<userAndRoleListVo>(userAndRoleListVoList);
        return userAndRoleListVoPageInfo;
    }

    @DeleteMapping("/deleteUser")
    public Object deleteUser(@RequestParam Integer id) {
        return managementService.deleteUser(id);
    }

    /**
     * 管理员权限下修改用户密码
     *
     * @param userInfo
     * @return
     */
    @PutMapping("/resetPassword")
    public Object resetPassword(@RequestBody UserInfo userInfo) {
        userInfo = MD5.encode(userInfo);
        System.out.println(userInfo.toString());
        return managementService.resetPassword(userInfo);
    }

    /**
     * 管理员权限下添加账户
     *
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
     *
     * @return
     */
    @GetMapping("/getAddzuId")
    public Object getAddzuId() {
        return managementService.getAddzuId();
    }

    /**
     * 查询所有的questione
     *
     * @return
     */
    @GetMapping("/getAllQusetion")
    public Object getAllQusetion(@RequestParam Integer pageNo) {
        PageHelper.startPage(pageNo, usermangerPageSize);
        List<QuestionListVo> questionListVos = managementService.getAllQusetion();
        return new PageInfo<QuestionListVo>(questionListVos);
    }

    @DeleteMapping("/deleteQuestion")
    public Object deleteQuestion(@RequestParam Integer id) {
        return managementService.deleteQuestion(id);
    }

    @GetMapping("/getAllTagName")
    public Object getAllTagName() {
        return managementService.getAllTagName();
    }

    @DeleteMapping("/deleteTagById/{id}")
    public Object deleteTagById(@PathVariable(name = "id") int id) {
        return managementService.deleteTagById(id);
    }

    @PostMapping("/addTag")
    public Object addTag(@RequestBody QuestionTypeVo questionTypeVo) {
        return managementService.addTag(questionTypeVo);
    }

    @PostMapping("/publishAdvert")
    public Object publishAdvert(@RequestBody NoticeVo noticeVo){
        return managementService.publishAdvert(noticeVo);
    }
}
