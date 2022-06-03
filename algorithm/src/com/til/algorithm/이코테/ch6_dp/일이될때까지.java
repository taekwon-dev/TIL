package com.til.algorithm.이코테.dp;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Youn on 2022/05/17.
 * Title : 1이 될 때까지 (https://youtu.be/2zjoKjt97vQ?list=PLRx0vPvlEmdAghTr5mXQxGpHjWqSz0dgC&t=675)
 * Hint  : N을 최대한 많이 나누기 (2 이상의 수로 나누는 작업이 1을 빼는 작업보다 수를 훨씬 많이 줄일 수 있다)
 *         K가 2 이상이기만 하면, K로 나누는 것이 1을 빼는 것보다 항상 빠르게 N을 훨씬 많이 줄일 수 있다)
 */
public class 일이될때까지 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int count = 0;

        while (true) {
            int target = (n / k) * k;
            count += (n - target);
            if (n < k) {
                break;
            }
            count++;
            n /= k;
        }
        // 예를 들어, n = 4인 경우 (4 -> 3 -> 2 -> 1) 총 3번의 -1 연산이 필요하므로 n - 1을 더한다.
        count += (n - 1);
        System.out.println(count);
    }
}
