package com.til.algorithm.baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Youn on 2022/06/11.
 * Title : 🐜 기적의 매매법 🐜 (https://www.acmicpc.net/problem/20546)
 * Hint  :
 */
public class BOJ_20546 {

    static int n;
    static int[] days = new int[15];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= 14; i++) {
            days[i] = Integer.parseInt(st.nextToken());
        }

        int jh = jh();
        int sm = sm();

        if (jh > sm) {
            System.out.println("BNP");
        } else if (jh < sm) {
            System.out.println("TIMING");
        } else {
            System.out.println("SAMESAME");
        }

    }

    private static int jh() {
        int ju = 0;
        int left = n;
        int count = 0;

        for (int i = 1; i <= 14; i++) {
            if (left >= days[i]) {
                count = (left / days[i]); // 살 수 있는 주
                ju += count;
                left -= count * days[i];
            }
        }
        return left + (ju * days[14]);
    }

    private static int sm() {
        int ju = 0;
        int left = n;
        int count = 0;
        int up = 0, down = 0;
        for (int start = 1; start <= 13; start++) {
            if (days[start] < days[start + 1]) {
                up += 1;
                down = 0;
            } else if (days[start] > days[start + 1]) {
                up = 0;
                down += 1;
            } else {
                up = 0;
                down = 0;
            }

            if (up == 3) {
                // 매도
                left += (ju * days[start + 1]);
                ju = 0;
                up = 0;
            }

            if (down == 3) {
                // 매수
                if (left >= days[start + 1]) {
                    count = (left / days[start + 1]);
                    ju += count;
                    left -= count * days[start + 1];
                }
                down = 0;
            }
        }
        return left + (ju * days[14]);
    }
}
