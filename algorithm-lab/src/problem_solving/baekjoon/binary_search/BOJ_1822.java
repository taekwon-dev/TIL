package problem_solving.baekjoon.binary_search;

import java.util.*;
import java.io.*;

public class BOJ_1822 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int[] arrA = new int[a];
        int[] arrB = new int[b];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < a; i++) {
            arrA[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arrA);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < b; i++) {
            arrB[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arrB);

        StringBuilder answer = new StringBuilder();
        int count = 0;
        for (int target : arrA) {
            if (!binarySearch(arrB, target)) {
                count++;
                answer.append(target).append(" ");
            }
        }

        if (answer.length() == 0) {
            System.out.println("0");
        } else {
            System.out.println(count);
            System.out.println(answer.toString().trim());
        }
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
