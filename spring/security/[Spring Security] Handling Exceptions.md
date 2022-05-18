# [Spring Security] Handling Exceptions

###  | ExceptionTranslationFilter

> Handles any `AccessDeniedException` and `AuthenticationException` thrown within the filter chain. This filter is necessary because it provides <u>the bridge between Java exceptions and HTTP responses</u>. It is solely concerned with maintaining the user interface. This filter does not do any actual security enforcement.

> To use this filter, it is <u>necessary</u> to specify the following properties:
>
> - `authenticationEntryPoint` indicates the handler that should commence the authentication process if an `AuthenticationException` is detected. Note that this may also switch the current protocol from http to https for an SSL login.
> - `requestCache` determines the strategy used to save a request during the authentication process in order that it may be retrieved and reused once the user has authenticated. The default implementation is [`HttpSessionRequestCache`](https://docs.spring.io/spring-security/site/docs/current/api/org/springframework/security/web/savedrequest/HttpSessionRequestCache.html).

### | Exceptions 

###### - AuthenticationException (인증 예외)

###### - AccessDeniedException (인가 예외)

___

### | Authentication Exception 

\# ExceptionTranslationFilter 

> If an [`AuthenticationException`](https://docs.spring.io/spring-security/site/docs/current/api/org/springframework/security/core/AuthenticationException.html) is detected, the filter will launch the `authenticationEntryPoint`. This allows common handling of authentication failures originating from any subclass of [`AbstractSecurityInterceptor`](https://docs.spring.io/spring-security/site/docs/current/api/org/springframework/security/access/intercept/AbstractSecurityInterceptor.html).

```java
public interface AuthenticationEntryPoint {

	/**
	 * Commences an authentication scheme.
	 * 
	 * ExceptionTranslationFilter will populate the HttpSession
	 * attribute named
	 * AbstractAuthenticationProcessingFilter.SPRING_SECURITY_SAVED_REQUEST_KEY
	 * with the requested target URL before calling this method.
	 * 
	 * Implementations should modify the headers on the ServletResponse as
	 * necessary to commence the authentication process.
	 * @param request that resulted in an AuthenticationException
	 * @param response so that the user agent can begin authentication
	 * @param authException that caused the invocation
	 */
	void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException)
			throws IOException, ServletException;

}

```







### | AccessDeniedException

> If an [`AccessDeniedException`](https://docs.spring.io/spring-security/site/docs/current/api/org/springframework/security/access/AccessDeniedException.html) is detected, the filter will determine whether or not the user is an anonymous user. If they are an anonymous user, the `authenticationEntryPoint` will be launched. If they are not an anonymous user, the filter will delegate to the [`AccessDeniedHandler`](https://docs.spring.io/spring-security/site/docs/current/api/org/springframework/security/web/access/AccessDeniedHandler.html). By default the filter will use [`AccessDeniedHandlerImpl`](https://docs.spring.io/spring-security/site/docs/current/api/org/springframework/security/web/access/AccessDeniedHandlerImpl.html).













### | Reference

###### https://docs.spring.io/spring-security/site/docs/current/api/org/springframework/security/web/access/ExceptionTranslationFilter.html
