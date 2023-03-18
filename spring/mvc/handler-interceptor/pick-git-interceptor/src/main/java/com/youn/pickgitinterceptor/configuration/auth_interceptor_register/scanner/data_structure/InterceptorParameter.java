package com.youn.pickgitinterceptor.configuration.auth_interceptor_register.scanner.data_structure;

import com.youn.pickgitinterceptor.configuration.auth_interceptor_register.register_type.RegisterType;
import org.springframework.http.HttpMethod;

import java.util.List;

public class InterceptorParameter {

    private final List<String> urls;
    private final HttpMethod httpMethod;
    private final RegisterType registerType;

    public InterceptorParameter(
        List<String> urls,
        HttpMethod httpMethod,
        RegisterType registerType
    ) {
        this.urls = urls;
        this.httpMethod = httpMethod;
        this.registerType = registerType;
    }

    public List<String> getUrls() {
        return urls;
    }

    public HttpMethod getHttpMethod() {
        return httpMethod;
    }

    public RegisterType getRegisterType() {
        return registerType;
    }
}