package com.til.algorithm.baekjoon.greedy;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class BOJ_1744 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> minus = new ArrayList<>();
        ArrayList<Integer> plus = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(br.readLine());

            if (number > 0) {
                plus.add(number);
            } else {
                minus.add(number);
            }
        }

        if (plus.size() > 1) {
            Collections.sort(plus, Comparator.reverseOrder());
        }
        int plusSum = 0;
        int plusIdx = 0;
        while (plusIdx < plus.size()) {
            if (plusIdx + 1 < plus.size() && (plus.get(plusIdx) != 1 && plus.get(plusIdx + 1) != 1)) {
                plusSum += plus.get(plusIdx) * plus.get(plusIdx + 1);
                plusIdx += 2;
            } else {
                plusSum += plus.get(plusIdx);
                plusIdx++;
            }
        }

        if (minus.size() > 1) {
            Collections.sort(minus);
        }
        int minusSum = 0;
        int minusIdx = 0;
        while (minusIdx < minus.size()) {
            if (minusIdx + 1 < minus.size()) {
                minusSum += minus.get(minusIdx) * minus.get(minusIdx + 1);
                minusIdx += 2;
            } else {
                minusSum += minus.get(minusIdx);
                minusIdx++;
            }
        }

        bw.write(plusSum + minusSum + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}