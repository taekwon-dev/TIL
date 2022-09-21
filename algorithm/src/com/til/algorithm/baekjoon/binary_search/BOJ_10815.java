package com.til.algorithm.baekjoon.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 숫자카드
 * <p>
 * 숫자 카드 N개
 * 정수 M개가 주어졌을 때, 이 수가 적혀있는 숫자 카드를 상근이가 가지고 있는지 아닌지를 구하는 프로그램
 * <p>
 * N -> ~ 500,000
 * M -> ~ 500,000
 * <p>
 * 각 M에 대해서 N개의 숫자 중에 있는지 확인해야 하므로, O(N*M) = O(N^2) = O(500,000^2)
 * <p>
 * O(N) -> O(1) via map
 * O(N) -> O(log N) via binary search
 */
public class BOJ_10815 {
    static int n, m;
    static int[] narr;
    static int[] marr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        narr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            narr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(narr);
        m = Integer.parseInt(br.readLine());
        marr = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            marr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            int left = 0, right = n - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (narr[mid] == marr[i]) {
                    marr[i] = 1;
                    break;
                }
                if (narr[mid] > marr[i]) {
                    right = mid - 1;
                } else if (narr[mid] < marr[i]) {
                    left = mid + 1;
                }
            }
            if (marr[i] != 1) {
                marr[i] = 0;
            }
        }
        for (int i = 0; i < m; i++) {
            System.out.print(marr[i] + " ");
        }
    }
}
