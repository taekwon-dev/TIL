package com.til.algorithm.baekjoon.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 피로도
 * <p>
 * 작업 (시간) 단위 = 1시간
 * <p>
 * 1시간 작업(일) = 피로도 + A / 처리량 + B
 * 1시간 휴식 = 피로도 - C  (If 피로도 < 0, 피로도 = 0)
 * <p>
 * 피로도 (M) 을 넘지 조건에서 최대한의 일을 하는 경우
 * 시작 피로도 : 0
 * 24시간 동안 계산
 * <p>
 * 1. 현재 피로도 + A <= M 일 때 까지 일한다.
 * 2. 현재 피로도 + A > M 인 경우, 1시간 단위로 휴식한다.
 * <p>
 * 1, 2 과정을 반복
 * 24시간 지난 이후 처리한 일의 양을 출력
 */
public class BOJ_22864 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int currM = 0;
        int answer = 0;
        for (int i = 1; i <= 24; i++) {
            if (currM + A <= M) {
                currM += A;
                answer += B;
            } else {
                // (If 피로도 < 0, 피로도 = 0)
                if (currM - C < 0) currM = 0;
                else currM -= C;
            }
        }
        System.out.println(answer);
    }
}
