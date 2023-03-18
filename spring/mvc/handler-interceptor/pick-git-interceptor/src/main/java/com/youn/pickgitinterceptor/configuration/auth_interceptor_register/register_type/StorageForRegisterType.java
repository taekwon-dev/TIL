package com.youn.pickgitinterceptor.configuration.auth_interceptor_register.register_type;

import com.youn.pickgitinterceptor.authentication.interceptor.PathMatchInterceptor;
import org.springframework.http.HttpMethod;

public interface StorageForRegisterType {

    void appendTo(PathMatchInterceptor include);

    boolean isSatisfiedBy(RegisterType registerType);

    void put(String url, HttpMethod method);

    RegisterType getType();
}