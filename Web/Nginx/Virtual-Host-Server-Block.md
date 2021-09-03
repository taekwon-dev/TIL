# Virtual Host -<u>Server Block</u>

> 가상 호스팅은 하나의 서버에 여러 개의 도메인 이름을 호스팅하는 방식을 말한다. 이를 통해 서버는 메모리, 프로세서 사이클 등 자신의 자원을 공유할 수 있으며 동일한 호스트명을 사용하기 위해 제공되는 모든 서비스가 필요하지 않다. 
>
> **Virtual hosting** is a method for hosting multiple [domain names](https://en.wikipedia.org/wiki/Domain_name) (with separate handling of each name) on a single [server](https://en.wikipedia.org/wiki/Server_(computing)) (or pool of servers). This allows one server to share its resources, such as memory and processor cycles, without requiring all services provided to use the same host name.  
>
> \-WiKi- 



> 가상 호스트를 지정하기 위해서는 `nginx.conf` 파일에 `server blcok` 을 사용하면 된다. 
>
> 하나의 호스트에서 복수의 서비스를 운영한다면, `include` 방식을 이용할 것을 권장한다. 



### | Include

> `include` 는 별도의 파일에 설정을 기록해서 설정의 그룹핑, 재활용성을 높이는 방법을 제공한다. 예를 들어, 아래의 설정은 `sites-enabled` 디렉토리에는 가상 호스트에 따라서 파일을 만들어서 위치시키면 `nginx`가 이 디렉토리의 파일들 모드를 가져와서 사용하게 된다. `nginx.conf` 파일 중 `http block` 안에 아래와 같이 기술한 후에 `sites-enabled` 디렉토리에 가상호스트 설정들을 파일별로 위치시키면 된다.

```
http {
		# 상대경로 이용 시 sites-enabled 디렉토리는 conf 디렉토리 하위에        
		# 위치해야 한다
		includes sites-enabled/*; 
}
```

### | Reference