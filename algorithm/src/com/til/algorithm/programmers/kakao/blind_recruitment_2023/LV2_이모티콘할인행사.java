package com.til.algorithm.programmers.kakao.blind_recruitment_2023;

public class LV2_이모티콘할인행사 {

    private int[] discountRatio;
    private int[] discount = {10, 20, 30, 40};
    private int[][] users;
    private int[] emoticons;
    private int maxEnroll;
    private int maxPay;

    public int[] solution(int[][] users, int[] emoticons) {
        this.discountRatio = new int[emoticons.length];
        this.users = users;
        this.emoticons = emoticons;

        backtracking(0);

        int[] answer = new int[2];
        answer[0] = maxEnroll;
        answer[1] = maxPay;

        return answer;
    }

    private void backtracking(int depth) {
        if (depth == discountRatio.length) {
            calculate();
            return;
        }
        for (int i = 0; i < discount.length; i++) {
            discountRatio[depth] = discount[i];
            backtracking(depth + 1);
        }
    }

    private void calculate() {
        int enroll = 0;
        int totalPay = 0;

        for (int[] user : users) {
            int targetRatio = user[0];
            int targetPay = user[1];

            int pay = 0;
            for (int i = 0; i < emoticons.length; i++) {
                if (targetRatio <= discountRatio[i]) {
                    pay += emoticons[i] / 100 * (100 - discountRatio[i]);
                }
            }
            if (pay >= targetPay) {
                enroll++;
            } else {
                totalPay += pay;
            }
        }
        if (maxEnroll < enroll) {
            maxEnroll = enroll;
            maxPay = totalPay;
        } else if (maxEnroll == enroll && maxPay < totalPay) {
            maxPay = totalPay;
        }
    }
}