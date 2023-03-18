package com.youn.pickgitinterceptor.configuration.auth_interceptor_register.scanner;

import com.youn.pickgitinterceptor.configuration.auth_interceptor_register.ForOnlyLoginUser;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class ForOnlyLoginScanner {

    public List<Method> parseMethods(Class<?> controller) {
        return Arrays.stream(controller.getMethods())
                .filter(method -> method.isAnnotationPresent(ForOnlyLoginUser.class))
                .collect(toList());
    }
}