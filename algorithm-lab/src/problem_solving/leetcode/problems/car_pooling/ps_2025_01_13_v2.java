package problem_solving.leetcode.car_pooling;

public class ps_2025_01_13_v2 {

    public boolean carPooling(int[][] trips, int capacity) {
        int[] changes = new int[1001];

        for (int[] trip : trips) {
            int numPassengers = trip[0];
            int from = trip[1];
            int to = trip[2];

            changes[from] += numPassengers;
            changes[to] -= numPassengers;
        }

        int currentLoad = 0;
        for (int i = 0; i < changes.length; i++) {
            currentLoad += changes[i];

            if (currentLoad > capacity) {
                return false;
            }
        }
        return true;
    }
}
