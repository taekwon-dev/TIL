package com.til.algorithm.bigstone.week_1;

import java.io.*;
import java.util.*;

public class BOJ_1620 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<Integer, String> idx = new HashMap<>();
        Map<String, Integer> name = new HashMap<>();

        int index = 1;
        String pocketmon = null;
        while (n-- > 0) {
             pocketmon = br.readLine();
            idx.put(index, pocketmon);
            name.put(pocketmon, index++);
        }

        StringBuilder sb = new StringBuilder();
        String quiz = null;
        while (m-- > 0) {
            quiz = br.readLine();
            if (isNumber(quiz)) {
                bw.write(idx.get(Integer.parseInt(quiz)) + "\n");
                continue;
            }
            bw.write(name.get(quiz) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static boolean isNumber(String quiz) {
        for (char c : quiz.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}