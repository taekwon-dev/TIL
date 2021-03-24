# Git workflow 



**Git** 은 파일을 *Committed*, *Modified*, *Staged* 세 가지 상태로 관리한다.  

- **Committed**란 데이터가 로컬 데이터베이스에 안전하게 저장됐다는 것을 의미한다.
- **Modified**는 수정한 파일을 아직 로컬 데이터베이스에 커밋하지 않은 것을 말한다.
- **Staged**란 현재 수정한 파일을 곧 커밋할 것이라고 표시한 상태를 의미한다.



**[참고] 커밋이란?** 

https://ko.wikipedia.org/wiki/%EC%BB%A4%EB%B0%8B

http://itnovice1.blogspot.com/2019/01/commit.html

COMMIT : 저장되지 않은 모든 데이터를 데이터베이스에 저장하고 현재의 트랜잭션을 종료하라는 명령

위에서 **Committed** 는 "안전하게 저장된 이후" 라는 맥락을 갖는 것이다. 따라서 안전하게 저장된 시점을 보장한다. 

```console
$ git config --global user.name "John Doe"
$ git config --global user.email johndoe@example.com
```