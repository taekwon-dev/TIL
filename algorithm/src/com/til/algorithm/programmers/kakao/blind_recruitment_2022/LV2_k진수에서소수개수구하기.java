package com.til.algorithm.programmers.kakao.blind_recruitment_2022;

public class LV2_k진수에서소수개수구하기 {

    public int solution(int n, int k) {
        int answer = 0;
        String knary = convertKnary(n, k);

        int j = 0;
        for (int i = 0; i < knary.length() - 1; i = j) {
            for (j = i + 1; j < knary.length() && knary.charAt(j) !=  '0'; j++);
            if (isPrime(Long.parseLong(knary.substring(i, j)))) {
                answer++;
            }
        }
        return answer;
    }

    private String convertKnary(int n, int k) {
        StringBuilder knary = new StringBuilder();
        while (n > 0) {
            knary.append(n % k);
            n /= k;
        }
        return knary.reverse().toString();
    }

    private boolean isPrime(long number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
