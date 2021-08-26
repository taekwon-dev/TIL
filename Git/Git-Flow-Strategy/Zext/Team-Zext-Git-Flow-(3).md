# Team Zext, Git Flow (3)

이번 글에서는 앞서 (2)장에 이어서 `local:work`에서 `feature` 생성 후 `upstream:work`에 병합까지 과정을 다룹니다. 

### | 선수 지식 

- ###### Remote-tracking branch, Tracking Branch

### | 목차

- ###### Git Flow Network 

- ###### Git Flow Network: Details (Feature to Work Branch) 

- ###### Practice (Feature to Work Branch) (1) 

- ###### Practice (Feature to Work Branch) (2) ◀︎ **현재 글**

- ###### Practice (Feature to Work Branch) (3)

- ###### Git Flow Network: Details (Work to Master Branch)

___

`local:feature` 브랜치를 생성하기 전, `upstream:work`와 `local:work`의 동기화가 필요한 지 여부에 대해서 먼저 생각해야 합니다. 예를 들어, 다른 팀원이 추가한 내역을 기반으로 새로운 기능이 개발되어야 하는 경우 `upstream:work`에 병합된 내역을 내 로컬에 불러와서 작업을 진행해야 합니다. 또는 꼭 다른 팀원이 추가한 내역을 기반으로 기능 개발을 해야 하는 것은 아니지만 전체 프로젝트의 최신 버전에서 기능 개발을 하고 싶은 경우에도 동기화가 필요할 수 있습니다. 이러한 `local:work`에서 `upstream:work` 내역을 불러와 최신화를 합니다.

```shell
$ git pull upstream work 

or

$ git pull 
```

위 명령어를 통해서 동기화를 할 수 있습니다.

```shell
# 참고 'git pull' 명령어로만으로도 upstream:work 내역을 불러오려면? 

$ git pull 

위 명령어 처럼 target repo:branch 명시 없이 해당 내역을 불러오기 위해서는 관계를 설정해야 합니다. local:work 기준으로 tracking 관계를 설정하는 것이므로 upstream:work를 'remote-trakcing-branch'로 설정하고 상대적으로 local:work는 'tracking-branch'가 됩니다.

$ git branch -u upstream/work # remote-tracking-branch 등록 

관계 설정 후에는 타겟 repo:branch를 명시할 필요 없습니다.

remote-tracking-branch 관련해서 더 자세히 알아보고 싶은 분은 아래 링크에서 보시면 됩니다.
(https://git-scm.com/book/en/v2/Git-Branching-Remote-Branches)
```

___

이제 `feature` 브랜치를 생성해보겠습니다. 

```shell
# local:work를 base로 'feature' 브랜치를 생성합니다.
(local:work) $ git checkout -b feature 
```

`Anything-you-want.txt` 파일명을 임의로 만들어서 (아무) 내용을 작성합니다. 

![image-20210823102330586](./imgs/gitflow_zext_(3)_0.png)

​												 <그림 1> 

`git status` 명령어를 통해 현재 파일의 상태를 조회합니다. 위에 `youn.txt`를 최종적으로 `upstream:work`에 반영할 수 있도록 먼저 `origin:feature`에 push 해보겠습니다. 

```shell
$ git add youn.txt

$ git commit -m "youn's first commit for git flow demo"

$ git push origin feature 
```

위 명령어를 모두 진행하면, `origin:feature` 생성되고, origin repo에서는 아래 <그림 2>와 같이 `compare & pull request` 알림이 뜨게 됩니다. 단, 간혹 동일한 프로세스로 진행해도 알림이 뜨지 않는 경우도 있으므로 이러한 경우에는 직접 PR을 open 하시면 됩니다.

![image-20210823113044304](./imgs/gitflow_zext_(3)_1.png)

​					 <그림 2> 

<그림 2>에서 `compare & pull request`를 클릭하면 <그림 3>과 같이 PR의 두 대상과 방향을 확인할 수 있습니다. 이전 글에서 계속 언급했듯이 최종적으로 기능 개발 내역이 모이는 곳은 `upstream:work`이므로 아래와 같이 설정된 것을 확인할 수 있습니다. 

![image-20210823113110941](./imgs/gitflow_zext_(3)_2.png)

<그림 3> 

<그림 3> 페이지에서는 오른쪽 박스 친 곳에서 볼 수 있듯이 `reviewers`를 등록하여 PR에 대한 코드 리뷰를 요청할 수 있습니다. `Create pull request` 버튼을 클릭함으로써 PR이 open 처리 됩니다.

![image-20210823113548280](./imgs/gitflow_zext_(3)_3.png)

​					 <그림 4> 

(1)장에서 본인이 open한 PR은 본인이 처리하는 것을 규약으로 언급했었습니다. 특별한 코드리뷰 요청이 없는 경우 또는 코드 리뷰 결과 PR 승인으로 합의되는 경우 `Merge pull request` 을 통해 PR을 승인하시면 됩니다. PR 승인이 완료되면 이제 local, origin repo에서 더 이상 필요 없는 feature 브랜치를 삭제하면 됩니다. (local에서 feature 삭제할 때 work 브랜치로 checkout 이후 진행하시면 됩니다.)

```shell
$ git branch -d feature # local feature branch delete
$ git push origin --delete feature # origin feature branch delete 
```

이제 더 이상 필요 없는 브랜치까지 모두 삭제했으므로, `local:work`에도 `upstream:work`에 반영된 최신 이력을 받아와서 동기화 시켜주시면 됩니다. 

```shell
$ git pull (upstream work)
```

여기서 다룬 실습은 가장 일반적인 상황에 대해서 다룬 것이므로 충돌이 발생하는 경우, 실수로 인해 문제를 해결하는 경우 등 다양한 발생 가능한 상황에 대해서는 앞으로 하나씩 정리하고 합의하는 과정을 통해 정리해가겠습니다. 실습은 저와 같이 두 계정을 이용해서 실습하셔도 되고, 실습 환경을 구축하는 과정에서 어려움이 있으시면 요청해주시면 환경 설정 도와드리겠습니다.

다음 장에서는 위 과정을 기반으로 왜 `1 commit per 1 기능` 을 하면 좋은 지, 여러 커밋을 하나로 만드는 법, 그리고 git graph 관련해서 다루겠습니다.

