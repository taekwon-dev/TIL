package com.youn.pickgitinterceptor.configuration.auth_interceptor_register.scanner.data_structure;

import com.youn.pickgitinterceptor.configuration.auth_interceptor_register.register_type.RegisterType;
import org.springframework.http.HttpMethod;

public class MergedInterceptorParameterByMethod {

    private final String url;
    private final HttpMethod httpMethod;
    private final RegisterType registerType;

    public MergedInterceptorParameterByMethod(
        String url,
        HttpMethod httpMethod,
        RegisterType registerType
    ) {
        this.url = url;
        this.httpMethod = httpMethod;
        this.registerType = registerType;
    }

    public String getUrl() {
        return url;
    }

    public HttpMethod getHttpMethod() {
        return httpMethod;
    }

    public RegisterType getRegisterType() {
        return registerType;
    }
}