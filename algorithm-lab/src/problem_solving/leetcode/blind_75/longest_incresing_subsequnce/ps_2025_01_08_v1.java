package problem_solving.leetcode.blind_75.longest_incresing_subsequnce;

import java.util.Arrays;

public class ps_2025_01_08_v1 {

    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] count = new int[len];
        Arrays.fill(count, -1);
        int answer = 0;

        for (int i = 0; i < len; i++) {
            int maxLen = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && maxLen < count[j]) {
                    maxLen = count[j];
                }
            }
            maxLen += 1;
            count[i] = maxLen;
            answer = Math.max(answer, maxLen);
        }
        return answer;
    }
}
