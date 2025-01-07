package problem_solving.leetcode.blind_75.longest_incresing_subsequnce;

import java.util.Arrays;

public class ps_2025_01_07_v1 {

    public int lengthOfLIS(int[] nums) {
        int answer = 0;
        int[] count = new int[nums.length];
        Arrays.fill(count, -1);

        for (int i = 0; i < nums.length; i++) {
            int maxCount = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && maxCount < count[j]) {
                    maxCount = count[j];
                }
            }
            count[i] = maxCount + 1;
            answer = Math.max(answer, count[i]);
        }
        return answer;
    }
}
