package com.youn.pickgitinterceptor.configuration.auth_interceptor_register.register_type;

import com.youn.pickgitinterceptor.authentication.interceptor.PathMatchInterceptor;
import org.springframework.http.HttpMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IgnoreAuthenticateStorageForRegisterType implements StorageForRegisterType {

    private static final RegisterType TYPE = RegisterType.IGNORE_AUTHENTICATE;
    private final Map<String, List<HttpMethod>> cache = new HashMap<>();

    @Override
    public void appendTo(PathMatchInterceptor include) {
        cache.forEach(include::addPathPatterns);
    }

    @Override
    public boolean isSatisfiedBy(RegisterType registerType) {
        return registerType == TYPE;
    }

    @Override
    public void put(String url, HttpMethod method) {
        List<HttpMethod> httpMethods = cache.computeIfAbsent(url, key -> new ArrayList<>());
        httpMethods.add(method);
    }

    @Override
    public RegisterType getType() {
        return TYPE;
    }
}