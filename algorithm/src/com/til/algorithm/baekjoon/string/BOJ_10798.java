package com.til.algorithm.baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Youn on 2022/06/03.
 * Title : 세로읽기 (https://www.acmicpc.net/problem/10798)
 * Hint  : Empty Char Literal : '\0'
 *
 */
public class BOJ_10798 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] map = new char[5][15];
        int max = 0;


        for (int i = 0; i < 5; i++) {
            String row = br.readLine();
            if (max < row.length()) {
                max = row.length();
            }
            for (int j = 0; j < row.length(); j++) {
                map[i][j] = row.charAt(j);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < max; i++) {
            for (int j = 0; j < 5; j++) {
                if (map[j][i] == '\0') {
                    continue;
                }
                sb.append(map[j][i]);
            }
        }
        System.out.println(sb);

    }
}
