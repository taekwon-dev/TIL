# [Spring]  Bean life cycle and callback methods 

### | Life cycle callbacks 

생명주기 콜백에 대해서 알아보기 전에 어떤 상황에서 생명주기 콜백을 사용하는 지에 대해서 이해하는게 중요하다. 이에 더해 객체의 <u>생성</u>과 <u>초기화</u> 의미의 차이를 알고 있어야 한다. 먼저, 객체의 생성은 말 그대로 메모리를 할당하고 객체를 생성하는 것으로 일반적으로 `new` 키워드를 통해서 객체가 생성된다. 초기화는 생성된 객체의 필드에 필요한 값을 설정한다. 또는, 외부 DB 서버와 커넥션을 하는 등의 말 그대로 해당 객체가 설계된 대로 동작할 수 있도록 필요한 작업을 담당한다. 

다시 본 질문으로 돌아가서 그러면 언제 생명주기 콜백을 사용하면 될까? 위에서 객체의 생성과 초기화의 차이에 대해서 설명할 때 언급했듯이 생성된 객체를 사용하기 전에 수반되어야 하는 작업이 외부 DB 서버와 커넥션을 연결하는 것과 같은 (필드의 값 설정 차원이 아닌 경우) 작업을 할 때 생명주기 콜백은 개발자에게 매우 유용한 옵션이다. 

`Spring Framework`에서는 크게 3가지 방법으로 `Spring Bean Life cycle callbacks` 지원한다. 이번 글에서는 `Spring Framework` 에서 권장하는 어노테이션 `@PostConstruct, @PreDestroy`만 설명하고 추후 나머지 두 방법에 대해서도 정리할 예정이다. 참고로 두 어노테이션은 자바 표준에 등록된 기술이다. (코드 & 로깅 사진 첨부 예정)

##### - @PostConstruct

##### - @PreDestory





### | Reference

###### https://dzone.com/articles/spring-bean-lifecycle

###### https://howtodoinjava.com/spring-core/spring-bean-life-cycle/

###### https://www.baeldung.com/spring-postconstruct-predestroy

###### https://taes-k.github.io/2020/06/14/spring-bean-scope-lifecycle/

###### https://www.baeldung.com/spring-bean-scopes

###### https://renuevo.github.io/spring/scope/spring-scope/