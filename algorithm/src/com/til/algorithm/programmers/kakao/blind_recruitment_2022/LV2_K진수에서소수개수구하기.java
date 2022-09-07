package com.til.algorithm.programmers.kakao.blind_recruitment_2022;

public class LV2_K진수에서소수개수구하기 {
    public int solution(int n, int k) {
        int answer = 0;

        String convertedNum = convertNum(n, k);
        String[] target = convertedNum.split("0");

        for (String str : target) {
            if (str.equals("")) continue;
            if (isPrime(Long.parseLong(str))) answer++;
        }

        return answer;
    }

    private String convertNum(int n, int k) {
        if (k == 10) return String.valueOf(n);

        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            sb.append(n % k);
            n /= k;
        }
        return sb.reverse().toString();
    }

    private boolean isPrime(long num) {
        if (num == 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
