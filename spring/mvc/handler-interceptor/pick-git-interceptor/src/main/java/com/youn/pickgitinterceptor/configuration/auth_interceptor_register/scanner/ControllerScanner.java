package com.youn.pickgitinterceptor.configuration.auth_interceptor_register.scanner;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class ControllerScanner {

    private final List<String> classNames;

    public ControllerScanner(List<String> classNames) {
        this.classNames = classNames;
    }

    public List<Class<?>> getControllers() {
        return classNames.stream()
                .map(this::getClassByClassName)
                .filter(this::isController)
                .collect(toList());
    }

    private Class<?> getClassByClassName(String className) {
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException("", e);
        }
    }

    private boolean isController(Class<?> type) {
        return type.isAnnotationPresent(Controller.class) ||
                type.isAnnotationPresent(RestController.class);
    }
}