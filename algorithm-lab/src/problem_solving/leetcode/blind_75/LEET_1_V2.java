package problem_solving.leetcode.blind_75;

import java.util.HashMap;
import java.util.Map;

public class LEET_1_V2 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                int j = map.get(complement);
                return new int[]{i, j};
            }
        }

        throw new RuntimeException("No answer");
    }
}
