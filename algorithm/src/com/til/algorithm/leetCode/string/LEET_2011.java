package com.til.algorithm.leetCode.string;

public class LEET_2011 {

    public int finalValueAfterOperations(String[] operations) {
        int answer = 0;
        for (String operation : operations) {
            if (operation.contains("+")) {
                answer++;
                continue;
            }
            if (operation.contains("-")) {
                answer--;
            }
        }
        return answer;
    }
}