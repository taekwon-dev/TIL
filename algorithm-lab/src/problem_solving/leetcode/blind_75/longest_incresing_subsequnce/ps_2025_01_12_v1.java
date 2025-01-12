package problem_solving.leetcode.blind_75.longest_incresing_subsequnce;

import java.util.Arrays;

public class ps_2025_01_12_v1 {

    public int lengthOfLIS(int[] nums) {
        int[] count = new int[nums.length];
        Arrays.sort(count);

        int answer = 0;
        for (int i = 0; i < nums.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && max < count[j]) {
                    max = count[j];
                }
            }
            count[i] = max + 1;
            answer = Math.max(answer, count[i]);
        }

        return answer;
    }
}
