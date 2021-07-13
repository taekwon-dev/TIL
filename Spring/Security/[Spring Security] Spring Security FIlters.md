# [Spring Security] Spring Security FIlters 

아래 `Security Filters` 들은 `SecurityFilterChain` API 형태로 묶여서 `FilterChainProxy` 에 등록되어 있다. 서블릿 필터에서도 HTTP 요청에 적용되는 필터의 순서가 중요하듯이 아래 `Security Filters` 도 마찬가지로 필터가 적용되는 순서는 매우 중요하다. `Spring Security` 기반으로 인증/인가 로직을 전개할 때 각 필터가 적용되는 순서를 인지하는 것은 설계 또는 디버깅 과정에 많은 영향을 끼칠 수 있다. 

- ChannelProcessingFilter
- ChannelProcessingFilter
- WebAsyncManagerIntegrationFilter
- SecurityContextPersistenceFilter
- HeaderWriterFilter
- CorsFilter
- CsrfFilter
- LogoutFilter
- OAuth2AuthorizationRequestRedirectFilter
- Saml2WebSsoAuthenticationRequestFilter
- X509AuthenticationFilter
- AbstractPreAuthenticatedProcessingFilter
- CasAuthenticationFilter
- OAuth2LoginAuthenticationFilter
- Saml2WebSsoAuthenticationFilter
- [`UsernamePasswordAuthenticationFilter`](https://docs.spring.io/spring-security/site/docs/current/reference/html5/#servlet-authentication-usernamepasswordauthenticationfilter)
- OpenIDAuthenticationFilter
- DefaultLoginPageGeneratingFilter
- DefaultLogoutPageGeneratingFilter
- ConcurrentSessionFilter
- [`DigestAuthenticationFilter`](https://docs.spring.io/spring-security/site/docs/current/reference/html5/#servlet-authentication-digest)
- BearerTokenAuthenticationFilter
- [`BasicAuthenticationFilter`](https://docs.spring.io/spring-security/site/docs/current/reference/html5/#servlet-authentication-basic)
- RequestCacheAwareFilter
- SecurityContextHolderAwareRequestFilter
- JaasApiIntegrationFilter
- RememberMeAuthenticationFilter
- AnonymousAuthenticationFilter
- OAuth2AuthorizationCodeGrantFilter
- SessionManagementFilter
- [`ExceptionTranslationFilter`](https://docs.spring.io/spring-security/site/docs/current/reference/html5/#servlet-exceptiontranslationfilter)
- [`FilterSecurityInterceptor`](https://docs.spring.io/spring-security/site/docs/current/reference/html5/#servlet-authorization-filtersecurityinterceptor)
- SwitchUserFilter