package problem_solving.baekjoon.binary_search;

import java.util.*;
import java.io.*;

// 두 개의 제외 대상이 필요함
public class BOJ_1253 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (isGood(arr, arr[i], i)) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    private static boolean isGood(int[] arr, int target, int excludedIndex) {
        for (int i = 0; i < arr.length; i++) {
            if (i == excludedIndex) continue;
            if (binarySearch(arr, target - arr[i], excludedIndex, i)) {
                return true;
            }
        }
        return false;
    }

    private static boolean binarySearch(int[] arr, int target, int excludedIndex, int currentIndex) {
        int left = 0;
        int right = arr.length -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                if (mid != excludedIndex && mid != currentIndex) {
                    return true;
                }
            }

            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
