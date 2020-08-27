package edu.hniu.community.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private SessionInterceptor sessionInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(sessionInterceptor).addPathPatterns("");
//                .excludePathPatterns("login.html")
//                .excludePathPatterns("main.html")
//                .excludePathPatterns("/**/*.html")
//                .excludePathPatterns("/**/*.js")
//                .excludePathPatterns("/**/*.css")
//                .excludePathPatterns("/**/*.png")
//                .excludePathPatterns("/**/*.jpg");
    }
}
