# Git Branch - Remote Branch



### Fetch : Remote Branch 로컬에 '가져오기만' 하기 (= 병합 X)

원격 저장소의 내용을 확인하고 로컬 데이터와 병합하지 않고 싶을 때 fetch 명령어를 사용할 수 있다. 

Fetch 명령어를 통해서 원격 저장소의 최신 이력을 확인할 수 있고, 이 때 <u>가져온 최신 커밋 이력은 이름 없는 브랜치</u>로 로컬에 가져오게 된다. 이 브랜치는 **FETCH_HEAD**의 이름으로 체크아웃 할 수 있다. 

![image-20210412225819201](/Users/youn/Library/Application Support/typora-user-images/image-20210412225819201.png)

<그림 1 출처 : https://backlog.com/git-tutorial/kr/stepup/stepup3_2.html> 

B 커밋을 베이스로 로컬과 원격 저장소의 커밋 이력이 다른 경우인데, 로컬 D 커밋 이후 Fetch 명령어를 통해 원격 저장소의 최신 커밋 이력을 불러올 수 있다. 

![image-20210412230009545](/Users/youn/Library/Application Support/typora-user-images/image-20210412230009545.png)

​								  <그림 2 출처 : https://git-scm.com/book/ko/v2/Git-브랜치-리모트-브랜치> 



![image-20210412230138519](/Users/youn/Library/Application Support/typora-user-images/image-20210412230138519.png)

​								 <그림 3 출처 : https://git-scm.com/book/ko/v2/Git-브랜치-리모트-브랜치> 



```
$ git checkout FETCH_HEAD

Note: switching to 'FETCH_HEAD'.

You are in 'detached HEAD' state. You can look around, make experimental
changes and commit them, and you can discard any commits you make in this
state without impacting any branches by switching back to a branch.

Detached HEAD : 실험적인 코드 변경 (커밋도 물론 가능) 이 브랜치에서 어떠한 커밋 이력도 다른 브랜치에 영향 없이 체크아웃을 통해서 버릴 수 있다. 

If you want to create a new branch to retain commits you create, you may
do so (now or later) by using -c with the switch command. 

이 브랜치에서 변경한 이력을 가지고 새로운 브랜치를 생성하고 싶을 경우, -c 옵션을 통해 아래와 같이 진행할 수 있다. 

Example:

  git switch -c <new-branch-name>

Or undo this operation with:

  git switch -

Turn off this advice by setting config variable advice.detachedHead to false

HEAD is now at bc0857e Initial commit
```



근데, 현재 로컬의 HEAD 상태를 기준으로 추가된 것을 가지고 오는 것을 알겠지만, 현재 HEAD 기준으로 이미 삭제된 애들이 원격 저장소에 있는 경우에는 어떻게 해야 되는거지? 

