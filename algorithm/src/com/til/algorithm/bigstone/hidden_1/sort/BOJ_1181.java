package com.til.algorithm.bigstone.hidden_1.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ_1181 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<String> word = new ArrayList<>(n);
        while (n-- > 0) {
            word.add(br.readLine());
        }
        Collections.sort(word, (o1, o2) -> {
            if (o1.length() == o2.length()) {
                return o1.compareTo(o2);
            }
            return o1.length() - o2.length();
        });
        StringBuilder sb = new StringBuilder();
        String prev = null;
        for (String w : word) {
            if (w.equals(prev)) {
                continue;
            }
            prev = w;
            sb.append(w).append("\n");
        }
        System.out.println(sb.toString());
    }
}