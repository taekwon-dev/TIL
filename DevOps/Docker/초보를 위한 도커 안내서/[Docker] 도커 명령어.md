# [Docker] 도커 명령어



![image-20210824094127899](/Users/youn/Library/Application Support/typora-user-images/image-20210824094127899.png)

​					  <그림 1> 

```sh
$ docker version 

# examples
# --rm, -it 
$ docker run --rm -it ubuntu:20.04 /bin/sh 
$ docker run --rm -p 1234:6379 redis 
```

### | exec

> exec 명령어는 run 명령어와 달리 실행중인 도커 컨테이너에 접속할 때 사용하며 컨테이너 안에 ssh server 등을 설치하지 않고 exec 명령어로 접속합니다. 
