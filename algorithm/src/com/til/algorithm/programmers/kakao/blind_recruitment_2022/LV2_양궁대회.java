package com.til.algorithm.programmers.kakao.blind_recruitment_2022;

public class LV2_양궁대회 {
    int[] answer = {-1};
    int max = Integer.MIN_VALUE;
    public int[] solution(int n, int[] info) {
        backtracking(n, info, new int[info.length], 0);
        return answer;
    }
    private void backtracking(int n, int[] info, int[] ryan, int depth) {
        if (depth == n) {
            int ap = 0;
            int rp = 0;
            for (int i = 0; i < info.length; i++) {
                if (info[i] != 0 || ryan[i] != 0) {
                    if (info[i] >= ryan[i]) {
                        ap += 10 - i;
                    } else {
                        rp += 10 - i;
                    }
                }
            }
            if (rp > ap) {
                if (rp - ap >= max) {
                    answer = ryan.clone();
                    max = rp - ap;
                }
            }
            return;
        }
        for (int i = 0; i < info.length && info[i] >= ryan[i]; i++) {
            ryan[i]++;
            backtracking(n, info, ryan, depth + 1);
            ryan[i]--;
        }
    }
}
