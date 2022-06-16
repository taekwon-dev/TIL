package com.til.algorithm.baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * Created by Youn on 2022/06/03.
 * Title : 이 구역의 승자는 누구야?! (https://www.acmicpc.net/problem/20154)
 * Hint  : A ~ Z (26)
 */
public class BOJ_20154 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] values = {3, 2, 1, 2, 3, 3, 3, 3, 1, 1, 3, 1, 3, 3, 1, 2, 2, 2, 1, 2, 1, 1, 2, 2, 2, 1};
        String input = br.readLine();
        int[] nums = new int[input.length()];
        int result = 0;
        for (int i = 0; i < input.length(); i++) {
            nums[i] = values[input.charAt(i) - 'A'];
            result += nums[i];
        }
        result %= 10;

        if (result % 2 == 0) {
            System.out.println("You're the winner?");
        } else {
            System.out.println("I'm a winner!");
        }


    }
}
