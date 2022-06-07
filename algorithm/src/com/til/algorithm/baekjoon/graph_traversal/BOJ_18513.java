package com.til.algorithm.baekjoon.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by Youn on 2022/05/22.
 * Title : 샘터 (https://www.acmicpc.net/problem/18513)
 * Hint  : BFS (레벨 단위로 접근) + 절댓값 (음수 인덱스) + 변수 타입 (범위 고려)
 *         샘터가 있을 수 있는 공간에 대한 범위는 있지만, 집이 있을 수 있는 범위가 주어지지 않았으므로 샘터가 있을 수 있는 범위로 한정할 필요가 없음 ! (https://www.acmicpc.net/board/view/90114)
 */
public class BOJ_18513 {
    // n 개의 샘터, k 채의 집
    static int n, k;
    static int[] sams;
    static long answer;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        sams = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            sams[i] = Integer.parseInt(st.nextToken());
        }

        bfs();
        System.out.println(answer);
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            queue.offer(sams[i]);
            set.add(sams[i]);
        }
        int dist = 1;


        outer:
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int now = queue.poll();
                int left = now - 1;
                int right = now + 1;

                if (!set.contains(left)) {
                    queue.offer(left);
                    set.add(left);
                    answer += dist;
                    if (--k == 0) {
                        break outer;
                    }
                }

                if (!set.contains(right)) {
                    queue.offer(right);
                    set.add(right);
                    answer += dist;
                    if (--k == 0) {
                        break outer;
                    }
                }
            }
            dist++;
        }
    }

}
