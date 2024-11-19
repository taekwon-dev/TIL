package problem_solving.baekjoon.binary_search;

import java.util.*;
import java.io.*;

public class BOJ_16401 {

    private static int m;
    private static int n;
    private static long answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        long[] lengths = new long[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            lengths[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(lengths);
        binarySearch(lengths);

        System.out.println(answer);
    }

    private static void binarySearch(long[] lengths) {
        long left = 1;
        long right = lengths[n - 1];

        while (left <= right) {
            long mid = left + (right - left) / 2;

            long snack = 0;
            for (long length : lengths) {
                snack += length / mid;
            }

            if (snack >= m) {
                left = mid + 1;
                answer = Math.max(answer, mid);
            } else {
                right = mid - 1;
            }
        }
    }
}