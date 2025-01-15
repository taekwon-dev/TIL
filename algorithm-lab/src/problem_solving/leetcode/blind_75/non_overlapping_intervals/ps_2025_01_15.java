package problem_solving.leetcode.blind_75.non_overlapping_intervals;

import java.util.Arrays;
import java.util.Comparator;

public class ps_2025_01_15 {

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[1]));

        int answer = 0;
        int prevEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < prevEnd) {
                answer++;
                continue;
            }
            prevEnd = intervals[i][1];
        }
        return answer;
    }
}
