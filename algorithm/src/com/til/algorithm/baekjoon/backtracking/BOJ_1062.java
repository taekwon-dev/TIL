package com.til.algorithm.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 *  가르침
 *
 *  K개의 글자
 *  K개의 글자로 이루어진 단어
 *
 *  어떤 K개의 글자를 가르쳐야 많은 단어를 읽을 수 있을까?
 *  남극의 모든 단어는
 *  - anta ~
 *  - ~ tica
 *  - 총 N개의 단어
 *
 *  N은 50보다 작거나 같은 자연수
 *  K는 26보다 작거나 같은 자연수 또는 0이다
 *  단어는 영어 소문자로만 이루어져 있고, 길이가 8보다 크거나 같고, 15보다 작거나 같다. 모든 단어는 중복되지 않는다.
 *
 *  일단 N개의 단어에서 공통 5개는 반드시 포함되어 있어야 한다.
 *  - a
 *  - n
 *  - t
 *  - i
 *  - c
 *
 *  예를 들어,
 *  N = 2, K = 3
 *  antaxxxxxxxtica
 *  antarctica
 *
 *  조건이 주어졌을 때 학생들이 3개의 글자만 알려줬을 때 읽을 수 있는 단어는 0개다.
 *
 *  K >= 5 라고 가정하자. (k < 5 인 경우에는 답 0)
 *
 *  주어진 단어에서 위 5개를 제외한 다른 글자가 우리가 5개 외 추가로 알려줘야 하는 글자 리스트가 된다.
 *  단, K개를 알려줬을 떄 읽을 수 있는 단어 수가 최대가 되기 위해서는 위 리스트에서 어떤 글자를 알려줘야 할 지 찾아야 한다. -> Brute force
 *
 *  근데, 잠깐
 *  이 문제에서 어떤 단어를 읽을 수 있다는 것은
 *  학생 입장에서 배운 글자들로 조합된 단어인 경우에만 읽을 수 있다는 것을 의미한다.
 *
 *  -> abcabcd
 *  -> a, b, c, d 를 배웠다면 읽을 수 있다.
 *  -> a, b, c 만 배웠다면 읽을 수 없다.
 *     -> 배운 글자에 해당하는 것을 단어에서 0으로 대체해보자.
 *     -> 000000d
 *     -> 0 외 다른 글자가 있다면 읽을 수 없는 수
 *
 *  a, c, i, n, t + 이외의 글자 (-> K만큼)
 *
 *  -> 위 리스트를 통해 읽을 수 있는 단어 수를 체크
 *  -> 읽을 수 있는 단어의 최댓값 (-> 이 문제의 답)
 *
 *  주어진 단어를 통해 각 단어를 이루고 있는 (중복 제거) 글자 리스트 확보
 *  해당 리스트에서 K개의 글자 리스트 만들어가면서 읽을 수 있는 단어의 최댓값 구하기
 */
public class BOJ_1062 {
    static int n, k;
    static int max = 0;
    static boolean[] visited;
    static String[] words;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        if (k < 5) {
            System.out.println("0");
            return;
        } else if (k == 26) {
            System.out.println(n);
            return;
        }
        words = new String[n];
        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            word = word.replace("anta", "");
            word = word.replace("tica", "");
            words[i] = word;
        }
        visited = new boolean[26];
        visited['a' - 'a'] = true;
        visited['c' - 'a'] = true;
        visited['i' - 'a'] = true;
        visited['n' - 'a'] = true;
        visited['t' - 'a'] = true;

        backtracking(0, 0);
        System.out.println(max);
    }

    private static void backtracking(int depth, int index) {
        if (depth == k - 5) {
            int count  = 0;
            for (int i = 0; i < n; i++) {
                boolean read = true;
                for (int j = 0; j < words[i].length(); j++) {
                    if (!visited[words[i].charAt(j) - 'a']) {
                        read = false;
                        break;
                    }
                }
                if (read) count++;
            }
            max = Math.max(max, count);
            return;
        }
        for (int i = index; i < 26; i++) {
            if (!visited[i]) {
                visited[i] = true;
                backtracking(depth + 1, i);
                visited[i] = false;
            }
        }

    }
}
