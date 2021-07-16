# [Docker] 도커 설치하기 (on Ubuntu 20.04)

### | 설치 명령어 : 

```bash
$ curl -s https://get.docker.com/ | sudo sh
```

### | 버전 확인 : 

```bash
$ docker version 
```

![image-20210708124624499](/Users/youn/Library/Application Support/typora-user-images/image-20210708124624499.png)

### | Client - Server 구조 

![image-20210708125324769](/Users/youn/Library/Application Support/typora-user-images/image-20210708125324769.png)

docker CLI는 도커 호스트에 명령을 전달하고, 해당 결과를 받아서 출력한다. 