package problem_solving.baekjoon.binary_search;

import java.util.*;
import java.io.*;

// 풀지 못함.
public class BOJ_1253_Bad {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        Set<Integer> set = new HashSet<>();
        int answer = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int twoSum = arr[i] + arr[j];

                if (set.contains(twoSum)) continue;

                if (binarySearch(arr, twoSum, j + 1)) {
                    answer++;
                }
                set.add(twoSum);
            }
        }
        System.out.println(answer);
    }

    private static boolean binarySearch(int[] arr, int target, int start) {
        int left = start;
        int right = arr.length -1;
        int mid;

        while (left <= right) {
            mid = left + (right - left) / 2;

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
