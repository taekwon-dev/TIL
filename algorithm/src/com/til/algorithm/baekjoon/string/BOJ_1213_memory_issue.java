package com.til.algorithm.baekjoon.string;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class BOJ_1213_memory_issue {

    private static char[] name;
    private static boolean[] visited;
    private static ArrayList<String> candidates = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        name = br.readLine().toCharArray();
        Arrays.sort(name);

        visited = new boolean[name.length];

        backtracking(0, "");

        if (candidates.size() == 0) {
            bw.write("I'm Sorry Hansoo" + "\n");
        } else {
            bw.write(candidates.get(0) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static void backtracking(int depth, String candidate) {
        if (depth == name.length) {
            if (isPalindrome(candidate)) {
                candidates.add(candidate);
            }
            return;
        }
        for (int i = 0; i < name.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                backtracking(depth + 1, candidate + name[i]);
                visited[i] = false;
            }
        }
    }

    private static boolean isPalindrome(String candidate) {
        int i = 0;
        int j = candidate.length() - 1;

        while (i < j) {
            if (candidate.charAt(i) == candidate.charAt(j)) {
                i++;
                j--;
                continue;
            }
            return false;
        }
        return true;
    }
}