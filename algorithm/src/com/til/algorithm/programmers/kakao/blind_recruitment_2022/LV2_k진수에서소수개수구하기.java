package com.til.algorithm.programmers.kakao.blind_recruitment_2022;

public class LV2_k진수에서소수개수구하기 {
    public int solution(int n, int k) {
        int answer = 0;
        String knary = convertKnary(n, k);
        int j = 0;
        for (int i = 0; i < knary.length() - 1; i = j) {
            for (j = i + 1; j < knary.length() && knary.charAt(j) != '0'; j++);
            if (isPrime(Long.parseLong(knary.substring(i, j)))) {
                answer++;
            }
        }
        return answer;
    }

    private String convertKnary(int n, int k) {
        StringBuilder result = new StringBuilder();

        while (n > 0) {
            result.append(n % k);
            n /= k;
        }
        return result.reverse().toString();
    }

    private boolean isPrime(long num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
