# proxy-set-header

> By default, NGINX redefines two headers fields in proxied requests, "Host" and "Connection", and eliminates the header fields whose values are empty srings. 
>
> "Host" is set to the `$proxy_host` variable, and "Connection" is set to `close`.
>
> To change these setting, as well as modify other header fields, use the [proxy_set_header](https://nginx.org/en/docs/http/ngx_http_proxy_module.html#proxy_set_header) directive. This directive can be specified in a [location](https://nginx.org/en/docs/http/ngx_http_core_module.html#location) or higher. It can also be specified in a particular [server](https://nginx.org/en/docs/http/ngx_http_core_module.html#server) context or in the [http](https://nginx.org/en/docs/http/ngx_http_core_module.html#http) block. 



```bash
       location /api {
            proxy_pass http://backend;
            proxy_set_header Host $host:$server_port;
            proxy_set_header X-Forwarded-Host $server_name;
            proxy_set_header X-Real-IP $remote_addr;
            proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
       }
```



### | Reference

###### https://docs.nginx.com/nginx/admin-guide/web-server/reverse-proxy/