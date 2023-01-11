package com.til.algorithm.bigstone.week_2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1068 {

    private static int n;
    private static int root;
    private static int d;
    private static List<Integer>[] tree;
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        tree = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if (parent == -1) {
                root = i;
                continue;
            }
            tree[parent].add(i);
        }
        d = Integer.parseInt(br.readLine());
        if (root == d) {
            bw.write(0 + "\n");
        } else {
            leaf(root);
            bw.write(answer + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static void leaf(int parent) {
        if (parent == d) {
            return;
        }
        if (tree[parent].size() == 0) {
            answer++;
            return;
        }
        if (tree[parent].contains(d) && tree[parent].size() == 1) {
            answer++;
            return;
        }
        for (int child : tree[parent]) {
            if (child == d) {
                continue;
            }
            leaf(child);
        }
    }
}