package problem_solving.leetcode.blind_75.two_sum;

import java.util.HashMap;
import java.util.Map;

public class ps_2025_01_07_v1 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length - 1; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && i < map.get(complement)) {
                return new int[]{i, map.get(complement)};
            }
        }
        return null;
    }
}
