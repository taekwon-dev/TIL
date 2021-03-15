### RollBack

https://goddaehee.tistory.com/167 / 갓대희 

Spring Tranaction Exception & Rollback



Rollback 이란 

데이터베이스에서 업데이트 오류가 발생할 때, 이전 상태로 되돌리는 것을 말한다. 데이터베이스는 업데이트 이전 저널 파일을 사용하여 원래의 정상적인(?) 상태로 되돌린다. 이것은 오류 동작 이후에도 깨끗한 사본으로 복원시킬 수 있기 때문에, 무결성 측면에서 매우 중요하다. 

___

Spring에서 Transaction 처리 

@Transactional 어노테이션을 활용 (선언적 트랜잭션)하는데, 이 어노테이션이 추가되면 클래스 또는 메소드에 트랜잭션 기능이 적용된 프록시 객체가 생성된다.

프록시 객체는 정상 여부에 따라서 커밋 또는 롤백 처리를 한다. (PlatformTransactionManager)

___





