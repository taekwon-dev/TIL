package problem_solving.leetcode.blind_75.longest_incresing_subsequnce;

import java.util.Arrays;

public class ps_2025_01_06_v1 {

    public int lengthOfLIS(int[] nums) {
        int[] len = new int[nums.length];
        Arrays.fill(len, -1);

        int answer = 0;
        for (int i = 0; i < nums.length; i++) {
            int maxLen = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && maxLen < len[j]) {
                    maxLen = len[j];
                }
            }
            len[i] = maxLen + 1;
            answer = Math.max(answer, len[i]);
        }
        return answer;
    }
}
