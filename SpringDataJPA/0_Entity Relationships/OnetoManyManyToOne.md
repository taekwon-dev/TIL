---
JPA - Entity Relationships : @OneToMany, @ManyToOne 
---

### 예시 1

중고거래 플랫폼에서 **유저**가 판매할 **중고물품**을 업로드하는 상황에서 예를 찾아보자. 

유저 : User 

중고물품 : Product 

(유저와 중고물품은 모두 고유한 ID를 갖고 있다.)

유저가 중고물품을 여러개 업로드 하는 상황일 때 User & Product의 관계를 생각해보자.

{**USER1_ID** - **Product1_ID**}, {**USER1_ID** - **Product2_ID**}, ... 

{**USER2_ID** - **Product3_ID**}, {**USER2_ID** - **Product4_ID**}, ... 

동일한 유저에 대해서 두 개 이상의 중고물품이 매핑되는 구조임을 알 수 있다.

### 예시2

중고거래 플랫폼에서 업로드 된 **중고물품**에 대해서 여러 유저가 **채팅**을 보낸 상황에서 예를 찾아보자. 

채팅방 : ChatRoom

중고물품 : Product 

(채팅방과 중고물품은 모두 고유한 ID를 갖고 있다.)

유저가 해당 상품에 대해 채팅을 전송하게 되면, 채팅방이 생성된다. 

{**Product1_ID** - **ChatRoom1_ID**}, {**Product1_ID **- **ChatRoom2_ID**}

{**Product2_ID** - **ChatRoom3_ID**}, {**Product2_ID **- **ChatRoom4_ID**}

___

- [ ] Member : Product = One : Many (member_id)
- [ ] Member : ChatRoom = One : Many (consumer_id, seller_id)
- [ ] Member : ChatMessage = One : Many (consumer_id, seller_id)
- [ ] Product : ChatRoom = One : Many (product_id)



