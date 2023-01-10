package com.til.algorithm.algorithm.math;

/**
 *  에라토스테네스의 체
 *
 *  1. 2부터 소수를 구하고자 하는 구간의 모든 수를 나열한다.
 *  2. 2는 소수이므로, 자기 자신을 제외한 2의 배수를 모두 지운다.
 *  3. 남아있는 수 가운데 3은 소수이므로 3을 제외한 남은 3의 배수를 모두 지운다.
 *  4. 남아있는 수 가운데 5는 소수이므로 5를 제외한 남은 5의 배수를 모두 지운다.
 *  5. 남아있는 수 가운데 7은 소수이므로 7을 제외한 남은 7의 배수를 모두 지운다.
 *  6. 위 과정을 반복하면 구하는 구간의 모든 소수가 남는다.
 */
public class Eratos {

    public static void main(String[] args) {
        int N = 120;
        boolean[] prime = new boolean[N + 1];

        prime[0] = true;
        prime[1] = true;
        for (int i = 2; i * i <= N; i++) {
            if (!prime[i]) {
                for (int j = i * i; j <= N; j += i) {
                    prime[j] = true;
                }
            }
        }
        for (int i = 2; i <= N; i++) {
            if (!prime[i]) {
                System.out.print(i + " ");
            }
        }
    }
}