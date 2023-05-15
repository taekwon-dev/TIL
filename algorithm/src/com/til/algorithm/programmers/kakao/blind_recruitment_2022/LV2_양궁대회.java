package com.til.algorithm.programmers.kakao.blind_recruitment_2022;

public class LV2_양궁대회 {

    private int max = Integer.MIN_VALUE;
    private int[] answer = {-1};
    private int[] ryan = new int[11];

    public int[] solution(int n, int[] info) {
        backtracking(n, info, 0);
        return answer;
    }

    private void backtracking(int n, int[] info, int arrow) {
        if (arrow == n) {
            int aPoint = 0;
            int rPoint = 0;

            for (int i = 0; i <= 10; i++) {
                if (info[i] != 0 || ryan[i] != 0) {
                    if (info[i] < ryan[i]) {
                        rPoint += 10 - i;
                    } else if (info[i] >= ryan[i]) {
                        aPoint += 10 - i;
                    }
                }
            }
            if (rPoint > aPoint) {
                if (rPoint - aPoint >= max) {
                    max = rPoint - aPoint;
                    answer = ryan.clone();
                }
            }
            return;
        }
        for (int i = 0; i <= 10 && info[i] >= ryan[i]; i++) {
            ryan[i]++;
            backtracking(n, info, arrow + 1);
            ryan[i]--;
        }
    }
}