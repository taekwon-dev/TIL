package com.til.algorithm.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  주유소
 *
 *  어떤 나라에 N개의 도시가 있다. N(2 ≤ N ≤ 100,000)
 *
 *  제일 왼쪽의 도시에서 제일 오른쪽의 도시로 자동차를 이용하여 이동하려고 한다.
 *  인접한 두 도시 사이의 도로들은 서로 길이가 다를 수 있다
 *
 *  처음 출발할 때 자동차에는 기름이 없어서(기름 = 0) 주유소에서 기름을 넣고 출발하여야 한다.
 *  기름통의 크기는 무제한이어서 얼마든지 많은 기름을 넣을 수 있다.
 *  도로를 이용하여 이동할 때 1km마다 1리터의 기름을 사용한다.
 *
 *  각 도시에는 단 하나의 주유소가 있으며, 도시 마다 주유소의 리터당 가격은 다를 수 있다.
 *  가격의 단위는 원을 사용한다.
 *
 *  각 도시 (= 원) 안에 있는 수는 그 도시에 있는 주유소의 리터당 가격
 *  도로 위에 있는 수는 도로의 길이를 표현
 *
 *  5 -> (2) -> 2 -> (3) -> 4 -> (1) -> 1
 *
 *  총 거리 6
 *  리터당 가격이 5원인 곳에서 6 만큼 이동할 수 있도록 주유하면 = 30원
 *
 *  리터당 가격이 5원인 곳에서 2 만큼 이동할 수 있도록 주유하고 (10) +
 *  리터당 가격이 2원인 곳에서 3 만큼 이동할 수 있도록 주유하고 (6) +
 *  리터당 가격이 4원인 곳에서 1 만큼 이동할 수 있도록 주유하면 (4) = 20원
 *
 *
 *  제일 왼쪽 도시에서 제일 오른쪽 도시로 이동하는 최소의 비용
 *
 *  방문한 도시 순서가 매우 중요.
 *
 *  첫 번째 방문한 도시가 리터 당 가격이 적을 수록 미리 많은 양의 주유를 해놓고 진행하면 좋음
 *  반면 방문 도시가 리터 당 가격이 높으면 최소 해당 도시에서 인접한 도시 까지의 거리까지 필요한 주유을 해야 함.
 *
 *  " 리터 당 기름 값이 내림차순일 경우에 주유 "
 */
public class BOJ_13305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] dists = new long[n - 1];
        long[] costs = new long[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < dists.length; i++) {
            dists[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < costs.length; i++) {
            costs[i] = Integer.parseInt(st.nextToken());
        }

        long sum = 0;
        long min = costs[0];
        // N 개의 도시 -> N - 1 번 이동하면 가장 왼쪽에서 가장 오른쪽 도시로 이동 가능
        // 마지막 도시의 리터 당 가격 정보는 무시한다.
        for (int i = 0; i < n - 1; i++) {

            // 현재 방문 도시와 인접 도시 비교
            // 리터 당 가격이 내림차순인 경우에만 리터 당 가격 갱신
            if (costs[i] < min) {
                min = costs[i];
            }
            sum += min * dists[i];
        }
        System.out.println(sum);
    }
}
