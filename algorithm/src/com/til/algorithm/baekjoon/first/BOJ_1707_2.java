package com.til.algorithm.baekjoon.first;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Youn on 2022/05/12.
 * Title : 이분 그래프 (https://www.acmicpc.net/problem/1707)
 * Hint  : BFS
 */
public class BOJ_1707_2 {

    static int k;
    static int v, e;
    static List<Integer>[] graph;
    static int[] colors;
    static boolean bipartite;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < k; tc++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            v = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());

            graph = new ArrayList[v + 1];
            colors = new int[v + 1];

            bipartite = true;

            for (int i = 0; i < e; i++) {
                st = new StringTokenizer(br.readLine());

                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                graph[start].add(end);
                graph[end].add(start);
            }

            Queue<Integer> queue = new LinkedList<>();

            for (int i = 1; i < v + 1; i++) {
                if (colors[i] == 0) {
                    queue.offer(i);
                    colors[i] = 1;

                    while (!queue.isEmpty() && bipartite) {
                        int currV = queue.poll();
                        for (int nextV : graph[currV]) {
                            if (colors[nextV] == 0) {
                                queue.offer(nextV);
                                colors[nextV] = colors[currV] * -1;
                            } else if (colors[nextV] == colors[currV]) {
                                bipartite = false;
                                break;
                            }
                        }
                    }

                }
            }
            System.out.println(bipartite ? "YES" : "NO");
        }
    }

}
