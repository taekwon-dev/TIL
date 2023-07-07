package com.til.algorithm.programmers.kit;

import java.util.Stack;

public class LV2_택배상자 {

    public int solution(int[] order) {
        Stack<Integer> stack = new Stack<>();

        int answer = 0;
        int i = 1;
        int j = 0;

        while (j < order.length) {
            if (i < order[j]) {
                stack.push(i);
                i++;
                continue;
            }
            if (i == order[j]) {
                answer++;
                i++;
                j++;
                continue;
            }
            while (!stack.isEmpty() && stack.peek() == order[j]) {
                answer++;
                j++;
                stack.pop();
            }
            if (j >= order.length || order[j] < i) {
                break;
            }
        }
        return answer;
    }
}