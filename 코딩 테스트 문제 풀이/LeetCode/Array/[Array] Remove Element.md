# [Array] Remove Element

### | Question

#### Given an integer array `nums` and an integer `val`, remove all occurrences of `val` in `nums` in-place. 

#### The relative order of the elements may be changed. 

#### Since it is impossible to change the length of the array in some languagues, you must instead have the result be placed in the first part of the array `nums`. 

#### More formally, if there are `k` elements after removing the duplicates, then the first `k` elemetns of `nums` should hold the final result. 

#### It does not matter what you leave beyond the first `k` elements.

#### Return `k` *after placing the final result inthe first `k` slots of `nums`*.

#### Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory. 

### | Example

##### Input : nums = [3, 2, 2, 3], val = 3

##### Output : 2, nums = [2, 2, _, _]

### | Code

```java
class Solution {
    public int removeElement(int[] nums, int val) {
    	int count = 0;
      for (int i = 0; i < nums.length; i++) {
        if (nums[i] == val) {
          nums[count++] = nums[i];
        }	  
      }
    	return count;    
    }
}
```





### | Reference

###### https://leetcode.com/problems/remove-element/
