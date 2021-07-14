# [LeetCode] Two Sum 

`Array`, `Hash Table or Map`

### | Question

#### Given an array of integers `nums` and an integer `target`, <u>return *indices of the two numbers such that they add up to `target`*.</u>

#### You may assume that each input would have exactly one solution, and <u>you may not use the *same* element twice</u>.

#### You can return the answer in any order.

### | Codes 

#### - 두 개의 포인터로 주어진 배열을 모두 검사하기

#### - Map 형태의 자료구조에서는 특정 요소를 탐색하는데, O(1)의 시간 복잡도를 가진다. (-> 핵심 근거)

- 주어진 배열의 모든 요소의 값과 해당 인덱스를 각각 키-값으로 저장한다. 
- 두 개의 수 조합을 통해 주어진 Target을 완성할 수 있는 상황 
  - A + B =  Target 
  - A = Target - B (식의 변형, B를 반복문을 통해 변수화 시킴으로써 반복문이 돌면서 A의 올 수 있는 값을 체크할 수 있다.)

```java
# 1 
class Solution {
	public int[] twoSum(int[] nums, int target) {
   
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    
    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(target-nums[i])) return new int[]{map.get(target - nums[i]), i};    
      map.put(nums[i], i); 
    }
    throw new IllegalArgumentException("Cannot find the solution from the given array");
  }  
}
```

```java
# 2
class Solution {
	public int[] twoSum(int[] nums, int target) {
   
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    
    for (int i = 0; i < nums.length; i++) map.put(nums[i], i);
    for (int i1 = 0; i1 < nums.length; i1++) {
			Integer i2 = map.get(target - nums[i1]);
      if (i2 != null && i1 != i2) return new int[] {i1, i2};
    }
    throw new IllegalArgumentException("Cannot find the solution from the given array");
  }  
}
```

