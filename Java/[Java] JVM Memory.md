# [Java] JVM Runtime Data Area 



### | JVM은 OS에서 할당 받은 메모리 영역 (<u>Runtime Data Area</u>)을 세 영역으로 구분

- **메소드 영역**
  - <u>JVM 시작(구동)할 때 생성</u>
  - 로딩된 클래스 바이트 코드 내용을 분석 후 저장
  - <u>모든 스레드가 공유</u>
- **힙 역역**
  - <u>JVM 시작(구동)할 때 생성</u>
  - <u>객체/배열</u> 저장
  - 사용되지 않은 객체는 GC가 자동 제거 
- **JVM Stack**
  - <u>스레드 별로 생성</u>
  - 메소드를 호출할 때마다 `Frame`을 스택에 추가(push)
  - 메소드가 종료되면 `Frame`을 제거(pop)

