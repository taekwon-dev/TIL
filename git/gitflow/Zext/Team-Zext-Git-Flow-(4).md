



# Team Zext, Git Flow (4)

이번 장에서는 `rebase` 를 중심으로 git graph(history)를 보다 직관적이고 쉽게 이해하고 관리할 수 있도록 하는 방법을 다룹니다. 또한 git graph를 simple하게 관리하기 위한 목적으로 `1 commit per 1 feature` 주제에 대해서도 다룹니다. 

### | 선수 지식 

- ###### Rebase

- ###### Squash

- ###### Cherry-pick


### | 목차

- ###### Git Flow Network 

- ###### Git Flow Network: Details (Feature to Work Branch) 

- ###### Practice (Feature to Work Branch) (1) 

- ###### Practice (Feature to Work Branch) (2) 

- ###### Practice (Feature to Work Branch) (3) ◀︎ **현재 글**

- ###### Git Flow Network: Details (Work to Master Branch)

___

![image-20210826150500025](./imgs/gitflow_zext_(4)_1.png)

<그림 1> 

![image-20210826150500025](./imgs/gitflow_zext_(4)_2.png)

<그림 2> 

<그림 1>과 <그림 2>를 세부적으로 보지 않더라도 직관적으로 <그림 2> 모델의 work flow을 보다 쉽게 이해할 수 있는 것을 알 수 있습니다. <그림 2> 형태로 전체 flow를 관리하기 위해서 `rebase` 를 활용합니다. <그림 1>과 <그림 2>에서 드러나는 가장 큰 차이는 <그림 2>에서는 각 기능 별 (색상 별)로 순서가 명확히 드러난다는 점입니다. 동일한 베이스에서 시작했음에도 `rebase` 를 통해 base를 계속 업데이트 함으로써 <그림 2>와 같이 각 기능 커밋 별로 순서가 명확히 드러나게 됩니다. 또한 <그림 1>에서는 한 기능 내에서 여러 커밋 포인트가 있는데, 이를 <그림 2>에서는 하나로 합쳐서 관리하는 것도 큰 특징입니다. `rebase`에서는 `squash` 를 통해 여러 커밋 포인트를 하나로 합칠 수 있습니다. (아래 실습을 통해 자세히 다룰 예정). 

`Clean branch network` 를 통해 새로 합류한 팀원이 쉽게 전체 프로젝트 flow를 이해할 수 있고, 배포 시점을 명확히 구분하는데 있어서도 큰 도움이 됩니다. 또한 `cherry-pick` 관련 이슈가 있는 경우에도 `1 commit per 1 feature` 정책을 통해서 편리하게 대처할 수 있습니다. (cherry-pick 관련 설명은 추후에 업데이트 예정)

지금부터는 어떻게 rebase 과정을 거치고, 여러 커밋으로 나뉜 것을 하나로 합치는 과정(squash)에 대해서 실습을 통해서 보다 더 자세히 설명드리겠습니다. 사실 이전 장에서 다룬 내용 중에 `rebase` 를 위한 과정 하나만 추가되는 상황이고 여기에 여러 커밋으로 나뉜 것을 하나로 합치는 과정만 포함되는 거라서 매우 간단합니다.

#### 먼저 명령어 기반 프로세스는 다음과 같습니다. 

```bash
# local:work를 base로 'feature' 브랜치를 생성합니다.
(local:work) $ git checkout -b feature 

$ git add youn.txt (아무 내용이나 추가하시면 됩니다.)

$ git commit -m "youn's first commit for git flow demo"

$ git add youn.txt (아무 내용이나 추가하시면 됩니다.)

$ git commit -m "youn's first commit for git flow demo"

# 하나의 기능 브랜치에서 두 개의 커밋이 생긴 상황입니다! 
# 여기에서 위에서 언급했던 `squash`를 통해서 하나의 커밋으로 만듭니다. 
# 현재는 HEAD 기준으로 두 개의 커밋을 하나로 합치는 과정이므로, 
# HEAD~2로 입력합니다. 
$ git rebase -i HEAD~2

# 이제, 1 commit per 1 feature가 진행됐고, rebase를 진행하겠습니다.
$ git pull --rebase upstream work 

$ git push origin feature 

# 이후 PR Approved and merge 과정은 이전 장과 동일합니다. 
```

#### 위 명령어 기반 프로세스에서 각 주요 포인트에 대한 스크린샷 입니다!

![image-20210906120538651](./imgs/gitflow_zext_(4)_3.png)

​																				 <그림 3>

실습을 위해서 하나의 `feature` 브랜치에서 두 개의 커밋을 생성합니다. 

![image-20210906121001496](./imgs/gitflow_zext_(4)_4.png)

​																    <그림 4> 

`git rebase -i HEAD~2` 를 입력하면, 위와 같이 에디터가 open됩니다! <그림 4>에서 HEAD~2로 한 것 처럼 2개의 커밋 포인트가 대상으로 올라온 것을 확인할 수 있습니다. 이제 저 두 대상을 하나로 합치는데, `squash` 대상이 되는 커밋 중 이전 커밋이 없는 경우 (즉, 대상 중 가장 첫번째로 기록된 커밋)에는 `squash` 대상이 될 수 없습니다. 예를 들어 위와 같은 상황에서는 `46d6e65` 커밋은 `squash` 대상이 될 수 없는 것입니다. 따라서 `commit 2`를 `squash` 해보겠습니다. 이 때 에디터에서 `i` 를 입력하시면 아래 <그림 5>와 같이 `insert`가 활성화 되고 이 상태에서 수정하시면 됩니다. 

![image-20210906121031936](./imgs/gitflow_zext_(4)_5.png)

​						  <그림 5> 

![image-20210906122727948](./imgs/gitflow_zext_(4)_6.png)

​														   <그림 6> 

수정이 완료되면, 해당 창에서 `esc` 키를 누르면 `insert` 상태가 해제되고 이 상태에서 `wq!` 입력하면 수정 내용이 저장됩니다. (아래 <그림 7> 참고)

![image-20210906122800647](./imgs/gitflow_zext_(4)_7.png)

​															<그림 7> 

`wq!`를 입력하시면, 아래 <그림 8>과 같이 새로운 에디터가 또 열리는데 여기서는 커밋 메시지를 수정할 수 있습니다.  현재 commit1 과 commit2 중, commit2를 `squash` 했으므로 commit1에 대한 메시지를 수정하면, 합쳐진 커밋에 대한 커밋 메시지를 새로 남길 수 있게 됩니다. 아래 <그림 8> 상태에서 커밋 메시지를 수정하지 않고 싶은 경우에는 바로 `wq!` 입력하시면 commit1에 대한 메시지로 `squash`가 완료됩니다. 

![image-20210906123313041](./imgs/gitflow_zext_(4)_8.png)

​																   <그림 8> 

저는 "commit 1,2 squash done"으로 커밋 메시지를 수정했고, 아래 <그림 9>에서 `squash` 결과 <그림 10>과 같이 하나로 합쳐진 것을 확인할 수 있습니다. 

![image-20210906120538651](./imgs/gitflow_zext_(4)_3.png)

​																				 <그림 9>

![image-20210906123400294](./imgs/gitflow_zext_(4)_10.png)

​																		       <그림 10> 

`squash`를 통해 하나의 커밋으로 만들었으므로 이제, rebase를 통해 ( `git pull --rebase upstream work`) 나머지 절차를 진행하시면 됩니다! (명령어 기반 프로세스 참고)

