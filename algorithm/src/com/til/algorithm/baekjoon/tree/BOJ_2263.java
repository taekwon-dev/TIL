package com.til.algorithm.baekjoon.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  ⚠️
 *  트리의 순회
 */
public class BOJ_2263 {
    static int n;
    static int[] inorder;
    static int[] inIdx;
    static int[] postorder;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        inorder = new int[n + 1];
        inIdx = new int[n + 1];
        postorder = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            inorder[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            postorder[i] = Integer.parseInt(st.nextToken());
        }

        // 값을 통해서 inoder 의 몇 번째 위치 했는지 파악
        for (int i = 1; i <= n; i++) {
            inIdx[inorder[i]] = i;
        }

        solve(1, n, 1, n);
        System.out.println(sb.toString());
    }

    private static void solve(int is, int ie, int ps, int pe) {
        if (ie < is || pe < ps) return;
        int root = postorder[pe];
        int rootIdx = inIdx[root];
        sb.append(root + " ");

        int len = rootIdx - is;
        solve(is, rootIdx - 1, ps, ps + len - 1);
        solve(rootIdx + 1, ie, ps + len, pe - 1);

    }

}
