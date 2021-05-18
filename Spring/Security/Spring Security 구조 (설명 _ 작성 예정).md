# Servlet Security : The Big Picture

https://docs.spring.io/spring-security/site/docs/current/reference/html5/#servlet-architecture

https://docs.spring.io/spring-security/site/docs/5.2.0.BUILD-SNAPSHOT/reference/htmlsingle

### | Spring Security 사용은 했지만, Spring Security 설명을 못하겠다.

Spring Security가 무엇인 지 질문을 받거나, 내 프로젝트에 Spring Security를 작성했지만 어디에서, 어떻게 작동하는 지에 대해 모호했었다. 아래 코드는 클라이언트의 HTTP 모든 요청에 대해 인증 여부를 `체크` 또는 `체크하지 않음` 을 설정하는 예제 코드이다. 코드를 작성하는 과정에서는 사실 아래 코드는 매우 충분히 직관적이고 코드 자체에 대한 이해는 어렵지 않다. 

```java
@Override
protected void configure(HttpSecurity http) throws Exception {
  
  // 모든 요청에 대해 인증 여부를 체크하지 않고 허용 
  http.authorizeRequests().anyRequest().permitAll();
  
  // 모든 요청에 대해 인증 여부를 체크 (= 비인증 대상에게는 요청에 대한 정상 응답 반환 X)
  http.authorizeRequests().anyRequest().authenticated();
}
```

누군가 만들어 놓은 툴을 사용하는 것은 편하지만, 개발자로서 내부 동작원리를 이해하지 않고 가져다 쓰기만한 상황이 매우 찝찝했다. 아래 글은 Spring Security는 어떻게 동작하는 지를 이해하기 위한 과정을 담고 있다. 

서블릿과 서블릿 컨테이너 등에 대한 개념이 생소하신 분들은 해당 개념을 공부하시고 읽으시는 것을 추천드립니다. 

____

### | Spring Security를 이해하기 

Spring Security’s Servlet support is based on **Servlet `Filter`s**, so it is helpful to look at the role of **`Filter`s** generally first. The picture below shows the typical layering of the handlers for a single HTTP request.

"Spring Security가 <u>서블릿 필터</u>를 기반으로 <u>서블릿</u>을 지원한다" 에서 알 수 있듯이 Spring Security가 동작하는 원리 그리고 동작하는 상대적인 위치를 이해하는데 있어 가장 중요한 개념은 **Servlet Filter**이다. 사실 필자는 이번 주제에서 가장 전달하고 싶은 부분 역시 Spring Security과 (서블릿) 필터의 연결고리이다. 

![image-20210518090409610](/Users/youn/Library/Application Support/typora-user-images/image-20210518090409610.png)

​																<그림 1> 

클라이언트가 HTTP 요청을 보냈을 때 웹 서버는 해당 요청을 포워딩을 통해 적합한 서블릿에 전달을 하게 되는데, 그 요청이 서블릿에 도달하기 전에 <그림 1> 사진에서 볼 수 있듯이 여러 필터들이 위치할 수 있다. 그리고 필터가 여러 개인 점에서 **필터 체인** 이라 불린다. (이 필터체인은 서블릿을 관리하는 서블릿 컨테이너에서 생성한다) 

필터체인에서 가장 중요한 것은 각 필터들의 **순서** 인데, 이는 각 필터가 아래 방향으로만 진행되기 때문이다. 위 <그림 1>을 통해 설명하자면, Filter0 -> Filter1 -> Filter2 순서 흐름으로만 작동한다. 

![image-20210518092045906](/Users/youn/Library/Application Support/typora-user-images/image-20210518092045906.png)

​																  <그림 2>. 

그렇다면, Spring에서는 필터를 어떻게 관리할까? <그림 1>과 <그림 2>의 차이를 보면, **Filter** 자리에 **DelegatingFilterProxy** 로 바뀌어 있다. Spring은 **DelegatingFilterProxy** 를 구현한 필터를 제공한다. 이 때 **DelegatingFilterProxy** 는 서블릿 컨테이너의 생명주기와 Spring의 `ApplicationContext` 의 가교 역할을 한다. 이 가교 역할이 의미하는 것은 다음과 같다. 서블릿 컨테이너는 필터를 등록을 처리한다. 이 때 Spring에서 정의한 `Bean` 으로 인식되지 않기 때문에 Spring에서 관리할 수 없게 된다. 이를 해결해주는 것이 **DelegatingFilterProxy** 이고 서블릿 컨테이너에 등록되어 HTTP 요청 등과 같은 요청 사항들을 `Filter` 를 구현한 Spring Bean에게 전파하는 역할을 한다. 

따라서 **DelegatingFilterProxy** 는 `ApplicationContext` 에 등록된 (= `Filter` 구현한 Spring Beans) Bean Filter를 찾고, 있는 경우 해당 필터를 작동시킨다.

```java
public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) {
  // Lazily get Filter that was registered as a Spring Bean
  // For the example in DelegatingFilterProxy delegate is an instance of Bean Filter0
 	Filter delegate = getFilterBean(someBeanName);
  // delegate work to the Spring Bean
  delegate.doFilter(request, response); 
}
```



![image-20210518093107869](/Users/youn/Library/Application Support/typora-user-images/image-20210518093107869.png)

​						    <그림 3>

