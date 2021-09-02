# Spring Rest Docs Introductio

\# test-driven 

### | Spring Rest Docs 

> ###### Document RESTful services by combining hand-written documentation with <u>auto-generated</u> <u>snippets</u> produced with <u>Spring MVC Test.</u>

### | Introduction

> The aim of Spring REST Docs is to help you produce accurate and readable documentation for your RESTful services.

> Spring REST Docs uses snippets <u>Asciidoctor</u> by default. (If you prefer, you can also configure Spring REST Docs to use <u>Markdown</u>.)

> Spring REST Dosc uses snippets produced by tests written with Spring MVC's test framework.

> Test-driven approach helps to gurantee the accuracy of your service's documentation. If a snippet is incorrect, <u>the test that produces it fails</u>. 

`JUnit` 와 같이 테스트 프레임워크를 통해 테스트 성공 시 API 문서가 생성되므로 수정 요소가 있는 경우에도 직접 수정 사항을 반영하는 것보다 훨씬 안정적이다. 

> Spring REST Docs uses snippets produced by tests written with Spring MVC's test framework, Spring Webflux's `WebTestClient` or `REST Assured 3`. This test-dirven approach helps to gurantee the accuracy of your service's documentation. 
>
> **If a snippet is incorrect, the test that produces it fails**

테스트 주도 방식으로 API 문서를 관리함으로써 훨씬 안정적으로 문서 관리가 가능 

> Documenting a RESTful service is largely about <u>describing its resources</u>. Two key parts of each resource's description are the details of the HTTP Requests that it consumes and the HTTP responses that it produces. 

결국 RESTful API 문서화 작업에서 Request, Response를 주로 설명하는 글이고, 이를 대체해주는다. 





### | Reference

######  https://docs.spring.io/spring-restdocs/docs/current/reference/html5/