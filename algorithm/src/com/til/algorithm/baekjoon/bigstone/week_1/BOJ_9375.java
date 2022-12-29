package com.til.algorithm.baekjoon.bigstone.week_1;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_9375 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());
        for (int t = 0; t < tc; t++) {
            Map<String, Integer> cloth = new HashMap<>();
            int n = Integer.parseInt(br.readLine());
            while (n-- > 0) {
                st = new StringTokenizer(br.readLine());
                st.nextToken();
                String type = st.nextToken();

                if (cloth.containsKey(type)) {
                    cloth.put(type, cloth.get(type) + 1);
                    continue;
                }
                cloth.put(type, 1);
            }
            int answer = 1;
            for (int count : cloth.values()) {
                answer *= (count + 1);
            }
            sb.append(answer - 1).append('\n');
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}