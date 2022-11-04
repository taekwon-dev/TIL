package com.til.algorithm.programmers.kit;

import java.util.ArrayDeque;
import java.util.Deque;

public class LV1_같은숫자는싫어 {
    public int[] solution(int []arr) {
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i : arr) {
            if (deque.isEmpty()) {
                deque.add(i);
            } else {
                if (deque.peekLast() == i) {
                    continue;
                } else {
                    deque.add(i);
                }
            }
        }
        int[] answer = new int[deque.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = deque.removeFirst();
        }
        return answer;
    }
}
