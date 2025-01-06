package problem_solving.leetcode.blind_75.three_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ps_2025_01_06 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }

            int target = -nums[i];
            int low = i + 1;
            int high = nums.length - 1;

            while (low < high) {
                int sum = nums[low] + nums[high];

                if (sum == target) {
                    answer.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    while (low < high && nums[low] == nums[low + 1]) {
                        low++;
                    }

                    while (low < high && nums[high - 1] == nums[high]) {
                        high--;
                    }
                    low++;
                    high--;
                } else if (sum < target) {
                    low++;
                } else {
                    high--;
                }
            }
        }
        return answer;
    }
}
