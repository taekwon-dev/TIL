package com.til.algorithm.programmers.kakao.blind_recruitment_2023;

public class LV2_이모티콘할인행사 {

    private int[] discountRatio = {10, 20, 30, 40};
    private int[] discount;
    private int maxJoin;
    private int maxPayment;

    public int[] solution(int[][] users, int[] emoticons) {
        discount = new int[emoticons.length];
        backtracking(users, emoticons, 0);

        int[] answer = {maxJoin, maxPayment};
        return answer;
    }

    private void backtracking(int[][] users, int[] emoticons, int depth) {
        if (depth == emoticons.length) {
            int join = 0;
            int totalPayment = 0;

            for (int[] user : users) {
                int targetDCRatio = user[0];
                int targetPayment = user[1];
                int payment = 0;

                for (int i = 0; i < emoticons.length; i++) {
                    if (targetDCRatio > discount[i]) {
                        continue;
                    }
                    payment += emoticons[i] / 100 * (100 - discount[i]);
                }
                if (payment >= targetPayment) {
                    join++;
                } else {
                    totalPayment += payment;
                }
            }
            if (maxJoin < join) {
                maxJoin = join;
                maxPayment = totalPayment;
            } else if (maxJoin == join && maxPayment < totalPayment) {
                maxPayment = totalPayment;
            }
            return;
        }
        for (int i = 0; i < discountRatio.length; i++) {
            discount[depth] = discountRatio[i];
            backtracking(users, emoticons, depth + 1);
        }
    }
}