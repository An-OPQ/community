package edu.hniu.community.toolkit;

import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Service
public class GetSessionValue {

    public String getSessionValue(HttpSession session, HttpServletRequest request) {
        String email = "";
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length != 0) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    String token = cookie.getValue();
                  try {
                      email =session.getAttribute(token).toString();
                  }catch (Exception ignored){
                  }
                }
            }
        }
        return email;
    }
}
