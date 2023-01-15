package com.til.algorithm.baekjoon.string;

import java.io.*;
import java.util.HashSet;

public class BOJ_9536 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb;

        for (int t = 0; t < T; t++) {
            String[] sounds = br.readLine().split(" ");
            HashSet<String> givenSounds = new HashSet<>();
            String input;
            while (!(input = br.readLine()).endsWith("?")) {
                String[] animalSound = input.split(" ");
                givenSounds.add(animalSound[2]);
            }
            sb = new StringBuilder();
            for (String sound : sounds) {
                if (!givenSounds.contains(sound)) {
                    sb.append(sound).append(" ");
                }
            }

            bw.write(sb.toString() + "\n");
            bw.flush();
        }
        bw.close();
        br.close();
    }
}