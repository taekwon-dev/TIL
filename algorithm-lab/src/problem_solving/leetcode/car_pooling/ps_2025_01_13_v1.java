package problem_solving.leetcode.car_pooling;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class ps_2025_01_13_v1 {

    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, Comparator.comparingInt(t -> t[1]));
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));

        int currentLoad = 0;
        for (int[] trip : trips) {

            while (!pq.isEmpty() && pq.peek()[2] <= trip[1]) {
                currentLoad -= pq.peek()[0];
                pq.poll();
            }
            currentLoad += trip[0];

            if (currentLoad > capacity) {
                return false;
            }
            pq.offer(trip);
        }
        return true;
    }
}
