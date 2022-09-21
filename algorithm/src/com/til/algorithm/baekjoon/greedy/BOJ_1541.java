package com.til.algorithm.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 잃어버린 괄호
 * <p>
 * 세준이는 양수와 +, -, 그리고 괄호를 가지고 식을 만들었다.
 * 그리고 나서 세준이는 괄호를 모두 지웠다.
 * <p>
 * 그리고 나서 세준이는 괄호를 적절히 쳐서 이 식의 값을 최소로 만들려고 한다.
 * 괄호를 적절히 쳐서 이 식의 값을 최소로 만드는 프로그램을 작성하시오.
 * <p>
 * 5자리보다 많이 연속되는 숫자는 없다 -> 최대 다섯자리 수
 * 수는 0으로 시작할 수 있다 -> 숫자 앞의 0은 무시한다.
 * <p>
 * <p>
 * 55 - 50 + 40 -> 55 - (50 + 40) = -35
 * <p>
 * 생략된 괄호를 친다는 것은 먼저 계산할 것을 결정한다는 의미
 * <p>
 * 최소 값을 만들기 위해서는
 * + -> 작은 수를 더하고
 * - -> 큰 수를 빼야 한다. -> 덧셈으로 이루어진 부분을 먼저 찾아서 빼준다 (= 큰 수를 만드는 과정)
 * <p>
 * 10 + 20 + 30 + 40 -> 모두 + 만 있는 경우 괄호 추가로 연산 순서를 바꾸는 것이 무의미
 * <p>
 * 빼기가 있는 경우, 괄호 안에 먼저 처리된 결과 값이 - 또는 + 에 따라서 값이 반전되는 특징
 * 큰 수를 빼야 하는 것은 동일
 * 10 - 20 - 30 - 40 = -80
 * 10 - (20 - 30) - 40 = -20
 * 10 - 20 - (30 - 40) = 0
 * <p>
 * 연산 인접한 수끼리 하는 것
 * <p>
 * 55 - 50 + 40
 * <p>
 * (1) 55 - 50
 * (2) 50 + 40
 * <p>
 * 1 - 2 + 3 - 4
 * <p>
 * (1) 1 - 2 +
 * (2) 2 + 3 -
 * (3) 3 - 4
 * <p>
 * 마지막 순서는 앞의 연산 결과에 영향을 받기만 한다.
 * <p>
 * ---
 * <p>
 * https://st-lab.tistory.com/148
 * <p>
 * - -> 큰 수를 빼야 한다. -> 덧셈으로 이루어진 부분을 먼저 찾아서 빼준다 (= 큰 수를 만드는 과정)
 * - 를 기준으로 분리를 하고, 덧셈 처리를 다 한 뒤 분리된 영역을 모두 계산한다
 */
public class BOJ_1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = Integer.MAX_VALUE;
        String[] str = br.readLine().split("-");

        for (int i = 0; i < str.length; i++) {
            int tmp = 0;
            String[] plus = str[i].split("\\+");

            for (int j = 0; j < plus.length; j++) {
                tmp += Integer.parseInt(plus[j]);
            }

            if (sum == Integer.MAX_VALUE) {
                sum = tmp;
            } else {
                sum -= tmp;
            }
        }
        System.out.println(sum);
    }
}
