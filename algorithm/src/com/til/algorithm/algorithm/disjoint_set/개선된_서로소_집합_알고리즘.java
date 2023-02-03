package com.til.algorithm.algorithm.disjoint_set;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  Find 함수를 최적화하기 위한 방법으로 경로 압축(Path Compression)을 이용할 수 있다.
 *  Union 연산을 처리한 뒤, Find 함수를 수행하면 부모 테이블이 각각 루트 노드를 가리킬 수 있도록 갱신됩니다.
 */
public class 개선된_서로소_집합_알고리즘 {

    public static int v, e;
    public static int[] parent = new int[100_001];

    public static int findParent(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = findParent(parent[x]);
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