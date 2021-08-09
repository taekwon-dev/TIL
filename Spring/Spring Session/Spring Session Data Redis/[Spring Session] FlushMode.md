# [Spring Session] FlushMode

### | FlushMode:

###### - ON_SAVE

> Only writes to session store when `SessionRepository.save(session)` is invoked. In a web environment this is typically done as soon as the HTTP response is committed. 

###### - IMMEDIATE

> Writes to session store as soon as possibe. For example `SessionRepository.createSession()` will write the session to session store. Another example is that setting an attribute using `Session.setAttribute(String object)` will also write to session store immediately. 



### | Reference 

###### https://docs.spring.io/spring-session/docs/current-SNAPSHOT/api/index.html?org/springframework/session/FlushMode.html

