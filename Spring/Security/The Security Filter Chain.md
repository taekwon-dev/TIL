# The Security Filter Chain 

https://docs.spring.io/spring-security/site/docs/3.0.x/reference/security-filter-chain.html



### | Spring Security Filter Chain : 

Spring Security's web infrastructure is based entirely on standard servlet filters. It doesn't use servlets or any other servlet-based frameworks (such as Spring MVC) internally, so it has no strong links to any particular web technology. It deals in `HttpServletRequest`s and  `HttpServletResponse`s and doesn't care whether the requests come from a browser, a web service client, an `HttpInvoker` or an AJAX application. 



