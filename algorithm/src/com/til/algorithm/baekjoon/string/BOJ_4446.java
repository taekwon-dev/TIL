package com.til.algorithm.baekjoon.string;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BOJ_4446 {

    private static final List<Character> vowels = new ArrayList<>(Arrays.asList('a', 'i', 'y', 'e', 'o', 'u'));
    private static final List<Character> consonants = new ArrayList<>(Arrays.asList('b', 'k', 'x', 'z', 'n', 'h', 'd', 'c', 'w', 'g', 'p', 'v', 'j', 'q', 't', 's', 'r', 'l', 'm', 'f'));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String target;
        while ((target = br.readLine()) != null) {
            StringBuilder answer = new StringBuilder();
            for (char c : target.toCharArray()) {
                if (c >= ' ' && c < 'A') {
                    answer.append(c);
                    continue;
                }
                int index = -1;
                if (Character.isUpperCase(c)) {
                    char lowerCase = Character.toLowerCase(c);
                    if (vowels.contains(lowerCase)) {
                        index = vowels.indexOf(lowerCase);
                        if (index + 3 < vowels.size()) {
                            answer.append(Character.toUpperCase(vowels.get(index + 3)));
                            continue;
                        }
                        answer.append(Character.toUpperCase(vowels.get(index + 3 - vowels.size())));
                        continue;
                    }
                    index = consonants.indexOf(lowerCase);
                    if (index + 10 < consonants.size()) {
                        answer.append(Character.toUpperCase(consonants.get(index + 10)));
                        continue;
                    }
                    answer.append(Character.toUpperCase(consonants.get(index + 10 - consonants.size())));
                    continue;
                }
                if (vowels.contains(c)) {
                    index = vowels.indexOf(c);
                    if (index + 3 < vowels.size()) {
                        answer.append(vowels.get(index + 3));
                        continue;
                    }
                    answer.append(vowels.get(index + 3 - vowels.size()));
                    continue;
                }
                index = consonants.indexOf(c);
                if (index + 10 < consonants.size()) {
                    answer.append(consonants.get(index + 10));
                    continue;
                }
                answer.append(consonants.get(index + 10 - consonants.size()));
                continue;
            }
            bw.write(answer.toString() + "\n");
            bw.flush();
        }
        bw.close();
        br.close();
    }
}