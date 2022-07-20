package edu.hniu.community.toolkit;

import edu.hniu.community.domain.UserInfo;
import edu.hniu.community.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * @author jerry
 */
@Service
public class UpdateTokenByCookie {

    @Autowired
    private UserInfoService userInfoService;

    /**
     * 取出共同代码，在登录与注册成功后，设置一个随机UUID token存放在cookie中。并保存到数据库中
     * 然后在拦截器中，取出cookie的value去数据库中查询email的值，
     * 再存入Session中，这样就可以保存登录态。
     *
     * @param falg
     * @param userInfo
     * @param response
     */
    public void updateTokenByCookie(boolean falg, UserInfo userInfo, HttpServletResponse response, HttpServletRequest request) {
        if (falg) {
            String token = UUID.randomUUID().toString();
            String email = userInfo.getEmail();
            //把cookie的值(token)保存在数据库中
            userInfoService.updateToken(token, email);
            Cookie cookie = new Cookie("token", token);
            cookie.setMaxAge(24 * 60 * 60);
            cookie.setPath("/");
            response.addCookie(cookie);
            if (email != null) {
                request.getSession().setAttribute(token, email);
            }
        }
    }
}
