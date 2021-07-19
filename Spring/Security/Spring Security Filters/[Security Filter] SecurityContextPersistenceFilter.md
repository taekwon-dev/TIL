# [Security Filter] SecurityContextPersistenceFilter



### | What to do 

`SecurityContextPersistenceFilter` 의 메인 역할은 세션에서 `SecurityContext`를 `SecurityContextHolder`에 할당하는 것이다. 이 역할과 책임으로, 로그인 상태를 전제로 하는 필터들이 `SecurityContextPersistenceFilter`에 의존적일 수 밖에 없다. 위에서 설명한 것 처럼 세션 정보에서 `SecurityContext`를 가져오는 역할은 `HttpSessionSecurityContextRepository`에서 처리하고, 이 외에도 기존 세션에서 `SecurityContext`를 찾지 못한 경우에는 새로운 `SecurityContext`를 생성하는 역할을 하고, 유저가 로그인하는 시점에 인증이 완료되면, 해당 유저의 정보를 기반으로 `SecurityContext`를 저장하는 등의 역할을 수행한다. 

### | 











### | Reference

###### https://docs.spring.io/spring-security/site/docs/3.2.8.RELEASE/apidocs/org/springframework/security/web/context/SecurityContextPersistenceFilter.html

###### https://www.programmersought.com/article/5943639580/

___

This filter will only execute once per request, to resolve servlet container (specifically Weblogic) imcompatibilities. 

This filter MUST be executed BEFORE any authentication processing mechanisms. Authentication processing mechanisms expect the `SecurityContextHolder` to contain a vaild `SecurityContext` by the time they execute. 

This is essentially a refactoring of the old `HttpSessionContextIntegrationFilter` to delegate the storage issues to a seperate strategy, allowing for more customization in the way the security context is maintained between requests. 

#### - readSecurityContextFromSession() on `HttpSessionSecurityContextRepository`

```java
...
    private SecurityContext readSecurityContextFromSession(HttpSession httpSession) {
        boolean debug = this.logger.isDebugEnabled();
        if (httpSession == null) {
            if (debug) {
                this.logger.debug("No HttpSession currently exists");
            }

            return null;
        } else {
            Object contextFromSession = httpSession.getAttribute(this.springSecurityContextKey);
            if (contextFromSession == null) {
                if (debug) {
                    this.logger.debug("HttpSession returned null object for SPRING_SECURITY_CONTEXT");
                }

                return null;
            } else if (!(contextFromSession instanceof SecurityContext)) {
                if (this.logger.isWarnEnabled()) {
                    this.logger.warn(this.springSecurityContextKey + " did not contain a SecurityContext but contained: '" + contextFromSession + "'; are you improperly modifying the HttpSession directly (you should always use SecurityContextHolder) or using the HttpSession attribute reserved for this class?");
                }

                return null;
            } else {
                if (debug) {
                    this.logger.debug("Obtained a valid SecurityContext from " + this.springSecurityContextKey + ": '" + contextFromSession + "'");
                }

                return (SecurityContext)contextFromSession;
            }
        }
    }  
...
```

#### - loadContext() on `HttpSessionSecurityContextRepository`

```java
...
    public SecurityContext loadContext(HttpRequestResponseHolder requestResponseHolder) {
        HttpServletRequest request = requestResponseHolder.getRequest();
        HttpServletResponse response = requestResponseHolder.getResponse();
        HttpSession httpSession = request.getSession(false);
        SecurityContext context = this.readSecurityContextFromSession(httpSession);
        if (context == null) {
            if (this.logger.isDebugEnabled()) {
                this.logger.debug("No SecurityContext was available from the HttpSession: " + httpSession + ". A new one will be created.");
            }

            context = this.generateNewContext();
        }

        HttpSessionSecurityContextRepository.SaveToSessionResponseWrapper wrappedResponse = new HttpSessionSecurityContextRepository.SaveToSessionResponseWrapper(response, request, httpSession != null, context);
        requestResponseHolder.setResponse(wrappedResponse);
        requestResponseHolder.setRequest(new HttpSessionSecurityContextRepository.SaveToSessionRequestWrapper(request, wrappedResponse));
        return context;
    }  
...
```

