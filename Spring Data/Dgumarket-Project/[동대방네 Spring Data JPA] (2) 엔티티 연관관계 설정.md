# [동대방네 Spring Data JPA] (2) 엔티티 연관관계 설정 

이번 글에서는 이 포스트 (1) 주제에 포함됐던 비즈니스 요구사항에 대응되는 엔티티 간 연관관계 설정 방법에 대한 내용을 포함한다. 단순히 비즈니스 요구사항에 맞춘 설계 방향에 대해서만 설명하지 않고, ORM을 통해 **객체**와 **관계형 데이터베이스** 간 패러다임의 불일치를 해결하는 관점에서도 설명을 할 예정이다.  

<u>Github 링크</u>

___

### | 비즈니스 요구사항 : 

비즈니스 요구사항에는 **중고거래 플랫폼** 에서 각 엔티티 간 연관관계를 형성하는 핵심 로직만 추렸다. 대부분 아래 요구사항을 처리하는 과정에서 대부분의 JPA 엔티티 간 연관관게를 매핑하는 것과 영속성 컨텍스트를 통한 영속성 전이 또는 지연 로딩 등 프로젝트에서 활용했던 다양한 옵션들을 활용할 수 있기 때문이다. 

아래 비즈니스 요구사항에 대해서 데이터는 자체 DB 서버를 구축한다. (<u>MySQL</u> 사용)

- **회원** : 

  - 회원가입 시, 회원은 관심 카테고리 (중고상품 카테고리) 중 3가지 이상을 선택해야 가입할 수 있다. 

  - 회원 탈퇴 시, 일정 기간 보관 후 (개인정보 처리방침 의거) 삭제 

    (단, 해당 유저가 주고 받은 채팅 데이터는 참고 관계만 끊는다) 

    

- **중고 거래** :

  - 유저는 업로드된 중고상품들을 대상으로 관심 물품으로 지정할 수 있다. (인스타그램 <u>좋아요 기능</u>)
  - 상품 기준으로, 해당 상품을 관심 품목으로 지정한 유저(들)은 조회할 수 <u>없다</u>.
  - 유저는 관심항목으로 추가한 상품을 조회할 때 관심항목으로 추가한 순서대로 조회할 수 있다.
  - 유저는 본인이 업로드한 중고상품 리스트를 조회할 수 있다.
  - 중고상품 상세 정보화면에서, 해당 중고상품 판매자의 프로필 정보를 조회할 수 있다.

- **채팅** :

  - 유저는 자신이 포함된 채팅방 목록을 조회할 수 있다. 
  - 유저는 참여하고 있는 채팅방 내 메시지를 조회할 수 있다.

___

### | Member & Product (회원과 중고상품 관계) : 

위 비즈니스 요구사항을 보면, 유저는 본인이 업로드한 중고상품 리스트를 조회할 수 있고, 반대로 중고상품 기준으로도 해당 중고상품의 판매자 정보를 조회할 수 있어야 한다. **객체 탐색** 방향으로 다시 표현하면 다음과 같다. 양방향 관계로 볼 수 있고, 이는 각 엔티티 기준으로 단방향 관계가 서로 교차하면서 양방향 관계가 된다. "<u>**회원은 두개 이상의 중고 상품을 업로드 할 수 있다.**</u>" 즉, 회원(One) :  중고상품(Many) 관계로 볼 수 있다. 회원을 기준으로 보면, 일대다 관계이고, 중고상품을 기준으로 보면, 다대일 관계로 볼 수 있다. 

- **Member → Product** 
- **Product → Member** 

일대다 또는 다대일 관계를 설정할 때 혼동할 수 있는데, 필자는 연관관계에서 다중성을 파악할 때 다음과 같은 예로 관계성을 분석한다. 예를 들어, 회원 입장에서 회원 본인이 업로드한 중고상품들을 조회할 때, 중고상품이 두 개 이상이므로, Java Collections (List 또는 Set)을 활용해야 한다. 따라서 회원 입장이 One이 되고, 중고상품이 Many가 된다고 볼 수 있다. 

- **Member : Product = Many : One** or **Product : Member = One : Many**

외래 키는 일반적으로 일대다 또는 다대일 관계에서 **다**쪽에서 관리한다. 예를 들어 위 예시에서 회원 테이블에서 외래 키를 관리한다면 회원이 두 개 이상의 중고상품을 업로드했을 때 각각의 중고상품 관련 고유 식별 (키)를 관리해야 하는데 하나의 컬럼에서 두 개 이상의 값을 관리하는 것은 상당히 불편을 야기할 것이다. (물론 '그렇게 하면 틀린다'의 개념은 아니다.) 

___

### | Member & MemberCategory (회원과 회원의 관심 카테고리 관계) : 

회원가입 시 각 회원은 세 개 이상의 관심 카테고리 항목을 선택해야 한다. 회원과 회원의 관심 카테고리를 나타내기 위해서는 어떻게 해야할까? 우선, 소제목에서는 드러나지 않았지만, 여기서 관계를 맺는 두 대상은 사실 회원과 카테고리이다. 결론부터 말하면 이 둘의 관계는 다대다 관계이고, 회원정보로써 관심 카테고리를 관리해야 하므로 단뱡향 관계로도 비즈니스 요구사항을 충족할 수 있다. 

문제는 관계형 데이터베이스에서는 두 테이블로 다대다 관계를 지정할 수 없는 것이다. 두 테이블 관계를 다대다로 설정하기 위해서는 두 테이블을 연결해주는 연결테이블이 필요하다. 

![image-20210707202825343](./imgs/2_mapping_1.png)

​							 < 그림 1 : 관계형 데이터베이스에서 두 테이블로 다대다 관계를 표현할 수 없다>

![image-20210707202825343](./imgs/2_mapping_2.png)

​							 < 그림 2 : 연결 테이블을 이용한 관계형 데이터베이스 다대다 관계 설정> 

<그림 2>와 같이 중간에 연결 테이블을 두고 일대다, 다대일 관계로 다대다 관계를 형성할 수 있다. 반면 객체 차원에서는 두 객체의 관계를 다대다 관계로 설정할 수 있다. JPA에서 위와 같은 관계를 설정하기 위해서는 `@ManyToMany` 어노테이션과 위에서 언급한 연결 테이블의 정보를 JPA에게 알려줘야 하므로 `@JoinTable` 옵션을 추가로 기재해야 한다. 옵션에 대한 자세한 설명은 기재된 코드에 주석을 통해서 자세히 언급되어 있다.

___

### | Member & MemberLikeProduct (회원과 회원이 관심있는 중고상품 관계) : 

회원은 업로드 된 중고상품 중, 관심설정을 할 수 있다. 회원과 회원의 관심 카테고리와 동일하게 회원과 회원의 관심 상품 관계에서는 실질적으로 회원과 상품 두 대상이 관계를 맺는 것에서 시작한다. 이 경우, 회원과 상품의 관계는 다대다 관계로 정의할 수 있다. 회원의 입장에서는 여러 중고상품을 관심 항목으로 추가할 수 있고, 상품 입장에서는 여러 회원들이 관심 항목으로 추가할 수 있기 때문이다. 그렇다면 회원의 관심 카테고리와 동일하게 처리하면 되는 것일까? 

이에 대해서 판단하기 위해서는 다시 한 번 비즈니스 요구사항에 대해서 점검해봐야 한다. 

**중고 거래** :

- 유저는 업로드된 중고상품들을 대상으로 관심 물품으로 지정할 수 있다. (인스타그램 <u>좋아요 기능</u>)
- 상품 기준으로, 해당 상품을 관심 품목으로 지정한 유저(들)은 조회할 수 <u>없다</u>.
- 유저는 관심항목으로 추가한 상품을 조회할 때 관심항목으로 추가한 순서대로 조회할 수 있다.

단순히, 회원이 관심상품으로 추가한 상품을 조회하는 것으로 요구사항이 끝났다면 관심 카테고리를 처리하는 것과 동일하게 처리할 수 있지만 관심상품으로 등록한 순서대로 정렬 후 조회하도록 서버 측에서 처리하려면 관심상품으로 추가한 시점의 날짜+시간 정보를 테이블에서 관리해야 한다. 

![image-20210707202825343](./imgs/2_mapping_3.png)

​					         <그림 3 : 관심 상품을 시간 순서대로 정렬하기 위해서 필요한 컬럼 추가>

<그림 3>과 같이 `DATETIME` 컬럼을 추가해서 요구사항을 충족할 수 있다. 하지만 이렇게 컬럼을 추가한 뒤 `@ManyToMany`를 사용할 수 없다. 회원 또는 상품 엔티티에서 추가된 컬럼에 해당하는 값을 매핑할 수가 없기 때문이다. 따라서 이와 같이 비즈니스 요구사항을 충족하기 위해 다대다 관계에서 연결 테이블에 추가되는 컬럼이 있는 경우에는 관계형 데이터베이스에서 연결 테이블을 통해서 두 테이블의 관계를 일대다, 다대일 관계로 지정한 것과 같이 객체 역시 연결 엔티티를 활용해서 일대다, 다대일 관계로 풀어야 한다. 

![image-20210707202825343](./imgs/2_mapping_4.png)

​							 <그림 4 : 객체 차원에서도 다대다 → 일대다, 다대일 관계로 풀기> 

회원과 회원이 관심있는 상품은 양방향 관계이고, 외래키가 `Member_Product` 에 위치하므로 두 관계에서 주인관계로 설정한다. 따라서 `mappedBy` 옵션은 `Member` 엔티티에 설정하면 된다. 양방향 관계로 설정한 것은 회원은 자신의 관심 목록을 조회하고, 관심 상품 목록에서도 각 상품을 업로드한 유저의 프로필 정보를 확인 할 수 있어야 하기 때문이다. 반면, 상품과 회원이 관심있는 상품은 단방향 관계로 설정되어 있는데, 이는 관심 상품 목록에서 각 상품의 정보를 조회하지만, 반대로 상품 객체에서 해당 상품 객체를 관심 항목으로 추가한 유저 정보를 조회하지는 않기 때문이다. 

이렇게 연결 엔티티를 설정하는 것과 관련하여 `복합 기본키`, `식별관계` 를 활용하는 방식이 있지만 프로젝트에서는 새로운 기본 키를 사용함으로써 문제를 해결했다. ORM 매핑 시, 복합 키를 생성하지 않아도 평소처럼 엔티티 간 연결관계를 간단히 설정할 수 있다. 이와 같은 방식은 앞서 언급한 `식별 관게` 의 반대인 `비식별 관계` 이다. 

