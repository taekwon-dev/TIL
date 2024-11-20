package problem_solving.baekjoon.binary_search;

import java.util.*;
import java.io.*;

public class BOJ_18870 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Set<Integer> set = new HashSet<>();
        for (int element : arr) {
            set.add(element);
        }
        Integer[] copy = set.toArray(new Integer[0]);
        Arrays.sort(copy);

        StringBuilder answer = new StringBuilder();
        for (int target : arr) {
            int lowerBoundIndex = lowerBound(copy, target);
            answer.append(lowerBoundIndex).append(" ");
        }

        System.out.println(answer.toString().trim());
    }

    private static int lowerBound(Integer[] arr, int target) {
        int left = 0;
        int right = arr.length;

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
}
