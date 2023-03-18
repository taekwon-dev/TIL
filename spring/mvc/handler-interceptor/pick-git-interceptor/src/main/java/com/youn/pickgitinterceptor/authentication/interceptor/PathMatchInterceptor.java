package com.youn.pickgitinterceptor.authentication.interceptor;

import org.springframework.http.HttpMethod;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.util.PathMatcher;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;

public class PathMatchInterceptor implements HandlerInterceptor {

    private final HandlerInterceptor target;
    private final HashMap<String, List<HttpMethod>> includeRegistry;
    private final HashMap<String, List<HttpMethod>> excludeRegistry;
    private final PathMatcher pathMatcher;

    public PathMatchInterceptor(HandlerInterceptor target) {
        this.target = target;
        this.pathMatcher = new AntPathMatcher();
        this.includeRegistry = new HashMap<>();
        this.excludeRegistry = new HashMap<>();
    }

    public PathMatchInterceptor addPathPatterns(String pattern, List<HttpMethod> methods) {
        includeRegistry.putIfAbsent(pattern, methods);
        return this;
    }

    public PathMatchInterceptor excludePatterns(String pattern, List<HttpMethod> methods) {
        excludeRegistry.putIfAbsent(pattern, methods);
        return this;
    }

    @Override
    public boolean preHandle(
        HttpServletRequest request,
        HttpServletResponse response,
        Object handler
    ) throws Exception {
        String requestUrl = request.getRequestURI();
        String requestMethod = request.getMethod();

        for (String url : excludeRegistry.keySet()) {
            boolean isMethodMatch = excludeRegistry.get(url).stream()
                    .map(Enum::name)
                    .anyMatch(method -> method.equals(requestMethod));
            if (pathMatcher.match(url, requestUrl) && isMethodMatch) {
                return true;
            }
        }

        for (String url : includeRegistry.keySet()) {
            boolean isMethodMatch = includeRegistry.get(url)
                    .stream()
                    .map(Enum::name)
                    .anyMatch(method -> method.equals(requestMethod));
            if (pathMatcher.match(url, requestUrl) && isMethodMatch) {
                return target.preHandle(request, response, handler);
            }
        }

        return true;
    }

    @Override
    public void postHandle(
        HttpServletRequest request,
        HttpServletResponse response,
        Object handler,
        ModelAndView modelAndView
    ) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(
        HttpServletRequest request,
        HttpServletResponse response,
        Object handler,
        Exception ex
    ) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}