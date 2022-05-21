# [Spring Security] - Servlet Application Architecture
Servlet Application 에서 Spring Security Framework의 동작 원리를 설명하는 글이다.
[Spring Security Architecture](https://docs.spring.io/spring-security/reference/servlet/architecture.html)  원문을 그대로 직역하지 않고 이해 과정을 풀어가면서 작성 했다. 글 제목에서도 언급된 것 처럼 `Servlet` , `Servlet Container` 에 대한 이해를 기반으로 읽는 것을 추천한다.
---

## | A Review of (Servlet) Filters
Spring Security’s Servlet support is based on **Servlet `Filter`s**, so it is helpful to look at the role of **`Filter`s** generally first. The picture below shows the typical layering of the handlers for a single HTTP request.

[image:B906EFAC-5345-4A17-ABD2-07510BA868A9-468-000398167D2F802E/FB45D3F4-8D0A-41E6-A22E-37CB781FA300.png]
[ 그림 1 ]

"Spring Security가 서블릿 필터를 기반으로 서블릿을 지원한다" 알 수 있듯이 서블릿 애플리케이션에서 `Spring Security`  가  동작하는 상대적인 위치 및 원리를 이해하는데 있어서 가장 중요한 개념은 `서블릿 필터` 다.

클라이언트가 HTTP 요청을 보냈을 때 웹 서버는 해당 요청을 포워딩을 통해 서블릿 컨테이너에 전달하고, 서블릿 컨테이너는 해당 요청을 처리할 적절한 서블릿을 찾아 서블릿에 해당 요청을 전달한다. 이 때 [ 그림 1 ] 에서 볼 수 있듯이 서블릿에 도달하기 전 여러 필터를 사용할 수 있고, 필터가 여러 개인 점에서 `필터 체인`  이라 불린다.  (이 필터 체인은 서블릿 컨테이너가 관리한다)
(사용 예시 - 인증, 로깅 등)

`필터 체인` 에서 중요한 것은 각 필터가 적용되는 순서인데, 이는 서블릿에 도달하기 까지 과정이 모두  아래 방향으로 순차적으로 진행되기 때문이다. [ 그림 1 ] 에서는  `Filter0` → `Filter1`  → `Filter2` 순서로 동작한다.

`서블릿 필터` 를 리뷰하면서 언급한 특징이 `Spring Security` 에서 어떻게 적용되는 지 확인해보자.

---
## | DelegatingFilterProxy

이름에 낚이지 말자.
`DelegatingFilterProxy`  는 하나씩 뜯어 보면 매우 친절한 이름을 갖고 있다.

"Spring Security가 서블릿 필터를 기반으로 서블릿을 지원한다" 를 통해
`Spring Security`  동작되는 상대적인 위치가 `서블릿 필터` 라는 것을 알 수 있었다.

[image:8902C701-6FCE-46C0-9D0A-77E0BA35CEDD-468-000405EDB906820B/CE71999B-34A0-49CB-AAFB-8D27061167E3.png]
[ 그림 2 ]

[ 그림 1 ] 과 [ 그림 2 ] 를 보면, 필터 체인 중 한 자리가 `DelegatingFilterProxy`  로 대체된 것을 볼 수 있다. 그리고 그 속에 `Bean Filter 0`  이 포함되어 있다.

`DelegatingFilterProxy`  역할에 대해서 언급하기 전에 이름을 한 번 분석해보자.  가운데 위치한 `Filter` 를 제외하고 앞 뒤로 붙어 있는 두 단어 뜻은 아래와 같다.

---
- Delegate (Delegating 의 동사) -  위임 시키다.
- Proxy - 대리(인)
---

`DelegatingFilterProxy` 가 __A__ 을 위임시키고,  __B__ 의 대리 역할을 하는 지 이해하면 오히려 이름을 통해 역할을 쉽게 추론할 수 있다.

[ 그림 2 ] 에서 볼 수 있듯이 `DelegatingFilterProxy` 는 `서블릿 필터`  중 한 자리를 차지하고 있다. `Spring Security Framework`  에서는 자신이 제공하는 필터를 클라이언트 요청이 서블릿에 도달하기 전에 호출되도록 하고 싶을 것이다. `DelegatingFilterProxy` 는 클라이언트의 요청을 `Spring Security Filters` 에 위임하는 역할을 한다. `Proxy` 가 붙은 이유로는 `DelegatingFilterProxy` 가 `서블릿 필터` 자리에 위치해 있지만 실제 필터 역할을 하는 `Spring Security Filters` 에 처리를 위임하는 대리인이기 때문인 것 같다.

`DelegatingFilterProxy` 는 결국 `서블릿 컨테이너` 가 `Spring Security Filter` 를 호출할 수 있도록 하는 가교 역할을 하는 것이다.  `DelegatingFilterProxy` 는 `서블릿 필터` 자리에 위치하고 있다는 점에서 `서블릿 컨테이너가` 가 관리하는 대상이고, `Bean` 이 아니다. `Spring Security Filters`  는 `ApplicationContext` 에서 관리되는 `Bean` 이다.  [ 그림 2 ] 를 보면, `DelegatingFilterProxy`  에 `Bean Filter 0`  라고 표기된 것을 볼 수 있다.

코드를 통해 위에서 정리한 관계, 내용을 다시 한 번 확인해보자.
```
public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) {
	// Lazily get Filter that was registered as a Spring Bean
	// For the example in DelegatingFilterProxy
delegate
 is an instance of Bean Filter0
	Filter delegate = getFilterBean(someBeanName);
	// delegate work to the Spring Bean
	delegate.doFilter(request, response);
}
```

`doFilter()`  는 `DelegatingFilterProxy` 가 클라이언트 요청을 받고, 이 요청을 처리할 `Spring Security Filters`  를 호출할 때 사용된다.  `ApplicationContext`  에서 `getFilterBean()` 을 통해 `Bean Filter` 를 받아오는 것을 확인할 수 있다.