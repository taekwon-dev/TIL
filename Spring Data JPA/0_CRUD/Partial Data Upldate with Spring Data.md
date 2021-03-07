---
Spring Data JPA - Partial Data Update with Spring Data
---

### 회원 정보 수정 

- 회원 정보 수정 (프로필 이미지, 닉네임, 관심카테고리)
- 비밀번호 수정
- (미정) 채팅 메시지 알림 서비스 - 이메일 인증 처리 후 회원 이메일 컬럼 업데이트

___

Spring Data's *CrudRespository#save* is undoubtedly simple, but one feature could be a drawback: It updates every column in the table. Such are the semantics of the U in CRUD, but **what if we want to do a PATCH instead?**

Patch : (옷 등에 난 구멍이나 닳은 부분에 헝겊 등으로) 덧대다[때우다] 

Spring Data **CRUD**에서 U (Update)처리 과정의 결점은 테이블 내 한 컬럼만 수정하지 못하고, 모든 컬럼의 정보를 업데이트하는 방식이다.   만약 위와 같이 처리하지 않고 <u>부분적으로 원하는 컬럼만 수정</u>하려면 어떻게 해야할까?

### Mapping Strategy : The drawback of this approach is that we can't pass *null* values to the database during an update.

### Partial Updates with JsonNullable 

___

## Dirty Checking 





___

## 참고 

https://www.baeldung.com/spring-data-partial-update

https://medium.com/techno101/partial-updates-patch-in-spring-boot-63ff35582250

https://jojoldu.tistory.com/415 / Dirty Checking 

https://goddaehee.tistory.com/167 / @Transactional 