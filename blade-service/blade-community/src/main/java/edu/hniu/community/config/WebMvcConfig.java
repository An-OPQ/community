package edu.hniu.community.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Value("${preread.uploadPath}")
    private String uploadPath;

    @Value("${preread.mappingPath}")
    private String mappingPath;

    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(mappingPath).addResourceLocations(uploadPath);
    }
}
