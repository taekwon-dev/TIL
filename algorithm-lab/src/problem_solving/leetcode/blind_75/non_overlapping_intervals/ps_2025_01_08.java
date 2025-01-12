package problem_solving.leetcode.blind_75.non_overlapping_intervals;

import java.util.Arrays;
import java.util.Comparator;

public class ps_2025_01_08 {

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[1]));

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
