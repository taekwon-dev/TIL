# Team Zext, Git Flow 

##### 팀 Zext 사용한 Git Flow 전략을 소개합니다. 이번 글에서는 Git Flow workflow를 소개합니다. 전반적인 흐름을 이해하기 위해 필요한 선수 지식은 아래 리스트에서 확인하실 수 있고 필요하신 경우 해당 개념을 파악하신 뒤 이어서 읽어가시면 좋을 것 같습니다. 아래 상황은 FE, BE 각 서버 배포 환경에 따라 달라질 수 있는 점 미리 알려드립니다.

### | 선수 지식

- ###### Rebase

- ###### Cherry-pick

- ###### Remote-tracking branch. 

### | 목차

- ###### Git Flow Network 

- ###### Work Branch 전 (=Feature to Work Branch)

- ###### Work Branch 후 (=Work to Master Branch)

___

### | Git Flow Network 

<img src="./imgs/gitflow_zext_1.png" alt="image-20210815103825570" style="zoom:50%;" />

​							    <그림 1> 

- ###### master : 실제 라이브 서버와 파이프라이닝 되어있으며, 해당 브랜치는 test 브랜치에서의 pull-request를 통한 머지만을 허용하도록 한다.

- ###### test : QA 서버와 파이프라이닝 되어있으며, 해당 브랜치는 develop 브랜치에서의 pull-request를 통한 머지만을 허용하도록 한다.

- ###### develop : 개발 서버와 파이프라이닝 되어있으며, 해당 브랜치는 work 브랜치에서의 pull-request를 통한 머지만을 허용하도록 한다.

- ###### work : 실제 개발의 루트를 잡고있는 브랜치로서 실제 개발 플로우들의 루트를 관리한다. 단, 이슈 개발에있어서 모든 내용들은 이슈종류에 따라 새로운 브랜치를 만들어 개발후 머지한다.

- ###### feature/ : 신규 기능 개발이슈가 있을때 사용하는 브랜치

- ###### hotfix/ : 긴급 수정 이슈가 있을때 사용하는 브랜치

- ###### bugfix/ : 오류 수정 이슈가 있을때 사용하는 브랜치



### | Feature to Work Branch 

\# PR (Pull Request), \# Fork 

<그림 1, Git Flow Network>에서 알 수 있듯이 `Feature` Branch의 베이스는 `Work` Branch 입니다. 따라서 로컬 환경에서 개발할 때는 원격 리포지토리의 `Work` Branch를 복제한 로컬 리포지토리의 `Work` 브랜치를 기준으로 `Feature` Branch를 생성하면 됩니다. 로컬에서 `Feature` Branch를 생성하고 기능 개발이 완료되면 이를 다시 원격 리포지토리에 병합을 해야 합니다. 지금부터는 이 과정에 대해서 자세히 설명하겠습니다. 

![image-20210816150618138](./imgs/gitflow_zext_2.png)

<그림 2> 

- ###### 1) 먼저, Upstream 리포지토리에서 `fork` 를 통해 Origin 리포지토리를 생성합니다. 

- ###### 2) 로컬에 개발 환경을 만들기 위해 Origin 리포지토리를 `clone` 하여 로컬에 해당 프로젝트 환경을 구축합니다. 

- ###### 3) 개발이 완료된 후 Upstream으로 바로 개발 내역을 Push 하지 않고 Origin 리포지토리에 먼저 Push를 합니다. 

- ###### 4) Origin 리포지토리에서 `PR(Pull Request)` 를 통해서 Upstream 리포지토리에 개발 내역을 병합합니다. 

____

 Upstream `Work` 브랜치에 개발 내역을 병합하는 과정은 <그림 2>와 같지만 <그림 1>에서 소개했듯이 `Feature` 브랜치는 `Work` 브랜치를 베이스로 하고 있으므로 <그림 2> 3번의 과정을 보다 구체적으로 소개하면 다음과 같습니다. 

로컬의 `Work` 브랜치에서 기능 개발을 위한 `Feature` 브랜치를 생성합니다. 그리고 개발이 완료되면 이를 Origin/`Feature` 브랜치로 `Push` 를 하고 이를 `PR`을 통해서 Upstream `Work` 브랜치로 병합하게 됩니다. 



### | Work to Master Branch

\# Pipeline 

### | Reference

###### https://taes-k.github.io/2019/08/09/git-gitflow/

###### https://taes-k.github.io/2020/01/07/clean-git-flow/

###### https://techblog.woowahan.com/2553/

