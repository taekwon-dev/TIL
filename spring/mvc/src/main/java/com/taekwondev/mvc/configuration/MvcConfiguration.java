package com.taekwondev.mvc.configuration;

import com.taekwondev.mvc.controller.TestInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by Youn on 2022/05/27.
 * Title :
 * Hint  :
 */

@Configuration
public class MvcConfiguration implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(testInterceptor()).addPathPatterns("/posts");
    }

    private TestInterceptor testInterceptor() {
        return new TestInterceptor();
    }

}
