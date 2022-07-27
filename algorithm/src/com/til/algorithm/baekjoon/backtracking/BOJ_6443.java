package com.til.algorithm.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 *  애너그램
 *
 *  애너그램 프로그램이란,
 *  입력받은 영단어의 철자들로 만들 수 있는 모든 단어를 출력하는 것이다
 *
 *  가령 "abc" 를 입력받았다면,
 *  "abc",
 *  "acb",
 *  "bac",
 *  "bca",
 *  "cab",
 *  "cba"
 *  를 출력해야 한다.
 *
 *  3! = 3 * 2 * 1 = 6
 *
 *  입력받은 단어내에 몇몇 철자가 중복될 수 있다.
 *  이 경우 같은 단어가 여러 번 만들어 질 수 있는데, (1) 한 번만 출력해야 한다.
 *  또한 (2) 출력할 때에 알파벳 순서로 출력해야 한다.
 *
 *  aabbc = 줄 세우기 -> 중복 순열
 *
 *  깊이
 *  이전 노드
 *  방문 여부
 *
 */
public class BOJ_6443 {
    static int n;
    static char[] chars;
    static char[] words;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int t = 0; t < n; t++) {
            String word = br.readLine();
            words = new char[word.length()];
            for (int i = 0; i < word.length(); i++) {
                words[i] = word.charAt(i);
            }
            Arrays.sort(words);
            chars = new char[word.length()];
            visited = new boolean[word.length()];
            backtracking(0);
        }
        System.out.println(sb.toString());
    }

    private static void backtracking(int depth) {
        if (depth == words.length) {
            // 출력
            for (int i = 0; i < words.length; i++) {
                sb.append(chars[i]);
            }
            sb.append("\n");
            return;
        }
        char prev = 'A';
        for (int i = 0; i < words.length; i++) {
            if (!visited[i] && prev != words[i]) {
                visited[i] = true;
                prev = words[i];
                chars[depth] = words[i];
                backtracking(depth + 1);
                visited[i] = false;
            }
        }

    }
}
