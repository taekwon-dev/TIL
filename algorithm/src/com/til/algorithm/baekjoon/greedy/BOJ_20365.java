package com.til.algorithm.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_20365 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] arr = br.readLine().toCharArray();
        int r = 0;
        int b = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'B') {
                b++;
                while (i < arr.length - 1) {
                    if (arr[i] == arr[i + 1]) {
                        i++;
                    } else {
                        break;
                    }
                }
            } else {
                r++;
                while (i < arr.length - 1) {
                    if (arr[i] == arr[i + 1]) {
                        i++;
                    } else {
                        break;
                    }
                }
            }
        }
        int result = 1 + Math.min(b, r);
        System.out.println(result);
    }
}
