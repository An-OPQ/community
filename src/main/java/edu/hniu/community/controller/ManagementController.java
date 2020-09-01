package edu.hniu.community.controller;

import edu.hniu.community.dao.ManagementDao;
import edu.hniu.community.domain.UserInfo;
import edu.hniu.community.service.MailService;
import edu.hniu.community.service.ManagementService;
import edu.hniu.community.service.UserInfoService;
import edu.hniu.community.toolkit.GetSessionValue;
import edu.hniu.community.toolkit.MD5;
import edu.hniu.community.toolkit.UpdateTokenByCookie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author jerry
 */
@RestController
@RequestMapping("/management")
public class ManagementController {

    @Autowired
    ManagementService managementService;

    @Autowired
    UpdateTokenByCookie updateTokenByCookie;

    @PostMapping("/loginCheck")
    public Object loginCheck(@RequestBody UserInfo userInfo, HttpServletResponse response, HttpServletRequest request) {
        userInfo = MD5.encode(userInfo);
        boolean falg = managementService.loginCheck(userInfo);
        updateTokenByCookie.updateTokenByCookie(falg, userInfo, response, request);
        return falg;
    }
}
