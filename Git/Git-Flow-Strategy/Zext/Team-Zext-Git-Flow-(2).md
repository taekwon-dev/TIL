# Team Zext, Git Flow (2) 

이번 글에서는 앞서 (1)장에서 다뤘던 `feature to work` 실습 과정을 다룹니다. 아래 깃헙 주소를 통해서 직접 실습을 진행해볼 수 있습니다. 단, access 권한을 얻기 위해서 제가 invite를 드려야 해서 혹시 github 계정을 알려주시면 access를 드리겠습니다. 

### | 선수 지식 

- ###### Pull Request 

- ###### Rebase

- ###### Squash

- ###### Cherry-pick

- ###### Remote-tracking branch, Tracking Branch

### | 목차

- ###### Git Flow Network 

- ###### Git Flow Network: Details (Feature to Work Branch) 

- ###### Practice (Feature to Work Branch) ◀︎ **현재 글**

- ###### Git Flow Network: Details (Work to Master Branch)

___

![image-20210821095921025](/Users/youn/Library/Application Support/typora-user-images/image-20210821095921025.png)

<그림 1 fork 위치> 

public repository라서 fork는 activate 되어 있지만, 스스로 pr open 하고 pr merge까지 하기 위해서는 access가 필요 -> 깃헙 계정알려주면 진행 (메일로 알림)

![image-20210821101508936](/Users/youn/Library/Application Support/typora-user-images/image-20210821101508936.png)

<그림 2 right after fork>

`taekwon-dev/work` : upstream

`tkyoun94/work` : origin 



via terminal, git clone https://github.com/tkyoun94/gitflow-demo.git 하면 해당 디렉토리 생성 

<그림 3> 

![image-20210821102745686](/Users/youn/Library/Application Support/typora-user-images/image-20210821102745686.png)

![image-20210821102858180](/Users/youn/Library/Application Support/typora-user-images/image-20210821102858180.png)

