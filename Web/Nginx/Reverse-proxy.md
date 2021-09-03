# Reverse Proxy

###  | Reverse Proxy

> 컴퓨터 네트워크에서 클라이언트를 대신해서 한 대 이상의 서버로부터 자원을 추출하는 프록시 서버의 일종이다. 그럼 다음 이러한 <u>자원들이 마치 웹 서버 자체에서 기원한 것처럼 해당 클라이언트로 반환</u>된다.
>
> 리버스 프록시는 <u>관련 서버들을 위해</u> 임의의 클라이언트가 해당 서버에 접속하는 중간 매개체이다. 
>
> "Pass a request from NGINX to proxied servers over different protocols, modify client request headers that are sent to the proxied server, and configure buffering of response coming from the proxied servers."

### | Passing <u>a Request</u> to a Proxied Server

> When NGINX proxies a request, it sends the request to a specified proxied server, fetches the response, and sends it back to the client.  
>
> It is possible to proxy requests to an HTTP server (another NGINX server or any other server) or a non-HTTP server (which can run an application developed with a specific framework, such as PHP, Python) using a specified protocol. (FastCGI, SCGI, and memcached).
>
> ```
> location /some/path {
> 		proxy_pass http:www.example.com/link/;
> }
> 
> /some/path/page.html → http://www.example.com/link/page.html
> 
> 
> location ~\.php {
> 		proxy_pass http:127.0.0.1:8000; 
> }
> ```

### | Passing <u>Request Headers</u> to a Proxied Server

> By default, NGINX redefines two header fields in proxied requests, "Host" and "Connection", and eliminates the header fileds whose values are empty strings. 
>
> "Host" is set to the `$proxy_host` variable, and "Connection" is set to  `close`
>
> ```
> location /some/path/ {
>     proxy_set_header Host $host;
>     proxy_set_header X-Real-IP $remote_addr;
>     proxy_pass http://localhost:8000;
> }
> ```
>
> To prevent a header field from being passed to the proxied server, set it to an empty string as follows:
>
> ```
> location /some/path/ {
>     proxy_set_header Accept-Encoding "";
>     proxy_pass http://localhost:8000;
> }
> ```

### | Configure Buffers

> By default NGINX buffers responses from proxied servers. <u>A response is stored in the internal buffers and is not sent to the client until the whole response is received.</u>
>
> Buffering helps to optimize performance with slow clients, which can waste proxied server time if the response is passed from NGINX to the client synchronously. However, when buffering is enabled NGINX allows the proxied server to process responses quickly, while NGINX stores the responses for as much time as the clients need to download them.
>
> By default it is set to `on` and buffering is enabled.
>
> ```
> location /some/path/ {
> 		(default)
> 		proxy_buffering on;
>     proxy_buffers 16 4k;
>     proxy_buffer_size 2k;
>     proxy_pass http://localhost:8000;
> }
> 
> location /some/path/ {
>     proxy_buffering off;
>     proxy_pass http://localhost:8000;
> }
> ```
>
> <u>If buffering is disabled</u>, <u>the response is sent to the client synchronously</u> while it is receiving it from the proxied server. This behavior may be desirable for fast interactive clients that need to start receiving the response as soon as possible.

### | Choosing an Outgoing IP Address

> If your proxy server has several network interfaces, sometimes you might need to choose a particular source IP address for connecting to a proxied server or an upstream. This may be useful if a proxied server behind NGINX is configured to accept connections from particular IP networks or IP address ranges.
>
> ```
> location /app1/ {
>     proxy_bind 127.0.0.1;
>     proxy_pass http://example.com/app1/;
> }
> 
> location /app2/ {
>     proxy_bind 127.0.0.2;
>     proxy_pass http://example.com/app2/;
> }
> 
> location /app3/ {
>     proxy_bind $server_addr;
>     proxy_pass http://example.com/app3/;
> }
> 
> ```
>
> 







### | Reference

###### https://docs.nginx.com/nginx/admin-guide/web-server/reverse-proxy/
