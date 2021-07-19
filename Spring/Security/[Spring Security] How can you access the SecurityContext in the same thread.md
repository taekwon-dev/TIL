# [Spring Security] How can you access the SecurityContext in the same thread

\# How Servlet Container handles the request # ThreadLocal 

예시 코드 → Filter 또는 Interceptor에서 Authentication 처리 후, 컨트롤러 레이어에서 접근하는 상황, 이게 왜 될까? 핵심은 빈이 아닌 점!

