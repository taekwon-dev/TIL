package problem_solving.leetcode.car_pooling;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class ps_2025_01_07_v1 {

    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, (t1, t2) -> t1[1] - t2[1]);
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(t -> t[2]));

        int currentLoad = 0;
        for (int[] trip : trips) {
            int passengers = trip[0];
            int from = trip[1];
            while (!pq.isEmpty() && pq.peek()[2] <= from) {
                currentLoad -= pq.peek()[0];
                pq.poll();
            }
            pq.offer(trip);
            currentLoad += passengers;

            if (currentLoad > capacity) {
                return false;
            }
        }
        return true;
    }
}
