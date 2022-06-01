package com.til.algorithm.baekjoon.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Youn on 2022/05/28.
 * Title : 연결 요소의 개수 (https://www.acmicpc.net/problem/11724)
 * Hint  :
 */
public class BOJ_11724_Adj_Matrix {
     static int n, m;
     static int[][] map;
     static boolean[] visited;
     static int result;

     public static void main(String[] args) throws IOException {
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          StringTokenizer st = new StringTokenizer(br.readLine());
          n = Integer.parseInt(st.nextToken());
          m = Integer.parseInt(st.nextToken());
          map = new int[n + 1][n + 1];
          visited = new boolean[n + 1];

          for (int i = 0; i < m; i++) {
               st = new StringTokenizer(br.readLine());
               int from = Integer.parseInt(st.nextToken());
               int to = Integer.parseInt(st.nextToken());
               map[from][to] = 1;
               map[to][from] = 1;
          }

          for (int i = 1; i < n + 1; i++) {
               if (!visited[i]) {
                    dfs(i);
                    result++;
               }
          }
          System.out.println(result);
     }

     private static void dfs(int start) {
          visited[start] = true;
          for (int i = 1; i < n + 1; i++) {
               if (!visited[i] && map[start][i] == 1) {
                    dfs(i);
               }
          }
     }

}
