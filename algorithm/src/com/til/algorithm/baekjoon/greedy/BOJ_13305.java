package com.til.algorithm.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dist = new int[n - 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n - 1; i++) {
            dist[i] = Integer.parseInt(st.nextToken());
        }
        int[] cost = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }
        int min = cost[0];
//        for (int i = 1; i < n - 1; i++) {
//            if (min > cost[i]) {
//                min = cost[i];
//            }
//        }
        long result = 0;
        for (int i = 0; i < n - 1; i++) {
            if (cost[i] < min) {
                min = cost[i];
            }
            result += min * dist[i];
        }
//        for (int i = 0; i < n - 1; i++) {
//            if (cost[i] > min) {
//                result += cost[i] * dist[i];
//            }
//            if (cost[i] == min) {
//                int left = 0;
//                for (int j = i; j < n - 1; j++) {
//                    left += dist[j];
//                }
//                result += cost[i] * left;
//                break;
//            }
//        }
        System.out.println(result);
    }
}
