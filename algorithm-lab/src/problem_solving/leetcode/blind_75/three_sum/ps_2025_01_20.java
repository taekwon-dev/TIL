package problem_solving.leetcode.blind_75.three_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ps_2025_01_20 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> triplets = new ArrayList<>();
        if (nums.length == 0) {
            return triplets;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            int complement = -nums[i];
            int low = i + 1;
            int high = nums.length - 1;

            while (low < high) {
                int twoSum = nums[low] + nums[high];
                if (twoSum == complement) {
                    triplets.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    while (low < high && nums[low] == nums[low + 1]) {
                        low++;
                    }
                    while (low < high && nums[high - 1] == nums[high]) {
                        high--;
                    }
                    low++;
                    high--;
                } else if (twoSum < complement) {
                    low++;
                } else {
                    high--;
                }
            }
        }
        return triplets;
    }
}
