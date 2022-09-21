package com.til.algorithm.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 서강근육맨
 * <p>
 * 로니 콜먼 동영상을 보고 보디빌더가 되기로 결심한 향빈이는 PT 상담을 받으러 서강헬스클럽에 갔다.
 * 향빈이가 서강헬스클럽을 선택한 이유는 PT를 받을 때 사용하는 운동기구를 회원이 선택할 수 있다는 점 때문이다.
 * 하지만, 서강헬스클럽은 항상 사람이 많아서 PT를 한 번 받을 때 운동기구를 최대 두 개까지만 선택할 수 있다.
 * <p>
 * 헬스장에 있는 N개의 운동기구를 한 번씩 사용해보고 싶은 향빈이는 PT를 받을 때마다 이전에 사용하지 않았던 운동기구를 선택하기로 계획을 세웠다.
 * 그리고 비용을 절약하기 위해 PT를 받을 때 운동기구를 되도록이면 두 개를 사용하기로 했다.
 * 예를 들어, 헬스장에 총 10개의 운동기구가 있을 경우 PT를 5번 받으면 모든 기구를 다 사용할 수 있다.
 * 9개의 운동기구가 있는 경우에도 PT를 5번 받지만, 마지막 PT를 받을 때는 운동기구를 하나만 사용한다.
 * <p>
 * 하지만 향빈이는 운동기구를 선택하다가 큰 고민에 빠졌다.
 * 왜냐하면 운동기구마다 근손실이 일어나는 정도가 다르기 때문이다.
 * 어떤 운동기구는 자극이 잘 안 와서 근손실이 적게 일어나는데, 어떤 운동기구는 자극이 잘 와서 근손실이 많이 일어난다.
 * 근손실이 죽음보다 무서운 향빈이는 PT를 한 번 받을 때의 근손실 정도가 M을 넘지 않도록 하고 싶다.
 * 이때, M의 최솟값을 구해보자.
 * <p>
 * 참고로, 운동기구를 두 개 사용해서 PT를 받을 때의 근손실 정도는 두 운동기구의 근손실 정도의 합이다.
 * <p>
 * N 개의 운동 기구
 * 최대 두 개까지 이용 가능 (마지막 날 한 개만 있는 경우 운동기구는 하나만 선택)
 * 근손실 두 개 기구 사용한 경우, 두 기구 사용한 이후 근손실 합
 * <p>
 * 1 <= N <= 10,000
 * <p>
 * N 짝수
 * -> N / 2 동안 두 개 기구를 모두 사용
 * <p>
 * N 홀수
 * -> N / 2 동안 마지막 날을 제외하고 두 개 기구 모두 사용
 * <p>
 * 근손실이 큰 운동은 그날 몰아서 하면 불리
 * <p>
 * 예를 들어,
 * <p>
 * N = 5
 * 1, 2, 3, 4, 5 (기구 별 근손실)
 * <p>
 * 1 4 = 5
 * 2 3 = 5
 * 5   = 5
 * <p>
 * 4 5 = 9 -> 최소 근손실 초과
 * 3 4 = 7 -> 최소 근손실 초과
 * 1 5 = 6 -> 최소 근손실 초과
 * <p>
 * 2 5 6 8 9
 * <p>
 * 10
 * 11
 * 9
 * <p>
 * -> 11
 * <p>
 * 최댓값을 11 보다 작게 만들 수 있어? -> 핵심
 * <p>
 * 오름차순 정렬
 * <p>
 * 짝수 1 4 8 10
 * <p>
 * 1 4 = 5
 * 1 8 = 9
 * 1 10 = 11 (picked)
 * <p>
 * 4 8 = 12 (picked)
 * 4 10 = 14
 * 8 10 = 18
 * <p>
 * 홀수
 * <p>
 * 1 5 9 12 20
 * <p>
 * 1 + 12 = 13
 * 5 + 9 = 14
 * 20
 * <p>
 * 1 5 = 6
 * 1 9 = 10
 * 1 12 = 13
 * 1 20 = 21
 * <p>
 * 5 9  = 14
 * 5 12 = 17
 * 5 20 = 25
 * <p>
 * 9 12 = 21
 * 9 20 = 29
 * <p>
 * 12 20 = 32
 * <p>
 * N 이 짝수 / 홀수
 * <p>
 * 1) 짝수
 * ->, <- 으로 순차적으로 하나씩 더해가면서 최댓값 -> 답
 * <p>
 * 2) 홀수
 * ->, <- 인데, 마지막 수를 제외하고,
 * <p>
 * 그리고 최댓값을 구할 때는 마지막 값을 포함해서 결정
 */
public class BOJ_20300 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] loss = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            loss[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(loss);

        long max = loss[n - 1];
        // N = 짝수
        if (n % 2 == 0) {
            for (int i = 0; i < n / 2; i++) {
                max = Math.max(max, loss[i] + loss[n - 1 - i]);
            }
        } else {
            // N = 홀수
            for (int i = 0; i < n / 2; i++) {
                max = Math.max(max, loss[i] + loss[n - 2 - i]);
            }
        }
        System.out.println(max);
    }
}
