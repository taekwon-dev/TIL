package com.til.algorithm.baekjoon.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  트리 : 순회결과로 원본트리 재현하기
 *
 *  in + pre (O) ✔️
 *  in + post (O)
 *  pre + post (X)
 */
public class BOJ_4256 {
    static int[] pre, in;
    static int preIdx;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int t = Integer.parseInt(br.readLine());
        while (t --> 0) {
            int n = Integer.parseInt(br.readLine());
            pre = new int[n];
            in = new int[n];
            preIdx = 0;
            sb = new StringBuilder();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                pre[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                in[i] = Integer.parseInt(st.nextToken());
            }
            solve(0, n - 1);
            System.out.println(sb.toString());
        }
    }

    private static void solve(int start, int end) {
        if (start > end) return;
        int root = pre[preIdx++];
        int inIdx = -1;
        for (int i = start; i <= end; i++) {
            if (in[i] == root) {
                inIdx = i;
                break;
            }
        }
        solve(start, inIdx - 1);
        solve(inIdx + 1, end);
        sb.append(root + " ");
    }

}
