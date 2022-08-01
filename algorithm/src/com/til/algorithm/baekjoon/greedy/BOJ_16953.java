package com.til.algorithm.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * A -> B A, B (1 ≤ A < B ≤ 10^9)
 *
 * 정수 A를 B로 바꾸려고 한다. 가능한 연산은 다음과 같은 두 가지이다.
 *
 * 2를 곱한다.
 * 1을 수의 가장 오른쪽에 추가한다.
 * A를 B로 바꾸는데 필요한 연산의 최솟값을 구해보자.
 *
 * A를 B로 바꾸는데 필요한 연산의 최솟값에 1을 더한 값을 출력한다. (매우 중요)
 * 만들 수 없는 경우에는 -1을 출력한다.(매우 중요)
 *
 * 예)
 * 2 -> 162
 *
 * 2 -> 4 -> 8 -> 81 -> 162
 * [5]
 *
 *
 * 예2)
 * 4 -> 42
 * [-1]
 *
 * 예3)
 * 100 -> 40021
 *
 * 100 -> 200 -> 2001 -> 4002 -> 40021
 * [5]
 *
 * 2를 곱한다 -> 짝수 단위로 올린다. (배수)
 * 1을 붙인다 -> 홀수로 만든다. 즉, 1이 붙어 있는 경우 1을 제외한 나머지 수는, 이전 작업 (= 2의 배수) 수 마지막 자리에 1을 붙인 것.
 *
 * 따라서,
 *
 * 2 -> 162 를 갈 때 역방향으로 찾아가야 함.
 *
 * 162 -> 81 (홀수 이므로, 8) -> 4 -> 2
 *
 * 1) 짝 / 홀 판단
 *  1-1) 짝수인 경우
 *       2로 나눈다.
 *  1-2) 홀수인 경우
 *       마지막 1을 버린다.
 *
 * 2) 1) 과정을 반복하다가, 타겟에 도달하지 못한 경우 -1
 *                     타겟에 도달한 경우 연산 횟수 + 1을 출력한다.
 *
 *  111 -> 1을 버리는 것을 어떻게 하는지가 관건
 *
 *  111 -> toString(), String.substring()
 *
 *  1,000,000,000
 */
public class BOJ_16953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());
        int answer = 1;

        while (b != a) {
            if (b < a) {
                answer = -1;
                break;
            }
            String strB = String.valueOf(b);
            // b = 93 -> 다음 스테이지로 이동할 수 없음 (정수 조건에 맞지 않음)
            if (strB.charAt(strB.length() - 1) != '1' && b % 2 != 0) {
                answer = -1;
                break;
            }

            if (b % 2 == 0) {
                b /= 2;
            } else {
                strB = strB.substring(0, strB.length() - 1);
                b = Long.parseLong(strB);
            }
            answer++;
        }
        System.out.println(answer);
    }
}
