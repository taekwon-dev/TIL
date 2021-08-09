# [Session Repository] Session Repository 



### | `SessionRepository`

> A `SessionRepository` is in charge of creating, retrieving, and persisting `Session` instances.

> If possible, you should not interact directly with a `SessionRepository` or a `Session`. Instead, developers should prefer interacting with `SessionRepository` and `Session` indirectly through the `HttpSession` and `Websocket` Integration. 

### | `FindByIndexNameSessionRepository`

> The `FindByIndexNameSessionRepository` provides a method to look up all the sessions with a given index name and index value. As a common use case that is supported by all provided `FindByIndexNameSessionRepository` implementations, you can use a convenient method to look up all the sessions for a particular user. This is done by ensuring that the session attribute with the name of `FindByIndexNameSessionRepository.PRINCIPAL_NAME_INDEX_NAME` is populated with the username. 

```java
// Once the session is indexed, you can find by using code similar to the following:
String username = "username";
Map<String, Session> sessionIdToSession = this.sessionRepository.findByPrincipalName(username);
```

![image-20210809143216771](/Users/youn/Library/Application Support/typora-user-images/image-20210809143216771.png)

<그림 1> 

### | Reference

###### https://docs.spring.io/spring-session/docs/current/reference/html5/#api