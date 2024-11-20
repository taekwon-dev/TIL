package problem_solving.baekjoon.binary_search;

import java.util.*;
import java.io.*;

// Lower-bound, Upper-bound
public class BOJ_3151 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        long answer = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int twoSum = arr[i] + arr[j];
                int lowerBoundIndex = lowerBound(arr, -twoSum, j + 1, arr.length);
                int upperBoundIndex = upperBound(arr, -twoSum, j + 1, arr.length);
                answer += (upperBoundIndex - lowerBoundIndex);
            }
        }
        System.out.println(answer);
    }

    private static int lowerBound(int[] arr, int target, int left, int right) {
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private static int upperBound(int[] arr, int target, int left, int right) {
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}