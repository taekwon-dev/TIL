# Refresh Token Rotation 

> Since frontend web applications cannot easily use Sender Constrained Tokens, the recommendation is to use refresh token rotation for frontend applications. When refresh token rotation is enabled for a client, <u>refresh tokens can only be used once</u>. Every time the clients uses a refresh token, the authorization server issues a new access token and a new refresh token.

`Refresh Token Rotation` 의 가장 큰 특징은 Access token이 만료되어 Refresh Token을 사용하게 되면, Access과 Refresh Token 쌍을 새로 발급함으로써 클라이언트의 토큰의 유효성을 갱신한다는 점이다. Refresh Token을 통해서 Access Token을 갱신하고 난 뒤 갱신을 위해 사용된 Refresh Token을 계속 사용하는 것이 아니라 새로운 Refresh Token을 발급 받기 때문에 오직 한 번만 사용하게 되는 것이다. 

![image-20210919163144367](/Users/youn/Library/Application Support/typora-user-images/image-20210919163144367.png)

<그림 1>

Access Token을 갱신하기 위한 목적으로 Refresh Token는 딱 한 번만 사용된다. 이러한 특징을 활용해서 Refresh Token이 클라이언트에서 탈취되는 경우에는 어떻게 대처할 수 있을까? 우선적으로 탈취에 대처하기 위해서는 탈취된 사실을 인지하는 것이 필요할 것이다. 그리고 탈취되는 상황의 전제에서 탈취를 당한 토큰의 주인은 (=유저) 탈취된 상황을 인지하지 못하고 있을 것이다. 

![image-20210919163929532](/Users/youn/Library/Application Support/typora-user-images/image-20210919163929532.png)

<그림 2> 

![image-20210919163936745](/Users/youn/Library/Application Support/typora-user-images/image-20210919163936745.png)

<그림 3>

시나리오 1, 2에서 알 수 있듯이 Refresh Token이 딱 한 번만 사용된다는 원칙이지켜지지 않는 것이 인지되면 해당 유저에게 발급된 현재 토큰의 유효성을 끊음으로써 토큰 탈취에 대처할 수 있다. Refresh Token의 <u>재사용</u>이 탈취에 대한 시그널을 주는 것이다. 



### | Reference

###### SPA & Refresh Token Rotation 

###### https://www.pingidentity.com/en/company/blog/posts/2021/refresh-token-rotation-spa.html

