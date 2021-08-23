# Team Zext, Git Flow (3)

###### Github : https://github.com/taekwon-dev/gitflow-demo

이번 글에서는 앞서 (2)장에 이어서 `local:work`에서 `feature` 생성 후 `upstream:work`에 병합까지 과정을 다룹니다. git history, graph를 직관적으로 쉽게 보여드리기 위해서 저는 제가 주로 사용하는 `intelliJ`를 통해서 진행합니다. git 관련 tool에 따라서 유사 기능을 잘 대응시켜서 보시면 됩니다. 

### | 목차

- ###### Git Flow Network 

- ###### Git Flow Network: Details (Feature to Work Branch) 

- ###### Practice (Feature to Work Branch) (1) 

- ###### Practice (Feature to Work Branch) (2) ◀︎ **현재 글**

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

![image-20210823102330586](/Users/youn/Library/Application Support/typora-user-images/image-20210823102330586.png)

​												 <그림 1> 

`git status` 명령어를 통해 현재 파일의 상태를 조회합니다. 위에 `youn.txt`를 최종적으로 `upstream:work`에 반영할 수 있도록 먼저 `origin:feature`에 push 해보겠습니다. 

```shell
$ git add youn.txt

$ git commit -m "youn's first commit for git flow demo"

$ git push origin feature 
```

