package problem_solving.leetcode.blind_75.two_sum;

import java.util.HashMap;
import java.util.Map;

public class ps_2025_01_07_v2 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{i, map.get(complement)};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
