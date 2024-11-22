package problem_solving.baekjoon.two_pointer;

import java.util.*;
import java.io.*;

public class BOJ_2230 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int minDiff = Integer.MAX_VALUE;
        int p2 = 0;
        for (int p1 = 0; p1 < n; p1++) {
            while (p2 < n && arr[p2] - arr[p1] < m) {
                p2++;
            }
            if (p2 == n) break;
            minDiff = Math.min(minDiff, arr[p2] - arr[p1]);
        }
        System.out.println(minDiff);
    }
}
