package problem_solving.leetcode.car_pooling;

import java.util.*;

public class ps_2025_01_03 {

    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, (a, b) -> a[1] == b[1] ? Integer.compare(a[2], b[2]) : Integer.compare(a[1], b[1]));
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));

        int currentPassengers = 0;

        for (int[] trip : trips) {
            int numPassengers = trip[0];
            int from = trip[1];

            while (!pq.isEmpty() && pq.peek()[2] <= from) {
                currentPassengers -= pq.poll()[2];
            }
            currentPassengers += numPassengers;
            if (currentPassengers > capacity) {
                return false;
            }
            pq.offer(trip);
        }
        return true;
    }
}
