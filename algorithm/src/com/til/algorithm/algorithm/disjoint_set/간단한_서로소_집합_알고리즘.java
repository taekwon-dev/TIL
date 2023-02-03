package com.til.algorithm.algorithm.disjoint_set;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  Union 연산이 편향되게 이루어지는 경우, Find 연산이 비효율적으로 동작합니다.
 *  최악의 경우, Find 시 모든 노드를 다 확인하게 되어 시간 복잡도가 O(V)가 됩니다.
 *
 *  예시)
 *  1 <- 2 <- 3 <- 4 <- 5
 */
public class 간단한_서로소_집합_알고리즘 {

    public static int v, e;
    public static int[] parent = new int[100_001];

    public static int findParent(int x) {
        if (x == parent[x]) {
            return x;
        }
        return findParent(parent[x]);
    }

    public static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= v; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            unionParent(a, b);
        }
    }
}