package com.til.algorithm.programmers.kit;

import java.util.Arrays;

public class LV1_K번째수 {

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        int idx = 0;
        for (int[] command : commands) {
            int i = command[0] - 1;
            int j = command[1] - 1;
            int k = command[2] - 1;

            int[] temp = new int[j - i + 1];
            for (int l = 0; l < temp.length; l++) {
                temp[l] = array[i++];
            }

            Arrays.sort(temp);

            answer[idx++] = temp[k];
        }
        return answer;
    }
}