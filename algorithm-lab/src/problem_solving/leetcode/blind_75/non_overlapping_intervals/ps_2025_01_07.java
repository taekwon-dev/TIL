package problem_solving.leetcode.blind_75.non_overlapping_intervals;

import java.util.Arrays;

public class ps_2025_01_07 {

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2) -> i1[1] - i2[1]);

        int answer = 0;
        int prevEnd = Integer.MIN_VALUE;
        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];

            if (prevEnd > start) {
                answer++;
            } else {
                prevEnd = end;
            }
        }
        return answer;
    }
}
