package com.til.algorithm.baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * Created by Youn on 2022/06/11.
 * Title : 과제 안 내신 분 ..? (https://www.acmicpc.net/problem/5597)
 * Hint  : 1 ~ 30 중 없는 번호 출력
 */
public class BOJ_5597_Map {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap map = new HashMap();
        for (int i = 1; i <= 28; i++) {
            int n = Integer.parseInt(br.readLine());
            map.put(n, true);
        }
        for (int i = 1; i <= 30; i++) {
            if (map.get(i) == null) {
                System.out.println(i);
            }
        }
    }
}
