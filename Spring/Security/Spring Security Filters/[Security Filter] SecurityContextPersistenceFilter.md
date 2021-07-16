# [Security Filter] SecurityContextPersistenceFilter

This filter will only execute once per request, to resolve servlet container (specifically Weblogic) imcompatibilities. 

This filter MUST be executed BEFORE any authentication processing mechanisms. Authentication processing mechanisms expect the `SecurityContextHolder` to contain a vaild `SecurityContext` by the time they execute. 

This is essentially a refactoring of the old `HttpSessionContextIntegrationFilter` to delegate the storage issues to a seperate strategy, allowing for more customization in the way the security context is maintained between requests. 



### | Reference

https://docs.spring.io/spring-security/site/docs/3.2.8.RELEASE/apidocs/org/springframework/security/web/context/SecurityContextPersistenceFilter.html