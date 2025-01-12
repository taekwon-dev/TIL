package problem_solving.leetcode.blind_75.three_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ps_2025_01_12 {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> triplets = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            int complement = -nums[i];
            int low = i + 1;
            int high = nums.length - 1;
            while (low < high) {
                int sum = nums[low] + nums[high];
                if (sum == complement) {
                    triplets.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    while (low < high && nums[low] == nums[low + 1]) {
                        low++;
                    }
                    while (low < high && nums[high - 1] == nums[high]) {
                        high--;
                    }
                    low++;
                    high--;
                } else if (sum < complement) {
                    low++;
                } else {
                    high--;
                }
            }
        }
        return triplets;
    }
}
