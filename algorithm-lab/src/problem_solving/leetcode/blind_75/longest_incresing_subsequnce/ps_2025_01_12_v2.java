package problem_solving.leetcode.blind_75.longest_incresing_subsequnce;

import java.util.ArrayList;
import java.util.List;

public class ps_2025_01_12_v2 {

    public int lengthOfLIS(int[] nums) {
        List<Integer> lis = new ArrayList<>();

        for (int num : nums) {
            int position = lowerBound(lis, num);
            if (position < lis.size()) {
                lis.set(position, num);
            } else {
                lis.add(num);
            }
        }
        return lis.size();
    }

    private int lowerBound(List<Integer> lis, int key) {
        int low = 0;
        int high = lis.size();

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (lis.get(mid) < key) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
