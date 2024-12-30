package problem_solving.leetcode.blind_75.missing_number;

import java.util.Arrays;

public class ps_2024_12_30 {

    public int missingNumber(int[] nums) {
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i]) {
                return i;
            }
        }
        return nums.length;
    }
}
