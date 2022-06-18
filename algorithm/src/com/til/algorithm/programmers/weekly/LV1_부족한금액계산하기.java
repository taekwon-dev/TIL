package com.til.algorithm.programmers.weekly;

/**
 * Created by Youn on 2022/06/18.
 * Title : 부족한 금액 계산하기 (https://programmers.co.kr/learn/courses/30/lessons/82612)
 * Hint  :
 */
public class LV1_부족한금액계산하기 {
    public long solution(int price, int money, int count) {
        long answer = 0;
        long sum = 0;
        for (int i = 1; i <= count; i++) {
            sum += (price * i);
        }
        if (money >= sum) return 0;
        return sum - money;

    }
}
