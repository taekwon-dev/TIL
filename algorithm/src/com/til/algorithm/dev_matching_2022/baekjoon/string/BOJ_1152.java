package com.til.algorithm.dev_matching_2022.baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Youn on 2022/06/24.
 * Title : 단어의 개수 (https://www.acmicpc.net/problem/1152)
 * Hint  : 문자열은 공백으로 시작하거나 끝날 수 있다.
 */
public class BOJ_1152 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        System.out.println(st.countTokens());

    }
}
