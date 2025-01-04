package problem_solving.leetcode.blind_75.missing_number;

public class ps_2025_01_03 {

    public int missingNumber(int[] nums) {
        boolean[] flags = new boolean[nums.length + 1];

        for (int num : nums) {
            flags[num] = true;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!flags[i]) {
                return i;
            }
        }
        return -1;
    }
}
