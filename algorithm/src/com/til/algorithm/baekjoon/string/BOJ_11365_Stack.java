package com.til.algorithm.baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * Created by Youn on 2022/06/17.
 * Title : !밀비 급일 (https://www.acmicpc.net/problem/11365)
 * Hint  :
 */
public class BOJ_11365_Stack {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        while (true) {
            String code = br.readLine();
            if (code.equals("END")) {
                break;
            }
            for (int i = 0; i < code.length(); i++) {
                stack.push(code.charAt(i));
            }
            code = "";
            int size = stack.size();
            for (int i = 0; i < size; i++) {
                code += stack.pop();
            }
            System.out.println(code);
        }
    }
}
