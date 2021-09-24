# X-Forwarded-Host

> **`X-Forwarded-Host`** (XFH) 헤더는 HTTP 요청 헤더에서 클라이언트가 요청한 원래 `Host` 헤더를 식별하는 사실상의 표준 헤더 입니다. 
>
> 리버스 프록시에서 `Host` 이름과 포트는 요청을 처리 하는 `Origin` 서버와 다를 수 있습니다. 이러한 경우 `X-Forwarded-Host` 헤더는 <u>원래 사용된 `Host` 를 확인</u> 하는데 유용합니다. 
>
> 이 헤더는 디버깅, 통계 및 위치 종속 컨텐츠 생성에 사용되며 설계 상 <u>클라이언트 IP 주소와 같은 개인 정보에 민감한 정보를 노출</u>합니다. 따라서 이 헤더가 사용될 때 사용자의 개인 정보를 염두에 두어야 합니다. 





### | Reference

###### https://developer.mozilla.org/ko/docs/Web/HTTP/Headers/X-Forwarded-Host