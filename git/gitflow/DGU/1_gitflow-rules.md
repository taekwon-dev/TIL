# DguMarket Team Project

1. 논의 주제
2. 첫 번째 규칙
3. 두 번째 규칙
4. 세 번째 규칙
5. 결론

---

# 1. 논의주제

이 문서에서는 *git flow*에서 feature~develop 과정에서 지켜야 하는 규칙에 대해 논의합니다. **gitflow feature-branch strategy.md - [시나리오 3과 4-2]**를
베이스로 하고 있으므로 혹시 [시나리오 4-2]가 이해가 부족한 경우 다시 한 번 읽고 이해하시길 바랍니다.

(feature branch 생성부터 develop branch 까지의 병합과정)

![[1]img1](./image/1_img1.png)

<그림 1> 출처 : https://nvie.com/posts/a-successful-git-branching-model/

---

# 2. 첫 번째 규칙 : feature-branch name

이번 DguMarket feature-branch name은 아래와 같이 설정한다. 단, upstream/feature-branch를 --track 하는 local branch 이름은 직관적으로 어떤 작업을 하는
지에 대해서 알 수 있도록 구체화 한다. 단, local branch 이름 역시 일관되게 관리할 수 있도록 **prefix**를 활용하는 것을 권장한다.

Upstream/feature branch :

- feature-user ; 유저 관련 기능 추가
- feature-chat ; 채팅 관련 기능 추가
- feature-product ; 중고거래 상품 관련 기능 추가
- feature-front ; UI 및 JS 작업 관련 기능 추가

<예시>

개발자 A가 로그인 UI 관련 작업을 위한 feature-branch 생성

(upstream) feature-front

(local) login_layout

___

# 3. 두 번째 규칙

[시나리오 4-2]를 수행하면서 지켜야 하는 행동지침

- 새로운 작업 브랜치 생성 시점
    - 현재 내 local/develop 브랜치가 upstream/develop과 동기화 (즉, 최신화)가 됐는 지.
    - 깃 관리자(TK)에게 upstream/develop 현황에 대해서 확인하기
- PR 생성을 위해 git push origin local/branch 시점
    - 해당 시점에서 upstream/develop 브랜치가 업데이트 내역이 있는 지
    - 깃 관리자(TK)에게 upstream/develop 현황에 대해서 확인하기

___

# 5. 결론

feature-branch-strategy에서 논의한 시나리오 중 현재 팀프로젝트에서 가장 보편적인 workflow에 맞춰서 규칙을 정리했습니다. 처음부터 바로 메인 리포지토리에서 진행하는 것이 아니라, 서브
리포지토리에서 연습을 충분히 할 것이기 때문에 당장은 개인 환경에서 최대한 연습을 하고 연습하는 곳에서 실수하더라도 실습해보는게 중요하다고 생각합니다. 지금 위에서 언급하는 상황에서 더욱 더 상세한 행동 지침에
대해서 업데이트를 할 예정입니다.

2020 - 12 - 27

git remote update 필수로 할 것.

terminal에서 명령어로만 처리하지 말 것 (git graph 직접 눈으로 확인하고 순차적으로 진행 할 것)

문제가 생겼을 때, 혼자만 대처하지말고 모르면 상황 공유하기 (특히, 문제 생겼을 때 upstream/develop 상태에 영향이 안가는 선에서 처리하기, upstream/develop까지 영향이 미친 상황이라면
이미 문제가 있는 것)





