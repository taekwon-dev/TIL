# Selection Sort (선택 정렬)

\# 주어진 범위 내 최솟값 # 교환(swap)

> 선택 정렬은 먼저 전체 배열에서 가장 작은 요소를 찾고 그 요소를 배열의 첫 번째 요소와 교환한다. 다음으로 배열 A의 두 번째 요소부터 마지막 요소까지 확인하여 가장 작은 요소를 찾은 후 그 요소를 두 번째 요소와 교환한다. 이런 과정을 배열 전체가 정렬될 때까지 (n-1)번 반복한다. 
>
> (n-1) 반복 :
>
> 배열의 사이즈가 5인 경우, 4번의 최솟값 + 교환 과정을 거치면 정렬이 완료된다. 
>
> 정렬 / ~정렬으로 나뉘고, 매 반복 마다 교환할 값인 최솟값과 이를 어떤 인덱스와 교환할 지를 체크해야 한다.

```java
int i, j, min, temp;
int n = array.length;
for (i = 0; i < n-1; i++) {
	// 배열 내 어떤 값이 최솟값인지 모르는 시점에서 0번 인덱스의 값을 최솟값으로 초기화
  min = i; 
  for (j = i+1; j < n; j++) { 
    // j 인덱스는 i+1로, 위에서 최솟값으로 설정했던 0번 인덱스 그 이후 인덱스부터 비교하기 위함 
    if (A[j] < A[min]) min = j; 
  }
  // 교환 대상인 최솟값과 해당 최솟값이 어떤 인덱스와 교환될 지 구했고, 실제 Swap을 진행 
  A[i] <-> A[min]
}

// Outer loop -> 어떤 인덱스와 비교할 지 
// Inner loop -> ~정렬 내에서 최솟값을 찾고 특정 인덱스와 Swap 
```

```java
public class SelectionSort {
    public static void main(String[] args) {
        int [] intArray = {12, 14, 35, 1, 23, 66, 76, 6};
        selectionSort(intArray);

        // 1 6 12 14 23 35 66 76
        printArray(intArray);
    }


    private static void selectionSort(int[] A) {
        int i, j, min, temp;
        int n = A.length;

        for (i = 0; i < n-1; i++) {
            min = i;
            for (j = i+1; j < n; j++) {
                if (A[j] < A[min]) {
                    // 최솟값이 어떤 인덱스에 위치했는 지 파악
                    min = j;
                }
            }
            // temp <- 최솟값 임시 저장
            temp = A[min];
            A[min] = A[i];
            A[i] = temp;
        }
    }

    private static void printArray(int[] intArray) {
        for (int i = 0; i < intArray.length; i++) {
            System.out.print(intArray[i] + " ");
        }
        System.out.println();
    }
}
```

## 재귀 활용 

```java
private static void selectionSort(int[] arr) {
  selectionSort(arr, 0);
}

private static void selectionSort(int[] arr, int start) {  
  if (start < arr.length-1) {
    int min_index = start;
    for (int i = start; i < arr.length; i++) {
      if (arr[i] < arr[min_index]) min_index = i; 
    }
    swap(arr, start, min_index);
    selectionSort(arr, start+1);
  }
}


private static void swap(int[] arr, int index1, int index2) {
  int tmp = arr[index1];
  arr[index1] = arr[index2];
  arr[index2] = tmp;
} 
```

