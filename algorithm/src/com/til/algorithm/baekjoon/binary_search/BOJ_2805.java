package com.til.algorithm.baekjoon.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *  나무 자르기
 *
 *  상근이는 나무 M미터가 필요하다
 *
 *  높이가 H보다 큰 나무는 H 위의 부분이 잘릴 것이고, 낮은 나무는 잘리지 않을 것이다
 *
 *  1) 한 줄에 연속해있는 나무의 높이가 20, 15, 10, 17이라고 하자. 상근이가 높이를 15로 지정
 *  2) 나무를 자른 뒤의 높이는 15, 15, 10, 15가 될 것이고, 상근이는 길이가 5인 나무와 2인 나무를 들고 집에 갈 것
 *
 *  5  0  0  2   -> 잘린 나무
 *  ------------
 *  20 15 10 17  -> 나무 높이
 *
 *
 *  적어도 M미터의 나무를 집에 가져가기 위해서 절단기에 설정할 수 있는 높이의 최댓값
 *  (절단기에 설정할 수 있는 높이는 양의 정수 또는 0)
 *
 *  예를 들어,
 *
 *  20, 15, 10, 17 가 있고 M = 7 인 경우
 *
 *  H = 14 -> 6 + 1 + 0 + 3 = 10 (O)
 *  H = 15 -> 5 + 0 + 0 + 2 = 7 (O)
 *  H = 16 -> 4 + 0 + 0 + 1 = 5 (X)
 *
 *  따라서 위 문제 조건에 의해서 H = 15 가 정답
 *
 */
public class BOJ_2805 {
    static int n, m;
    static int[] arr;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int maxHeight = arr[arr.length - 1];
        binarySearch(0, maxHeight - 1);
        System.out.println(max);
    }

    private static void binarySearch(int left, int right) {
        if (left > right) return;
        int mid = (left + right) / 2;
        long getHeight = calHeight(mid);

        if (getHeight >= m) {
            max = Math.max(max, mid);
            binarySearch(mid + 1, right);
        } else {
            binarySearch(left, mid - 1);
        }
    }

    private static long calHeight(int mid) {
        long get = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] > mid) {
                get += arr[i] - mid;
            }
        }
        return get;
    }

}
