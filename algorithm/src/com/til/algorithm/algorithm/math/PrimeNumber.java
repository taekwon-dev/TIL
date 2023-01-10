package com.til.algorithm.algorithm.math;

import java.util.Scanner;

/**
 *  Prime Number : 1보다 큰 자연수 중 1과 자기 자신만을 약수로 가지는 수
 */
public class PrimeNumber {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        isPrime(in.nextInt());
    }

    private static void isPrime(int number) {
        if (number < 2) {
            System.out.println("소수가 아닙니다.");
            return;
        }
        if (number == 2) {
            System.out.println("소수입니다.");
            return;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                System.out.println("소수가 아닙니다.");
                return;
            }
        }
        System.out.println("소수입니다.");
    }
}
