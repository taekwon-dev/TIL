package com.til.algorithm.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 2 + 1 세일
 * <p>
 * 과일우유, 드링킹요구르트 등의 유제품을 '2+1 세일'하는 행사
 * KSG 편의점에서 유제품 3개를 한 번에 산다면
 * 그중에서 가장 싼 것은 무료로 지불하고 나머지 두 개의 제품 가격만 지불하면 됩니다.
 * 한 번에 3개의 유제품을 사지 않는다면 할인 없이 정가를 지불해야 합니다.
 * <p>
 * N팩의 유제품을 구입하려고 합니다. 재현이를 도와 최소비용으로 유제품을 구입
 * <p>
 * N개 -> 3개 단위로 묶이는지
 * <p>
 * 예를 들어서
 * N = 3 -> 3개 중 가장 적은 금액 제외한 나머지 두 개에 대한 금액만 지불
 * N = 4 ~ 5 -> 한 팩을 어떻게 구성할 지를 경정 (나머지 두 개는 정가 지불)
 * N = 6 -> 팩을 어떻게 구성할 지에 따라서 달라지겠다.
 * <p>
 * 패턴
 * <p>
 * N = 3
 * 1, 2, 3 -> 2 + 3 = 5원
 * <p>
 * N = 4
 * 1, 2, 3, 4
 * <p>
 * 4C3 = 4 -> 팩을 구성하는 방법
 * <p>
 * 1 2 3 : 5 + 4 = 9
 * 1 2 4 : 6 + 3 = 9
 * 1 3 4 : 7 + 2 = 9
 * 2 3 4 : 7 + 1 = 8 -> pick -> 가장 적은 금액을 따로 구매 = 큰 금액을 무료로 구매할 수 있을 수록 최소 금액으로 구매가능
 * <p>
 * 1, 2, 3, 4, 5
 * <p>
 * 3 4 5 -> 한 팩으로 구성하고 나머지 가장 저렴한 것을 정가를 주고 구매하는 것이 최소 비용
 * <p>
 * 두 팩 이상 나오는 경우 ?
 * <p>
 * 1, 2, 3, 4, 5, 6
 * <p>
 * 1 2 3 / 4 5 6 -> 5 + 11 = 16
 * 1 2 6 / 3 4 5 -> 8 + 9 =  17
 * <p>
 * 4 5 5 5 5 6
 * <p>
 * 4 5 5 / 5 5 6 -> 10 + 11 = 21
 * 5 5 5 / 4 5 6 -> 10 + 11 = 21
 * <p>
 * 3, 6, 9 ...
 * <p>
 * 3의 배수 사이에 있는 값
 * <p>
 * 4 5
 * 7 8
 * 10 11
 * 13 14
 * 16 17
 * .
 * .
 * .
 * <p>
 * N이 최대 100,000
 * 가격 최대 100,000
 */
public class BOJ_11508 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] costs = new Integer[n];
        for (int i = 0; i < n; i++) {
            costs[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(costs, Comparator.reverseOrder());
        int cost = 0;
        for (int i = 0; i < n; i++) {
            if ((i + 1) % 3 == 0) continue;
            cost += costs[i];
        }
        System.out.println(cost);
    }
}
