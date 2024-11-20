package problem_solving.baekjoon.binary_search;

import java.util.*;
import java.io.*;

public class BOJ_2295_V1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(arr);

        long answer = 0;
        // O(n^3) => 시간 초과 (N <= 1000)
        for (int i = n - 1; i >= 0; i--) {
            long target = arr[i];

            for (int j = 0; j < n; j++) {
                if (arr[j] == target) continue;
                for (int k = j; k < n; k++) {
                    if (arr[k] == target) continue;
                    long twoSum = arr[j] + arr[k];

                    if (binarySearch(arr, target - twoSum)) {
                        answer = Math.max(answer, target);
                    }
                }
            }
        }

        System.out.println(answer);
    }

    private static boolean binarySearch(long[] arr, long target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}