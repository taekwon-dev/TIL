# [Array] Search Insert Position

\# Binary Search 

### | Question

#### Given a <u>sorted</u> array of distinct integers and a target value, <u>return the index if the target is found</u>. 

#### <u>If not, return the index where it would be if it were inserted in order.</u> 

### | Code

###### 정렬 + 중복 값 없는 배열 

###### 주어진 타겟 값의 인덱스 반환 또는  

###### 주어진 타겟 값이 배열 내 없는 경우, 정렬 기준으로 어떤 인덱스에 위치할 것인지 반환

```java
class Solution {
    public int searchInsert(int[] nums, int target) {
      for (int i = 0; i < nums.length; i++) {
        if (nums[i] >= target) {
          return i;
        }
      }
      return nums.length;
    }
}
```

###### Binary Search 

```java
class Solution {
    public int searchInsert(int[] nums, int target) {
      int start = 0;
      int end = 0; 
      
      while (start <= end) {
        int mid = (start + end) / 2; 
        if (nums[mid] == target) {
          return mid;
        } else if (nums[mid] < target) {
          start = mid + 1; 
        } else {
          end = mid - 1;
        }
      }
      return first; 
    }
}
```

