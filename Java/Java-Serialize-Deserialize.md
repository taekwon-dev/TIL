# [Java] Serialize, Deserialize



### | Context 

객체는 속성(필드)과 기능(메소드)를 가진다. 객체의 기능은 클래스에 정의되어 있으므로 객체 인스턴스의 상태인 속성만 저장했다가 필요할 때 불러와서 복구하면 된다. 객체가 단순하면 객체의 모든 속성 값을 꺼내서 파일이나 데이터베이스에 저장하면 되지만, 부모 객체를 상속받았거나, 다른 객체를 참조하고 있다면 객체의 상태를 저장하기는 쉽지 않다. 예를 들어 회원 객체를 저장할 때 팀 객체도 함께 저장해야 한다. 단순히 회원 객체만 저장하면 참조하는 팀 객체를 잃어버리는 문제가 발생한다. 

<u>자바는 이런 문제까지 고려해서 객체를 파일로 저장하는 직렬화 기능과 저장된 파일을 객체로 복구하는 역 직렬화 기능을 지원한다.</u> 

### | Jackson ObjectMapper

###### Serialize Java Objects into JSON

###### Deserialize JSON string into Java Objects





### | Reference

###### https://www.baeldung.com/jackson-object-mapper-tutorial
