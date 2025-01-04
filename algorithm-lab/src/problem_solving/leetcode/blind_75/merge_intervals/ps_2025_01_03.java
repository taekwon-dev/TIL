package problem_solving.leetcode.blind_75.merge_intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ps_2025_01_03 {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        List<int[]> mergedIntervals = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];
            if (end >= curr[0]) {
                end = Math.max(end, curr[1]);
            } else {
                mergedIntervals.add(new int[]{start, end});

                start = curr[0];
                end = curr[1];
            }
        }
        mergedIntervals.add(new int[]{start, end});

        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }
}
