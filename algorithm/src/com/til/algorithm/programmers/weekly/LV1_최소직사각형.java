package com.til.algorithm.programmers.weekly;

/**
 * Created by Youn on 2022/06/18.
 * Title : 최소직사각형 (https://programmers.co.kr/learn/courses/30/lessons/86491)
 * Hint  :
 */
public class LV1_최소직사각형 {
    public int solution(int[][] sizes) {
        int w_max = 1, h_max = 1;
        int temp = 0;
        for (int i = 0; i < sizes.length; i++) {
            if (sizes[i][0] < sizes[i][1]) {
                temp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = temp;
            }

            w_max = Math.max(w_max, sizes[i][0]);
            h_max = Math.max(h_max, sizes[i][1]);
        }
        return w_max * h_max;
    }
}
