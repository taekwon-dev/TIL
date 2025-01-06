package problem_solving.leetcode.blind_75.insert_interval;

import java.util.ArrayList;
import java.util.List;

public class ps_2025_01_06 {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> mergedIntervals = new ArrayList<>();
        int idx = 0;

        while (idx < intervals.length && intervals[idx][1] < newInterval[0]) {
            mergedIntervals.add(intervals[idx]);
            idx++;
        }

        while (idx < intervals.length && intervals[idx][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[idx][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[idx][1]);
            idx++;
        }
        mergedIntervals.add(newInterval);

        while (idx < intervals.length) {
            mergedIntervals.add(intervals[idx]);
            idx++;
        }

        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }
}
