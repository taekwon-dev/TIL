package com.youn.pickgitinterceptor.configuration.auth_interceptor_register.scanner.package_scanner;

import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

import java.util.HashSet;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class PackageScanner {

    private final String basePackage;

    public PackageScanner(String basePackage) {
        this.basePackage = basePackage;
    }

    public List<String> getAllClassNames() {
        Reflections reflections = new Reflections(
            basePackage,
            new SubTypesScanner(false)
        );
        return new HashSet<>(reflections.getSubTypesOf(Object.class)).stream()
                .map(Class::getName)
                .collect(toList());
    }
}