package problem_solving.baekjoon.binary_search;

import java.util.*;
import java.io.*;

import java.util.*;
import java.io.*;

public class BOJ_1654 {

    private static long answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        long[] lans = new long[k];

        long maxLan = 1;
        for (int i = 0; i < k; i++) {
            lans[i] = Long.parseLong(br.readLine());
            maxLan = Math.max(maxLan, lans[i]);
        }

        binarySearch(lans, maxLan, n);

        System.out.println(answer);
    }

    private static void binarySearch(long[] lans, long maxLan, int n) {
        long left = 1;
        long right = maxLan;

        while (left <= right) {
            long mid = left + (right - left) / 2;

            long count = 0;
            for (long lan : lans) {
                count += lan / mid;
            }
            if (count >= n) {
                left = mid + 1;
                answer = mid;
            } else {
                right = mid - 1;
            }
        }
    }
}
