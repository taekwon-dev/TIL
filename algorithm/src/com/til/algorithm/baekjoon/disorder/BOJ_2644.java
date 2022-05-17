package com.til.algorithm.baekjoon.disorder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by Youn on 2022/05/11.
 * Title : 촌수계산 (https://www.acmicpc.net/problem/2644)
 * Hint  : 그래프 표현 → 인접 행렬, 인접 리스트 (https://loosie.tistory.com/151)
 */
public class BOJ_2644 {

    static List<Integer>[] relation;
    static boolean[] visited;
    static int result = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        relation = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        // 인접 리스트
        for (int i = 1; i < n+1; i++) {
            relation[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int z = Integer.parseInt(br.readLine());

        for (int i = 0; i < z; i++) {
            st = new StringTokenizer(br.readLine());

            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            relation[p].add(c);
            relation[c].add(p);
        }
        dfs(x, y, 0);
        System.out.println(result);
    }

    private static void dfs(int start, int end, int count) {
        if (start == end) {
            result = count;
            return;
        }

        visited[start] = true;
        for (int i = 0; i < relation[start].size(); i++) {
            int next = relation[start].get(i);
            if (!visited[next]) {
                dfs(next, end, count+1);
            }
        }
    }
}
