package com.til.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by Youn on 2022/05/11.
 * Title : 이분 그래프 (https://www.acmicpc.net/problem/1707)
 * Hint  :
 */
public class BOJ_1707 {

    static List<Integer>[] map;
    static int v, e;
    static int[] colors;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());

        for (int tc = 0; tc < k; tc++) {
            st = new StringTokenizer(br.readLine());
            v = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());

            map = new ArrayList[v + 1];
            colors = new int[v + 1];

            for (int i = 0; i < v + 1; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                map[start].add(end);
                map[end].add(start);
            }
        }
    }

    private static void dfs(int start, int color) {
        colors[start] = color;
        for (int i = 0; i < map[start].size(); i++) {
            if (colors[start] == map[start].get(i)) {
                System.out.println("NO");
                break;
            }
        }

    }





}
