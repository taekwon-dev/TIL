package problem_solving.leetcode.blind_75;

import java.util.HashSet;
import java.util.Set;

public class LEET_268_V2 {
    public int missingNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int i = 0; i <= nums.length; i++) {
            if (set.contains(i)) continue;
            return i;
        }

        throw new RuntimeException("No Answer");
    }
}
