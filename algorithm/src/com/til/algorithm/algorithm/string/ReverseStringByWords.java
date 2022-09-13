package com.til.algorithm.algorithm.string;

import java.util.Stack;
import java.util.StringTokenizer;

public class ReverseStringByWords {
    public static void main(String[] args) {
        String description = "Java technology blog for smart java concepts and coding practices";
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(description, " ");
        while (st.hasMoreTokens()) {
            stack.push(st.nextToken());
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop() + " ");
        }
        System.out.println("sb.toString() = " + sb.toString());
    }
}
