package edu.hniu.community.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import edu.hniu.community.dao.ManagementDao;
import edu.hniu.community.domain.UserInfo;
import edu.hniu.community.service.MailService;
import edu.hniu.community.service.ManagementService;
import edu.hniu.community.service.UserInfoService;
import edu.hniu.community.toolkit.GetSessionValue;
import edu.hniu.community.toolkit.MD5;
import edu.hniu.community.toolkit.UpdateTokenByCookie;
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

    @Value("${PageHelper.pageSize}")
    private int pageSize;

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
     * @return
     */
    @GetMapping("getAllUserinfo")
    public Object getAllUserinfo(@RequestParam Integer pageNo){
        PageHelper.startPage(pageNo,pageSize);
        List<UserInfo> userInfoList=managementService.getAllUserinfo();
        PageInfo<UserInfo> userInfoPageInfo=new PageInfo<UserInfo>(userInfoList);
        return userInfoPageInfo;
    }
}
