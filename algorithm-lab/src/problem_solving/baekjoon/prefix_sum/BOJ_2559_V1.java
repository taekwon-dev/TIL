package problem_solving.baekjoon.prefix_sum;

import java.util.*;
import java.io.*;

/**
 * Failure - O(n^2), n <= 100,000
 */
public class BOJ_2559_V1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = arr[0];
        for (int i = 0; i < n - k + 1; i++) {
            int currentSum = 0;
            for (int j = i; j < i + k; j++) {
                currentSum += arr[j];
            }
            max = Math.max(max, currentSum);
        }

        System.out.println(max);
    }
}
