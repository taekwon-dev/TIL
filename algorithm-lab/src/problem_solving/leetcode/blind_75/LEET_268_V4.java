package problem_solving.leetcode.blind_75;

import java.util.Arrays;

public class LEET_268_V4 {
    public int missingNumber(int[] nums) {
        int index = 0;
        while (index < nums.length) {
            int value = nums[index];
            if (value < nums.length && value != index) {
                int temp = nums[index];
                nums[index] = nums[value];
                nums[value] = temp;
            } else {
                index++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (i == nums[i]) continue;
            return i;
        }

        return nums.length;
    }
}
