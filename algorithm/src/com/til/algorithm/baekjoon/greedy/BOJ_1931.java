package com.til.algorithm.baekjoon.greedy;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1931 {

    static class Node {
        int start;
        int end;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = null;
        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            nodes.add(new Node(start, end));
        }

        Collections.sort(nodes, (o1, o2) -> {
            if (o1.end == o2.end) {
                return o1.start - o2.start;
            }
            return o1.end - o2.end;
        });

        int answer = 1;
        int e = nodes.get(0).end;
        for (int i = 1; i < n; i++) {
            if (nodes.get(i).start < e) {
                continue;
            }
            e = nodes.get(i).end;
            answer++;
        }
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}