package com.til.algorithm.programmers.kakao.blind_recruitment_2022;

public class LV2_K진수에서소수개수구하기 {

    public int solution(int n, int k) {
        int answer = 0;
        String convertedNumber = convertNumToStr(n, k);
        String[] target = convertedNumber.split("0");

        for (String s : target) {
            if (s.equals("")) {
                continue;
            }
            if (isPrimeNumber(Long.parseLong(s))) {
                answer++;
            }
        }
        return answer;
    }

    private String convertNumToStr(int n, int k) {
        if (k == 10) {
            return String.valueOf(n);
        }
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n % k);
            n /= k;
        }
        return sb.toString();
    }

    private boolean isPrimeNumber(long number) {
        if (number == 1) {
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