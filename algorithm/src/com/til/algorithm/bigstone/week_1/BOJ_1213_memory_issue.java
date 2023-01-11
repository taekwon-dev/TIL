package com.til.algorithm.bigstone.week_1;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  Brute Force (via Backtracking) + Palindrome 판정
 *  메모리 초과 코드 + 문제 의도와 맞지 않은 풀이
 */
public class BOJ_1213_memory_issue {

    private static char[] name;
    private static boolean[] visited;
    private static List<String> names = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        name = br.readLine().toCharArray();
        Arrays.sort(name);
        visited = new boolean[name.length];
        backtracking(0, "");
        if (names.size() == 0) {
            bw.write("I'm Sorry Hansoo" + "\n");
        } else {
            bw.write(names.get(0));
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static void backtracking(int depth, String s) {
        if (depth == name.length) {
            if (isPalindrome(s)) {
                names.add(s);
            }
            return;
        }
        char prev = 'a';
        for (int i = 0; i < name.length; i++) {
            if (!visited[i] && prev != name[i]) {
                prev = name[i];
                visited[i] = true;
                backtracking(depth + 1, s + name[i]);
                visited[i] = false;
            }
        }
    }

    private static boolean isPalindrome(String s) {
        String former = null;
        String latter = null;
        if (s.length() % 2 == 0) {
            former = s.substring(0, s.length() / 2);
            latter = new StringBuilder(s.substring(s.length() / 2)).reverse().toString();
            return equals(former, latter);
        }
        former = s.substring(0, s.length() / 2);
        latter = new StringBuilder(s.substring(s.length() / 2 + 1)).reverse().toString();
        return equals(former, latter);
    }

    private static boolean equals(String former, String latter) {
        return former.equals(latter);
    }
}