package com.youn.pickgitinterceptor.configuration.auth_interceptor_register;

import com.youn.pickgitinterceptor.configuration.auth_interceptor_register.register_type.RegisterType;
import com.youn.pickgitinterceptor.configuration.auth_interceptor_register.scanner.ControllerScanner;
import com.youn.pickgitinterceptor.configuration.auth_interceptor_register.scanner.ForLoginAndGuestScanner;
import com.youn.pickgitinterceptor.configuration.auth_interceptor_register.scanner.ForOnlyLoginScanner;
import com.youn.pickgitinterceptor.configuration.auth_interceptor_register.scanner.HttpMethodMapper;
import com.youn.pickgitinterceptor.configuration.auth_interceptor_register.scanner.data_structure.InterceptorParameter;
import com.youn.pickgitinterceptor.configuration.auth_interceptor_register.scanner.data_structure.MergedInterceptorParameterByMethod;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class UriParser {

    private static final String REGEX = "\\{.*?.}";

    private final ControllerScanner controllerScanner;
    private final ForLoginAndGuestScanner forLoginAndGuestScanner;
    private final ForOnlyLoginScanner forOnlyLoginScanner;

    public UriParser(
        ControllerScanner controllerScanner,
        ForLoginAndGuestScanner forLoginAndGuestScanner,
        ForOnlyLoginScanner forOnlyLoginScanner
    ) {
        this.controllerScanner = controllerScanner;
        this.forLoginAndGuestScanner = forLoginAndGuestScanner;
        this.forOnlyLoginScanner = forOnlyLoginScanner;
    }

    public List<MergedInterceptorParameterByMethod> getMergedInterceptorParameterByMethod() {
        return controllerScanner.getControllers().stream()
                .flatMap(controller -> createMergedInterceptorParameterByMethods(controller).stream())
                .collect(toList());
    }

    private List<MergedInterceptorParameterByMethod> createMergedInterceptorParameterByMethods(
            Class<?> controller) {
        List<String> prefixUrlsFromController = getPrefixUrlsFromController(controller);
        List<InterceptorParameter> interceptorParameters = interceptorParameter(controller);

        List<MergedInterceptorParameterByMethod> mergedInterceptorParameterByMethods = new ArrayList<>();

        prefixUrlsFromController.forEach(
                prefix -> mergedInterceptorParameterByMethods.addAll(
                        createMergedInterceptorParameterByMethod(interceptorParameters, prefix)
                )
        );

        return mergedInterceptorParameterByMethods;
    }

    private List<String> getPrefixUrlsFromController(Class<?> typeToken) {
        RequestMapping requestMapping = typeToken.getDeclaredAnnotation(RequestMapping.class);

        if (requestMapping == null) {
            return List.of("");
        }

        return List.of(requestMapping.value());
    }

    private List<InterceptorParameter> interceptorParameter(Class<?> controller) {
        List<InterceptorParameter> result = new ArrayList<>();

        result.addAll(createInterceptorParameter(
                forOnlyLoginScanner.parseMethods(controller),
                RegisterType.AUTHENTICATE));

        result.addAll(createInterceptorParameter(
                forLoginAndGuestScanner.parseMethods(controller),
                RegisterType.IGNORE_AUTHENTICATE));

        return result;
    }

    private List<InterceptorParameter> createInterceptorParameter(
            List<Method> methods,
            RegisterType registerType
    ) {
        return methods.stream()
                .map(toInterceptorParameter(registerType))
                .collect(toList());
    }

    private Function<Method, InterceptorParameter> toInterceptorParameter(
            RegisterType registerType
    ) {
        return method -> new InterceptorParameter(
                parseUrlsFromMethod(method),
                parseHttpMethod(method),
                registerType
        );
    }

    private List<MergedInterceptorParameterByMethod> createMergedInterceptorParameterByMethod(
            List<InterceptorParameter> interceptorParameters,
            String prefix
    ) {
        List<MergedInterceptorParameterByMethod> mergedInterceptorParameterByMethods = new ArrayList<>();

        for (InterceptorParameter interceptorParameter : interceptorParameters) {
            HttpMethod httpMethod = interceptorParameter.getHttpMethod();
            RegisterType registerType = interceptorParameter.getRegisterType();
            List<String> urls = interceptorParameter.getUrls();

            List<MergedInterceptorParameterByMethod> values =
                    createMergedInterceptorParameterByMethods(prefix, httpMethod, registerType, urls);

            mergedInterceptorParameterByMethods.addAll(values);
        }

        return mergedInterceptorParameterByMethods;
    }

    private List<MergedInterceptorParameterByMethod> createMergedInterceptorParameterByMethods(
            String prefix,
            HttpMethod httpMethod,
            RegisterType registerType,
            List<String> urls
    ) {
        if (urls.isEmpty()) {
            urls = new ArrayList<>(urls);
            urls.add("");
        }

        return urls.stream()
                .map(url -> createUri(prefix, url))
                .map(completeUrl -> new MergedInterceptorParameterByMethod(
                        completeUrl,
                        httpMethod,
                        registerType
                ))
                .collect(toList());
    }

    private List<String> parseUrlsFromMethod(Method method) {
        return HttpMethodMapper.extractMappingValues(method);
    }

    private HttpMethod parseHttpMethod(Method method) {
        return HttpMethodMapper.findHttpMethodByControllerMethod(method);
    }

    private String createUri(String... urlPieces) {
        String createdUri = "/" + Arrays.stream(urlPieces)
                .flatMap(urlPiece -> Arrays.stream(urlPiece.split("/")))
                .filter(urlPiece -> !urlPiece.isBlank())
                .collect(joining("/"));

        return createdUri.replaceAll(REGEX, "*");
    }
}