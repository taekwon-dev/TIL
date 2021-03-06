# Git - How to exclude some files from .git ?



### | 상황 

Spring Boot 애플리케이션의 설정 파일인 `application.yml`에 원격 데이터베이스 서버 접속을 위한 설정 값이 포함되어 있어 원격 리포지토리 업로드 항목에서 제외하고 싶은 상황 

하지만, 해당 설정 파일에 아무 내용 없는 상태로 있을 때 원격 리포지토리에 업로드 내역이 있어 이미 관리대상에 `application.yml` 파일이 업로드된 상태였다. 

___

보통 깃의 관리 대상에서 파일을 제외하는 것과 관련하여 구글링을 통해 검색하면, `.gitignore` 파일에 추가해서 해당 파일을 추적 대상에서 제외하는 방법이 많이 등장하지만, 이미 관리 대상에 포함된 파일을 제외할 때는 `.gitignore`에 해당 파일에 대한 참조를 걸어놔도 추적 대상에서 제외되지 않는다. 

이런 상황에서는 아래 명령어를 통해서 관리 대상에서 제외시킬 수 있다. 

```bash
$ git rm --cached path-to-file 
```

위 명령어를 치면, 해당 파일은 관리 대상에서 삭제 처리가 되고, 이를 원격 리포지토리에 커밋 후 푸시하게 되면 해당 파일이 원격 리포지토리에서도 삭제된다. 

