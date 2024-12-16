package problem_solving.leetcode.blind_75;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LEET_268_V3 {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i == nums[i]) continue;
            return i;
        }

        return nums.length;
    }
}
