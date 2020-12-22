---
Git flow - feature branch rules (2020 - 12 - 21)
---

### DguMarket Team Project 

1. 논의 주제
2. 첫 번째 규칙 
3. 두 번째 규칙
4. 세 번째 규칙
5. 결론

---

# 1. 논의주제

이 문서에서는 *git flow*에서 feature~develop 과정에서 지켜야 하는 규칙에 대해 논의합니다. **gitflow feature-branch strategy.md - [시나리오 3과 4-2]**를 베이스로 하고 있으므로 혹시 [시나리오 4-2]가 이해가 부족한 경우 다시 한 번 읽고 이해하시길 바랍니다. 

(feature branch 생성부터 develop branch 까지의 병합과정)

![[1]img1](./image/1_img1.png)

<그림 1> 출처 : https://nvie.com/posts/a-successful-git-branching-model/

---

# 2. 첫 번째 규칙 : feature-branch name

이번 DguMarket feature-branch name은 아래와 같이 설정한다. 단, upstream/feature-branch를 --track 하는 local branch 이름은 직관적으로 어떤 작업을 하는 지에 대해서 알 수 있도록 구체화 한다. 단, local branch 이름 역시 일관되게 관리할 수 있도록 **prefix**를 활용하는 것을 권장한다. 

Upstream/feature branch :

- feature-user ; 유저 관련 기능 추가
- feature-chat ; 채팅 관련 기능 추가
- feature-product ; 중고거래 상품 관련 기능 추가
- feature-front ; UI 및 JS 작업 관련 기능 추가

<예시> 

개발자 A가 로그인 UI 관련 작업을 위한 feature-branch 생성 

(upstream) feature-front

(local) login_layout 

---

# 3. 두 번째 규칙  

개발자 A, B  - (upstream) feature-user

두 번째 규칙은 하나의 (upstream) feature-branch에 둘 이상의 개발자가 협업하는 상황에서 도출됩니다. [시나리오 3] 내용을 포함하고 있습니다. 하나의 feature-branch를 둘 이상의 개발자가 협업하는 상황이어도, 결과적으로 한 명의 개발자가 develop branch와 병합을 처리하게 됩니다. 아래 예시를 통해서 어떤 협의 과정이 필요한 지에 대해서 설명하겠습니다. 

<예시>

A, B가 동일한 feature-user branch에 각각 로그인과 회원정보 수정 처리를 맡은 상황 (기능상 서로 작업하는 파일이 독립적이고, 서로의 개발 내역이 필요하지 않은 상황). 

- **upstream/feature-user branch 생성을 누가 할 것인지를 정해야 한다.**
- A가 먼저 로그인 작업이 완료된 경우, 동일한 feature-branch를 작업하고 있는 개발자 B를 **Reviewer**로 설정한 뒤 PR을 생성한다. 
  - PR 승인 시, feature-user branch는 로그인 기능에 대한 커밋 이력이 업데이트 된다. 
  - PR 거절 
    - PR 거절 시, **Reviewer는 어떤 이유로 거절하는 지 상세히 작성한다**. (거절 이유에 대한 상세한 기술)
- 개발자 B가 회원가입 기능 구현이 마무리 된 이후, PR을 생성하기 전, **--rebase를 통해 업데이트 내역이 생긴 upstream/feature-user를 병합**한다. (이렇게 하면, updated feature-user 위에 회원가입 커밋이 남는다) 
- 개발자 B(해당 feature-user에 대해 마지막 순서로 PR 생성)가 **develop branch와의 병합**을 처리하고, **upstream/feature-user를 삭제**한다. 

---

# 4. 세 번째 규칙

개발자 A - (upstream) feature-user

개발자 B - (upstream) feature-chat 

세 번째 규칙은 동일한 develop 상태에서 파생된 둘 이상의 (upstream) feature-branches가 운용되는 상황에서 도출됩니다. [시나리오 4] 내용을 포함하고 있습니다. [시나리오 4]에서 언급한 것과 같이 동일 베이스로부터 feature-branches 수 만큼 갈래가 나뉘지 않게 히스토리를 관리하기 위해서 PR 생성 전, upstream/develop 업데이트 내역을 확인 후, 업데이트 이력이 있는 경우 해당 내역과 upstream/feature-branch와 병합 후 PR을 생성하도록 합니다. (자세한 과정은 시나리오[4-2] 참고)

- 개발자 A가 feature-user에 업데이트 후, upstream/develop 까지 해당 작업을 업로드 한 상황
- 개발자 B가 feature-chat에 PR을 생성 하기 전, **upstream/develop branch의 업데이트 내역을 확인한다.**
- 개발자 B가 **upstream/develop과 upstream/feature-chat 병합** 후, local branch 개발 내역에 대한 PR을 생성한다.

___

# 5. 결론

feature-branch-strategy에서 논의한 시나리오 중 현재 팀프로젝트에서 가장 보편적인 workflow에 맞춰서 규칙을 정리했습니다. 처음부터 바로 메인 리포지토리에서 진행하는 것이 아니라, 서브 리포지토리에서 연습을 충분히 할 것이기 때문에 당장은 개인 환경에서 최대한 연습을 하고 연습하는 곳에서 실수하더라도 실습해보는게 중요하다고 생각합니다. 지금 위에서 언급하는 상황에서 더욱 더 상세한 행동 지침에 대해서 업데이트를 할 예정입니다. (필요하다고 생각하는 부분은 피드백 부탁드립니다) 





