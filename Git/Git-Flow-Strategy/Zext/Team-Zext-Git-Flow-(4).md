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

<그림 1>과 <그림 2>를 세부적으로 보지 않더라도 직관적으로 <그림 2> 모델이 flow을 보다 쉽게 이해할 수 있는 것을 알 수 있습니다. 구체적인 방법론을  알아보기 전에 먼저 왜 <그림 2>와 같은 모델로 관리해야 좋은 지에 대해서 좀 더 알아보겠습니다. 

