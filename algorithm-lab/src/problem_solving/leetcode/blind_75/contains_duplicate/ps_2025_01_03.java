package problem_solving.leetcode.blind_75.contains_duplicate;

import java.util.HashSet;
import java.util.Set;

public class ps_2025_01_03 {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.contains(num)) {
                set.add(num);
                continue;
            }
            return true;
        }
        return false;
    }
}
