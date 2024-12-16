package problem_solving.leetcode.blind_75;

public class LEET_268_V1 {
    public int missingNumber(int[] nums) {
        int[] countArr = new int[10_001];
        for (int i = 0; i < nums.length; i++) {
            countArr[nums[i]]++;
        }

        for (int i = 0; i < countArr.length; i++) {
            if (countArr[i] == 1) continue;
            return i;
        }

        throw new RuntimeException("No Answer");
    }
}
