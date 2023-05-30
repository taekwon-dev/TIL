package com.til.algorithm.programmers.kakao.blind_recruitment_2023;

public class LV2_이모티콘할인행사 {

    private int[] discountRatio = {10, 20, 30, 40};
    private int[] discount;
    private int answerJoin = 0;
    private int answerTotalPayment = 0;

    public int[] solution(int[][] users, int[] emoticons) {
        discount = new int[emoticons.length];
        backtracking(users, emoticons, 0);
        int[] answer = {answerJoin, answerTotalPayment};
        return answer;
    }

    private void backtracking(int[][] users, int[] emoticons, int depth) {
        if (depth == discount.length) {
            calculate(users, emoticons);
            return;
        }
        for (int i = 0; i < 4; i++) {
            discount[depth] = discountRatio[i];
            backtracking(users, emoticons, depth + 1);
        }
    }

    private void calculate(int[][] users, int[] emoticons) {
        int join = 0;
        int totalPayment = 0;

        for (int[] user : users) {
            int payment = 0;
            int targetDiscountRatio = user[0];
            int targetPayment = user[1];

            for (int i = 0; i < emoticons.length; i++) {
                if (discount[i] < targetDiscountRatio) {
                    continue;
                }
                payment += (emoticons[i] * (100 - discount[i]) * 0.01);
            }

            if (payment >= targetPayment) {
                join++;
            } else {
                totalPayment += payment;
            }
        }
        if (answerJoin < join) {
            answerJoin = join;
            answerTotalPayment = totalPayment;
        } else if (answerJoin == join && answerTotalPayment < totalPayment) {
            answerTotalPayment = totalPayment;
        }
    }
}