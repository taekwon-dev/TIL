# Error : Cannot pull with rebase : You have unstaged changes 

https://git-scm.com/docs/git-pull

https://stackoverflow.com/questions/23517464/error-cannot-pull-with-rebase-you-have-unstaged-changes





![image-20210406190827551](./imgs/Cannot%pull%with%rebase_0.png)

<그림 1>

위 그림 1과 같이 unstaged 상태의 파일이 있는 경우에 아래 명령어를 통해 upstream work와 리베이스 시도

```
$ git pull --rebase upstream work 
```

결과 : 

```
error: cannot pull with rebase: You have unstaged changes.
error: please commit or stash them.

+

에러 메시지가 출력됐지만 실제로 해당 브랜치에 upstream work 브랜치 리베이스는 진행됐다. 현재 working directory에 있는 '비밀번호 찾기 API' 파일은 계속해서 unstaged 상태로 남아 있었다. 

+
$ git pull --rebase upstream work --autostash

--autostash
--no-autostash
Automatically create a temporary stash entry before the operation begins, and apply it after the operation ends. 

리베이스를 처리하기 전, 현재 unstaged, modified, staged 파일 대상으로 stash를 한 뒤, 리베이스 처리를 마무리하고 apply를 처리한다. 

This means that you can run the operation on a dirty worktree. However, use with care: the final stash application after a successful merge might result in non-trivial conflicts.

리베이스를 처리할 때 worktree에 unstaged 파일이 있는 상태에서도 가능하다는 이점이 있지만 중대한 충돌 사항도 발생할 수 있는 만큼 사용 시 주의해야 한다. 

```

![image-20210406192208530](imgs/Cannot%20pull%20with%20rebase_1.png)

<그림 2 : --autostash 적용, 리베이스 처리 후 apply 직후 status> 

