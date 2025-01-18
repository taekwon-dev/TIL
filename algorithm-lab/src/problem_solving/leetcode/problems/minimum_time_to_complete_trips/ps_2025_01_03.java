package problem_solving.leetcode.minimum_time_to_complete_trips;

public class ps_2025_01_03 {

    public long minimumTime(int[] time, int totalTrips) {
        long left = 1;
        long right = 0;

        for (int t : time) {
            right = Math.max(right, (long)t * totalTrips);
        }

        while (left < right) {
            long mid = left + (right - left) / 2;

            long num = 0;
            for (int t : time) {
                num += mid / t;
                if (num > totalTrips) {
                    break;
                }
            }

            if (num < totalTrips) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}
