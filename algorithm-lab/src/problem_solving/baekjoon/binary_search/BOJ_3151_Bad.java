package problem_solving.baekjoon.binary_search;

import java.util.*;
import java.io.*;

// 풀지 못함.
public class BOJ_3151_Bad {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] twoSum = new int[n * (n + 1) / 2];
        int index = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                twoSum[index++] = arr[i] + arr[j];
            }
        }
        Arrays.sort(twoSum);

        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (binarySearch(twoSum, -arr[i])) {
                // 자기 자신을 제외한 것으로 구성된 twoSum 중에서 찾아야 함.
                answer++;
            }
        }

        System.out.println(answer);
    }

    private static boolean binarySearch(int[] arr, int target) {
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