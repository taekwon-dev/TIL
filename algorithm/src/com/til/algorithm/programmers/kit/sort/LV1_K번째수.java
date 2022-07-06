package com.til.algorithm.programmers.kit.sort;

import java.util.Arrays;

public class LV1_K번째수 {

    /**
     *  1) commands.length = return array size
     *  2) command 별로 array 공유
     *  3) Arrays.sort()
     *  4) Arrays.copyOfRange(arr, start, end)
     *     ex) [1, 2, 3, 4] copyOfRande(0, 2) = 1, 2 (시작 범위 : 포함, 끝 범위 : 미포함)
     *
     *  5) 문제에서 정의된 인덱스를 기준으로 문제 풀기
     */

    public int[] solution(int[] array, int[][] commands) {

        int[] answer = new int[commands.length];
        for (int i = 0; i < answer.length; i++) {
            int[] arr = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
            Arrays.sort(arr);
            answer[i] = arr[commands[i][2] - 1];
        }
        return answer;
    }

}
