package com.til.algorithm.baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Youn on 2022/06/03.
 * Title : !밀비 급일 (https://www.acmicpc.net/problem/11365)
 * Hint  : StringBuffer().reverse().toString()
 */
public class BOJ_11365_Reverse {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String code = br.readLine();
            if (code.equals("END")) {
                break;
            }
            System.out.println(new StringBuffer(code).reverse().toString());
        }
    }
}
