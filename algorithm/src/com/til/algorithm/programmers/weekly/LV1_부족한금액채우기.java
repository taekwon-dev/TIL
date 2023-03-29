package com.til.algorithm.programmers.weekly;

public class LV1_부족한금액채우기 {

    public long solution(int price, int money, int count) {
        long answer = 0;
        long total_money = 0;
        for(int i = 1; i <= count; i++){
            total_money += price * i;
        }
        answer = money - total_money;
        if (total_money < money) {
            answer = 0;
        }
        else {
            answer = Math.abs(answer);
        }
        return answer;
    }
}