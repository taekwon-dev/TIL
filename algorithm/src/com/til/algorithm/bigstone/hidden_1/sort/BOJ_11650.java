package com.til.algorithm.bigstone.hidden_1.sort;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11650 {

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Node[] nodes = new Node[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            nodes[i] = new Node(x, y);
        }
        Arrays.sort(nodes, (n1, n2) -> {
            if (n1.x == n2.x) {
                return n1.y - n2.y;
            }
            return n1.x - n2.x;
        });

        StringBuilder sb = new StringBuilder();
        for (Node node : nodes) {
            sb.append(node.x).append(" ").append(node.y);
            sb.append("\n");
        }

        bw.write(sb.toString() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}