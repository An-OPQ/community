package edu.hniu.community.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import edu.hniu.community.domain.Question;
import edu.hniu.community.domain.UserInfo;
import edu.hniu.community.service.MailService;
import edu.hniu.community.service.UserInfoService;
import edu.hniu.community.toolkit.GetSessionValue;
import edu.hniu.community.toolkit.MD5;
import edu.hniu.community.toolkit.UpdateTokenByCookie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserInfoService userInfoService;

    @Autowired
    MailService mailService;

    @Autowired
    UpdateTokenByCookie updateTokenByCookie;

    @Value("${PageHelper.usermangerPageSize}")
    private int usermangerPageSize;

    @Autowired
    GetSessionValue getSessionValue;

    @PostMapping("/login")
    public Object loginController(@RequestBody UserInfo userInfo, HttpServletResponse response, HttpServletRequest request) {
        userInfo = MD5.encode(userInfo);
        boolean flag = userInfoService.loginCheck(userInfo);
        updateTokenByCookie.updateTokenByCookie(flag, userInfo, response, request);
        return flag;
    }

    @PostMapping("/register")
    public Object register(@RequestBody UserInfo userInfo, HttpServletResponse response, HttpServletRequest request) {
        userInfo = MD5.encode(userInfo);
        boolean flag = userInfoService.register(userInfo);
        updateTokenByCookie.updateTokenByCookie(flag, userInfo, response, request);
        return flag;
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

    /**
     *获取前端提交参数，MD5加密。更新到数据库中
     * 返回 TRUE or FALSE
     * @param userInfo
     * @return
     */
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

    /**
     * 处理异步验证邮箱是否被注册，并将警告信息返回
     * @param email
     * @param response
     * @throws IOException
     */
    @GetMapping("/findUserByEmail/{email}")
    public void findUserByEmail(@PathVariable String email, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        if (!"null".equals(email)) {
            boolean flag = userInfoService.findUserByEmail(email);
            if (flag) {
                response.getWriter().print("<font color='red' fontsize='80%'>该邮箱已经被注册,请勿重复注册!</font>");
            } else {
                response.getWriter().print("<font color='green' fontsize='80%'>您可以使用该邮箱注册!</font>");
            }
        } else {
            response.getWriter().print("<font color='red' fontsize='80%'>邮箱不能为空!</font>");
        }
    }

    @GetMapping("/findUserByName/{addName}")
    public void findUserByName(@PathVariable String addName, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        if (!"null".equals(addName)) {
            boolean flag = userInfoService.findUserByName(addName);
            if (flag) {
                response.getWriter().print("<font color='red' fontsize='80%'>该用户名已经被使用!</font>");
            } else {
                response.getWriter().print("<font color='green' fontsize='80%'>该用户名可使用!</font>");
            }
        } else {
            response.getWriter().print("<font color='red' fontsize='80%'>用户名不能为空!</font>");
        }
    }


    @PutMapping("/updateMassge")
    public void updateMassge(@RequestBody UserInfo userInfo) {
        userInfoService.updateMassge(userInfo);
    }

    @GetMapping("/getUserConfig")
    public Object getUserConfig(@RequestParam String email) {
        return userInfoService.getUserConfig(email);
    }


    /**
     * 获取Session中的email的值，为了在所有页面中共享登录用户的信息。
     *
     * @param session
     * @return
     */
    @GetMapping("/getSession")
    public String getSession(HttpSession session, HttpServletRequest request) {
        return getSessionValue.getSessionValue(session, request);
    }

    /**
     * 登出
     * session.invalidate();为清除Session中的所有对象，而不清楚本身
     *
     * @param session
     */
    @GetMapping("/logout")
    public void logout(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        //清理cookie
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length != 0) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                }
            }
        }
        session.invalidate();
    }

    @GetMapping("/getAccountName")
    public Object getAccountName(HttpSession session, HttpServletRequest request) {
        String email = getSessionValue.getSessionValue(session, request);
        return userInfoService.getAccountName(email);
    }

    @PostMapping("/getQuestionByEmail/{email}/{pageNo}")
    public Object getQuestionByEmail(@PathVariable(name = "email") String email, @PathVariable(name = "pageNo") Integer pageNo) {
        PageHelper.startPage(pageNo, usermangerPageSize);
        List<Question> questionByEmail = userInfoService.getQuestionByEmail(email);
        PageInfo<Question> questionPageInfo = new PageInfo<Question>(questionByEmail);
        return questionPageInfo;
    }

    @GetMapping("/getAllCommentByEmail/{email}/{pageNo}")
    public Object getAllCommentByEmail(@PathVariable(name = "email") String email, @PathVariable(name = "pageNo") Integer pageNo) {
        PageHelper.startPage(pageNo, usermangerPageSize);
        List<UserInfo> userInfoList = userInfoService.getAllCommentByEmail(email);
        PageInfo<UserInfo> userInfoPageInfo = new PageInfo<UserInfo>(userInfoList);
        return userInfoPageInfo;
    }

    @GetMapping("/initModel")
    public Object initModel() {
        return userInfoService.initModel();
    }

    @GetMapping("/getIdByEmail")
    public Object getIdByEmail(@RequestParam String email) {
        return userInfoService.getIdByEmail(email);
    }

    @GetMapping("/getNotice")
    public Object getNotice() {
        return userInfoService.getNotice();
    }

    @GetMapping("/getAdvert")
    public Object getAdvert() {
        return userInfoService.getAdvert();
    }
}
