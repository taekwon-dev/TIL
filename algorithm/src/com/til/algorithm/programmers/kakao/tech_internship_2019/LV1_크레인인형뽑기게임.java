package com.til.algorithm.programmers.kakao.tech_internship_2019;

import java.util.Stack;

public class LV1_크레인인형뽑기게임 {
    public int solution(int[][] board, int[] moves) {
        Stack<Integer> stack = new Stack();
        int answer = 0;
        for (int y : moves) {
            for (int x = 0; x < board.length; x++) {
                if (board[x][y - 1] != 0) {
                    if (!stack.isEmpty()) {
                        if (stack.peek() == board[x][y - 1]) {
                            stack.pop();
                            answer += 1;
                        } else {
                            stack.push(board[x][y - 1]);
                        }
                    } else {
                        stack.push(board[x][y - 1]);
                    }
                    board[x][y - 1] = 0;
                    break;
                }
            }
        }
        return answer * 2;
    }
}
