package com.til.algorithm.baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Youn on 2022/06/03.
 * Title : 경고 (https://www.acmicpc.net/problem/3029)
 * Hint  :
 */
public class BOJ_3029 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String currTime = br.readLine();
        String[] currs = currTime.split(":");

        String terrorTime = br.readLine();
        String[] terrors = terrorTime.split(":");

        int[] times = new int[3];
        for (int i = 0; i < 3; i++) {
            times[i] = Integer.parseInt(terrors[i]) - Integer.parseInt(currs[i]);
        }

        if (currTime.equals(terrorTime)) {
            System.out.println("24:00:00");
        } else {
            if (times[2] < 0) {
                times[2] += 60;
                times[1] -= 1;
            }

            if (times[1] < 0) {
                times[1] += 60;
                times[0] -= 1;
            }

            if (times[0] < 0) {
                times[0] += 24;
            }
            System.out.format("%02d:%02d:%02d", times[0], times[1], times[2]);
        }

    }
}
