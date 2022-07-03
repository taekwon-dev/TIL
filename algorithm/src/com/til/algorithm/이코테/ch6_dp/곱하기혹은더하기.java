package com.til.algorithm.이코테.ch6_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Youn on 2022/05/17.
 * Title : 곱하기 혹은 더하기 (https://youtu.be/2zjoKjt97vQ?list=PLRx0vPvlEmdAghTr5mXQxGpHjWqSz0dgC&t=1149)
 * Hint  :
 */
public class 곱하기혹은더하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        long result = s.charAt(0) - '0';
        for (int i = 1; i < s.length(); i++) {
            int num = s.charAt(i) - '0';
            if (num <= 1 || result <= 1) {
                result += num;
            } else {
                result *= num;
            }
        }
        System.out.println(result);
    }
}
