package edu.hniu.community.controller;

import edu.hniu.community.domain.UserInfo;
import edu.hniu.community.service.MailService;
import edu.hniu.community.service.UserInfoService;
import edu.hniu.community.toolkit.MD5;
import javafx.beans.binding.ObjectExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserInfoService userInfoService;

    @Autowired
    MailService mailService;

    @PostMapping("/login")
    public Object loginController(@RequestBody UserInfo userInfo) {
        userInfo = MD5.encode(userInfo);
        return userInfoService.loginCheck(userInfo);
    }

    @PostMapping("/register")
    public Object register(@RequestBody UserInfo userInfo) {
        userInfo = MD5.encode(userInfo);
        return userInfoService.register(userInfo);
    }

    @PostMapping("/mailVerify")
    public Object jumpToReset(@RequestParam String verifyCode, HttpSession session) {
        //若Session中没有对应的验证码，或没有验证码则返回false；
        try {
            String verify = session.getAttribute("verifyCode").toString();
            if (verify.equals(verifyCode)) {
                session.invalidate();
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    @PutMapping("/resetPassword")
    public Object resetPassword(@RequestBody UserInfo userInfo) {
        userInfo = MD5.encode(userInfo);
        return userInfoService.resetPassword(userInfo);
    }

    @GetMapping("/getCaptcha")
    public Object getCaptCha(@RequestParam String mail, HttpSession session) {
        //将验证码放入session中
        int code = (int) ((Math.random() * 9 + 1) * 100000);
        session.setAttribute("verifyCode", code);
        //设置session有效时间，默认是1800s
        session.setMaxInactiveInterval(300);
        return mailService.sendSimpleMail(mail, "欢饮加入后山论坛", "验证码为：" + code + "。有效期为5分钟");
    }

    @GetMapping("/findUserByEmail/{email}")
    public void findUserByEmail(@PathVariable String email, HttpServletResponse response) throws IOException {
        boolean falg = userInfoService.findUserByEmail(email);
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        if (falg) {
            response.getWriter().print("<font color='red' fontsize='80%'>这个邮箱已经被注册了，请勿重复注册！</font>");
        } else {
            response.getWriter().print("<font color='green' fontsize='80%'>您可以使用该邮箱注册</font>");
        }
    }
}
