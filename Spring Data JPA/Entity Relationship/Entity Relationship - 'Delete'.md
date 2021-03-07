## Spring Data JPA Delete and Relationships 



보다 구체적인 상황 속에서 위 주제에 대한 이해가 더 쉬울 것이라고 판단하여, 예시부터 제시한다. 

예시) Delete in Relationships

유저와 유저의 주소 관계에서 유저가 삭제되면서 더 이상 해당 유저의 주소 값이 필요 없는 상황

영어통번역학과가 폐지되면서 해당 교과목이 더 이상 필요하지 않은 상황 

___

위 주제와 관련해서 주목해야 하는 것은 **CascadeType**과 **OrphanRemoval**

### CascadeType 이란? (Delete 중점으로)

위에서 언급했던 예시와 같이 엔티티 중 다른 엔티티의 존재에 의존하는 엔티티가 있다. 유저 - 유저의 주소 관계에서 볼 수 있듯이 유저가 삭제되면 유저의 주소 정보는 더 이상 존재 할 이유가 없기 때문이다. CascadeType은 위의 상황에서 유저 정보가 삭제 됐을 때 유저 주소 정보를 삭제시키는 일을 처리하는 여러가지 방식을 의미한다. 

### Cascade Type

- ALL
- PERSIST
- MERGE
- **REMOVE**
- REFRESH
- DETACH













