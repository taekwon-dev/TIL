package problem_solving.leetcode.blind_75;

public class LEET_1_V1 {
    public int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];
        int size = nums.length;
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                if (nums[i] + nums[j] != target) {
                    continue;
                }
                return new int[]{i, j};
            }
        }

        throw new RuntimeException("No answer");
    }
}
