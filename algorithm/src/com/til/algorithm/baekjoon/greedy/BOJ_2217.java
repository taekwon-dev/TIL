package com.til.algorithm.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

/**
 *  로프
 *
 *  N(1 ≤ N ≤ 100,000)개의 로프가 있다
 *
 *  이 로프를 이용하여 이런 저런 물체를 들어올릴 수 있다.
 *  각각의 로프는 그 굵기나 길이가 다르기 때문에
 *  들 수 있는 물체의 중량이 서로 다를 수도 있다.
 *
 *  하지만 여러 개의 로프를 병렬로 연결하면 각각의 로프에 걸리는 중량을 나눌 수 있다.
 *  k개의 로프를 사용하여 중량이 w인 물체를 들어올릴 때,
 *  각각의 로프에는 모두 고르게 w/k 만큼의 중량이 걸리게 된다.
 *
 *  이 로프들을 이용하여 들어올릴 수 있는 물체의 최대 중량을 구해내는 프로그램을 작성하시오.
 *  모든 로프를 사용해야 할 필요는 없으며, 임의로 몇 개의 로프를 골라서 사용해도 된다.
 *  -> ❗️ 핵심 조건
 *
 *
 *  최대 중량이 주어진다. 이 값은 10,000을 넘지 않는 자연수
 *
 *  로프 개수 -> 각 로프 별로 들 수 있는 무게의 값
 *
 *  각 로프가 처리할 무게는 -> W / N 이다. (= 각 무게를 로프 개수만큼 나눠서 균등 분배)
 *
 *
 *
 *  " 특정 로프를 사용할 경우, 해당 로프보다 무게가 큰 로프를 모두 이용하는 것이 이득이다 "
 *  15 -> 15
 *  10, 15 -> 20
 *  .
 *  .
 *  .
 *
 *  예를 들어 4개의 로프가 있다면,
 *  [20, 17, 15, 10] 으로 정렬되어 있다고 전제 N = 3 일 때 MAX 값이 나온다.
 *  n = 1 일때 20 * 1 = 20 (20)
 *  n = 2 일때 17 * 2 = 34 (20, 17)
 *  n = 3 일때 15 * 3 = 45 (20, 17, 15) -> MAX
 *  n = 4 일때 10 * 4 = 40 (20 17 15 10)
 *
 *  완전탐색
 */
public class BOJ_2217 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] ropes = new int[n];
        for (int i = 0; i < n; i++) {
            ropes[i] = Integer.parseInt(br.readLine());
        }
        // 오름 차순 정렬
        // 10, 15, 17, 20
        Arrays.sort(ropes);
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            // 10 (i = 0) 을 선택하면, 10 보다 큰 나머지 3개를 모두 사용해야 하고 결과적으로 네 개 모두를 사용하므로
            // 최소 무게 * 4
            max = Math.max(max, ropes[i] * (n - i));
        }
        System.out.println(max);
    }
}
