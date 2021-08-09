# [Spring Session] Spring Session Data Redis

###  | Why Spring Session?

###### - Replaces the built-in HttpSession with another implementation

###### - Sessions survive application restarts 

###### - No need for Load Balancer sticky sessions



### | How does `Spring Session` work?

> Instead of using Tomcat's `HttpSession`, we persist the values in `Redis`. Spring Session replaces the `HttpSession` with an implemenatation that is backed by Redis. When Sprign Security's `SecurityContextPersistenceFilter` saves the `SecurityContext` to the `HttpSession`, it is then persisted into Redis. 
>
> <u>When a new `HttpSession` is created</u>, Spring Session creates a cookie name `SESSION` in you browser. That cookie contains the ID of your session.   

![image-20210809094011666](/Users/youn/Library/Application Support/typora-user-images/image-20210809094011666.png)

<그림 1> 

`Spring Session`이 동작하는 원리는 사실 <그림 1>에서 표현된 것과 같이 매우 단순하다. 기본적으로 `Spring Sescurity`가 세션 저장소를 메모리에 두는 것을 `Redis`로 대체할 뿐이다. 



### | What are saved on Redis? 

> The following example shows an example of creating a new session. 

###### https://docs.spring.io/spring-session/docs/current/reference/html5/#api-redisindexedsessionrepository-storage

```sql
HMSET spring:session:sessions:33fdd1b6-b496-4b33-9f7d-df96679d32fe creationTime 1404360000000 \
	maxInactiveInterval 1800 \
	lastAccessedTime 1404360000000 \
	sessionAttr:attrName someAttrValue \
	sessionAttr:attrName2 someAttrValue2
EXPIRE spring:session:sessions:33fdd1b6-b496-4b33-9f7d-df96679d32fe 2100
APPEND spring:session:sessions:expires:33fdd1b6-b496-4b33-9f7d-df96679d32fe ""
EXPIRE spring:session:sessions:expires:33fdd1b6-b496-4b33-9f7d-df96679d32fe 1800
SADD spring:session:expirations:1439245080000 expires:33fdd1b6-b496-4b33-9f7d-df96679d32fe
EXPIRE spring:session:expirations1439245080000 2100
```

##### Saving a Session

> Each session is stored in Redis as a `Hash`. Each session is set and updated by using the `HMSET` command.

```sql
HMSET spring:session:sessions:33fdd1b6-b496-4b33-9f7d-df96679d32fe creationTime 1404360000000 \
	maxInactiveInterval 1800 \
	lastAccessedTime 1404360000000 \
	sessionAttr:attrName someAttrValue \
	sessionAttr:attrName2 someAttrValue2
```

![image-20210809144635434](/Users/youn/Library/Application Support/typora-user-images/image-20210809144635434.png)

<그림 2> 



##### Session Expiration

> An expiration is associated with each session by using the `EXPIRE` command, based upon the `Session.getMaxInactiveInterval()`.



### | How to invalidate a session on Redis?





### 





### | Reference

###### https://redislabs.com/wp-content/uploads/2018/04/Spring-Session-Redis-Why-How-and-Production-Pitfalls.pdf

###### https://docs.spring.io/spring-session/docs/current/reference/html5/guides/java-security.html

###### https://www.javainuse.com/spring/springboot_session_redis

###### https://www.baeldung.com/spring-session

###### https://deveric.tistory.com/76

###### https://pasudo123.tistory.com/379