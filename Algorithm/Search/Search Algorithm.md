### | Search Algorithm 

```
컴퓨터 과학에서 검색 알고리즘은 이름 그대로 검색 문제를 해결하는 어떠한 알고리즘이라도 해당되며, 연속 변수나 이산 변수를 사용하여, 일부 데이터 구조 안에 저장된 정보를 검색하거나 문제 도메인의 검색 공간에서 계산을 하기 위해 사용된다. -위키 백과- 
```

### | 순차 탐색 : 리스트 안에 있는 특정한 데이터를 찾기 위해 앞에서부터 데이터를 하나씩 확인하는 방법

### | 이진 탐색 : 정렬되어 있는 리스트에서 탐색 범위를 절반씩 좁혀가며 데이터를 탐색하는 방법

- 이진 탐색은 시작점, 끝점, 중간점을 이용하여 탐색 범위를 설정한다. 
- 단계마다 탐색 범위를 2로 나누는 것과 동일하므로 연산횟수는 logN에 비레한다.
- 따라서 O(logN)의 시간복잡도를 갖는다. 

```java
// Binary Search via 재귀함수
// Binary Search via Loop 
// 재귀함수 또는 반복문에서 탈출조건은 무엇인가 ? 시작점 >= 끝점인 경우

// 1)
public static binarySearch(int[] arr, int target, int start, int end) {
  
  // 재귀함수 탈출 조건 
  if (start > end) return -1; 
  
  int mid = (start + end) / 2;
  
  if (arr[mid] == target) return mid;
  
  else if (arr[mid] > target) return binarySearch(arr, target, start, mid-1); 
  
  else return binarySearch(arr, target, mid+1, end);
}
 
// 2)
public static int binarySearch(int[] arr, int target, int start, int end) {
  while (start <= end) {
    int mid = (start + end) / 2;
    
    // 중간 값이 target과 같은 경우, 인덱스 반환 
    if (arr[mid] == target) return mid; 
    // 중간점의 값보다 찾고자 하는 값이 작은 경우 (왼쪽 확인)
    else if (arr[mid] > target) end = mid - 1;
    // 중간점의 값보다 찾고자 하는 값이 큰 경우 (오른쪽 확인)
    else start = mid + 1;
  }
  return -1; 
}
  
```



 
