package com.til.algorithm.baekjoon.string;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_6550 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input;
        StringTokenizer st;
        Queue<Character> queue;
        while ((input = br.readLine()) != null) {
            st = new StringTokenizer(input);
            String S = st.nextToken();
            String T = st.nextToken();

            queue = new LinkedList<>();
            for (char c : S.toCharArray()) {
                queue.add(c);
            }
            for (char c : T.toCharArray()) {
                if (c == queue.peek()) {
                    queue.poll();
                    if (queue.isEmpty()) {
                        bw.write("Yes" + "\n");
                        break;
                    }
                }
            }
            if (!queue.isEmpty()) {
                bw.write("No" + "\n");
            }
            bw.flush();
        }
        bw.close();
        br.close();
    }
}