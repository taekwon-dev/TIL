# [Spring] Bean Scope (1)

`Bean Scope` 를 설명할 때 공식 Spring Reference 에서는 *recipe* 라는 표현을 사용해서 설명한다. 요리를 할 때 다양한 레시피가 있는 것 처럼 <u>빈을 생성할 때</u> 스프링 프레임워크에서는 다양한 레시피를 제공한다. 그렇다면, 빈을 생성할 때 다양한 레시피를 제공할까? 스프링 컨테이너에서 관리하는 빈은 대부분 알고 있듯이 싱글톤 방식으로 생성된다. 싱글톤 구조에서는 등록된 빈이 *stateless* 했을 때가 가장 이상적이다. 하지만, *mutable* 한 빈의 경우에는 대처하기 곤란하다. 

스프링 프레임워크에서는 이러한 문제를 해결하기 위해서 위에서 언급한 것 처럼 *mutable* 한 빈의 경우에는 해당 빈을 요청할 때마다 새로운 인스턴스를 생성하는 방식으로 관리할 수 있도록 **Bean Scope**를 제공한다. 또한 단순히 빈의 상태가 변동 여부에서 그치지 않고, 웹 환경에서 클라이언트의 요청과 서버의 응답 범위 내에서 빈을 관리할 수 있도록 기능을 제공한다. 

여러 `Bean Scope`를 제공함으로써 싱글톤 방식으로만 빈을 관리하지 않고 각 상황 별로 유연하게 대처할 수 있도록 한다. `Bean scope`는 결국 스프링 컨테이너에서 관리되는 빈이 어떠한 <u>생명주기</u>를 갖는 지에 따라서 나뉘는 것이다. 스프링에서 제공하는 `Bean Scope`는 아래와 같다. 

#### - Singleton Bean Scope (<u>Default</u>)

#### - Prototype Bean Scope

#### * 아래 항목은 이어지는 <u>Bean Scope (2)</u>에서 다룬다. 

#### - Request and Session Bean Scope (Related with Web)

#### - Application Bean Scope 

#### - Websocket Bean Scope 

___

### | Singleton Bean Scope

특정한 `Scope`를 명시하지 않는 경우, 디폴트로 설정된 빈 스코프이다. 앞서 각 스코프는 결국 빈의 생명주기가 어떠한 지를 정의한 것과 같다고 설명했었다. 싱글톤 빈 스코프에서 빈의 생명주기는 다음과 같다. 아래 그림자료는 https://taes-k.github.io/2020/06/14/spring-bean-scope-lifecycle 에서 참고했다. 

![image-20210716122959602](/Users/youn/Library/Application Support/typora-user-images/image-20210716122959602.png)

​					   <그림 1> 

위 그림과 같이 빈이 생성되고, 의존관계를 주입 받은 뒤 초기화 콜백 (`@PostConstruct`)이 호출되고 사용된 후 소멸 전 콜백 (`@PreDestory`)가 호출 되면서 소멸되는 사이클로 빈이 관리된다. 즉 스프링 컨테이너의 시작과 종료까지 유지되는 <u>가장 넓은 범위</u>의 스코프라고 할 수 있다.

\+ 김영한님 자료 첨부하면 좋을 듯.



### | Prototype Bean Scope 

\+ 언제 사용하는 지가 있으면 좋을 것 같다. 

싱글톤 빈 스코프에서는 빈을 조회했을 때 항상 동일한 빈을 반환한다. 하지만 





### | Reference 

https://docs.spring.io/spring-framework/docs/3.0.0.M3/reference/html/ch04s04.html

https://taes-k.github.io/2020/06/14/spring-bean-scope-lifecycle/ 

http://lifeinhurry.com/spring-bean-scope/

인프런 강의 - 스프링 기본원리 (김영한)

