package com.til.algorithm.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 *  부등호
 *
 *  두 종류의 부등호 기호 ‘<’와 ‘>’가 k개 나열된 순서열 A가 있다. (k의 범위는 2 ≤ k ≤ 9)
 *  이 부등호 기호 앞뒤에 서로 다른 한 자릿수 숫자를 넣어서 모든 부등호 관계를 만족시키려고 한다
 *
 *  A ⇒ < < < > < < > < >
 *
 *  부등호 기호 앞뒤에 넣을 수 있는 숫자는 0부터 9까지의 정수이며
 *  선택된 숫자는 모두 달라야 한다.
 *
 *  3 < 4 < 5 < 6 > 1 < 2 < 8 > 7 < 9 > 0 = 3456128790
 *
 *  이 상황에서 부등호 기호를 제거한 뒤, 숫자를 모두 붙이면 하나의 수를 만들 수 있는데
 *  이 수를 주어진 부등호 관계를 만족시키는 정수
 *
 *  여러분은 제시된 k개의 부등호 순서를 만족하는 (k+1)자리의 정수 중에서
 *  최댓값과 최솟값을 찾아야 한다
 *
 */
public class BOJ_2529 {
    static int k;
    static char[] signs;
    static boolean[] visited = new boolean[9 + 1];
    static ArrayList<String> nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        signs = new char[k];
        nums = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            signs[i] = st.nextToken().charAt(0);
        }
        backtracking(0, "");
        Collections.sort(nums);
        System.out.println(nums.get(nums.size() - 1));
        System.out.println(nums.get(0));
    }

    private static void backtracking(int depth, String num) {
        if (depth == k + 1) {
            nums.add(num);
            return;
        }
        for (int i = 0; i < 10; i++) {
            if (depth == 0 || !visited[i] && compare(num.charAt(num.length() - 1) - '0', i, signs[depth - 1])) {
                visited[i] = true;
                backtracking(depth + 1, num + i);
                visited[i] = false;
            }
        }
    }

    private static boolean compare(int x, int y, char c) {
        if (c == '<') return x < y;
        else return x > y;
    }
}
