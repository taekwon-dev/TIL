package problem_solving.leetcode.blind_75.find_minimum_in_rotated_sorted_array;

public class ps_2025_01_05 {

    public int findMin(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return nums[i + 1];
            }
        }
        return nums[0];
    }
}
