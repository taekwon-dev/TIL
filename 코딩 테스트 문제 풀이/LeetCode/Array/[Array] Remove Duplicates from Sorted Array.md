# [Array] Remove Duplicates from Sorted Array

### | Question

#### Given an integer array `nums` sorted in non-decreasing order, remove the dupilcates in-place such that each unique element appears only once. The relative order of the elements should be kept the same. 

#### Return `k` *after placing the final result in the first `k` slots of `nums`.*

#### Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory. 

### | Code

```java
class Solution {
    public int removeDuplicates(int[] nums) {
      int index = 1; 
   		for (int i = 0; i < nums.length-1; i++) {
        if (nums[i] != nums[i+1]) {
          nums[index++] = nums[i+1];
        }
      }
      return index; 
    }
}
```

