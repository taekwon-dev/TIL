package problem_solving.baekjoon.binary_search;

import java.util.*;
import java.io.*;

// Mid 포인트를 우측 기준으로 잡기.
public class BOJ_2512 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        int sum = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
            max = Math.max(max, arr[i]);
        }
        int m = Integer.parseInt(br.readLine());

        if (sum <= m) {
            System.out.println(max);
        } else {
            System.out.println(binarySearch(arr, m, max));
        }
    }

    private static int binarySearch(int[] arr, int m, int max) {
        int left = 1;
        int right = max;

        while (left < right) {
            int mid = left + (right - left + 1) / 2;

            int budget = 0;
            for (int request : arr) {
                budget += Math.min(request, mid);
            }
            if (budget <= m) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
