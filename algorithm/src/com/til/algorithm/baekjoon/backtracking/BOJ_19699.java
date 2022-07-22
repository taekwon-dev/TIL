package com.til.algorithm.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 *  소-난다!
 *
 *  농장에는 N마리의 소가 있다.
 *  농부 존은 소들의 몸무게의 합이 소수(prime)가 되도록 M마리의 소를 선별할 계획이다.
 *  농부 존의 계획에 맞게 소를 선별했을 때 나올 수 있는 몸무게의 합을 모두 출력하시오. (오름차순)
 *  -> 리스트에 넣고, 정렬 후 출력
 *  -> 단, `몸무게 의 합` 을 출력하는 것은 조합 결과 몸무게가 같은 경우 중복된 값이 출력되는 것이므로 중복 제거 과정이 필요!
 *
 *  중복제거 -> Set 자료구조를 사용할 수 도 있고, 리스트에서 add 할 때 마다 중복 검사 로직을 통과시키는 방법이 있는데, Add 할 때는 이 로직이 적용된 Set 을 사용하는 것이 좋아보임
 *
 *
 *  N 마리의 소 -> M 마리를 선별
 *  단, M 마리의 소들의 몸무게 합이 Prime (소수)
 *
 *  1) N 마리 중 M 마리를 선별
 *  2) M 마리를 선별 했을 때 M 마리 몸무게 합이 소수인 경우 출력
 *
 *  #소수 판별
 */
public class BOJ_19699 {
    static int n, m;
    static int[] weight;
    static Set<Integer> selected;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        weight = new int[n];
        visited = new boolean[n];
        selected = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            weight[i] = Integer.parseInt(st.nextToken());
        }

        backtracking(0, 0);
        ArrayList<Integer> answer = new ArrayList<>(selected);
        Collections.sort(answer);
        if (answer.size() == 0) {
            System.out.println(-1);
        } else {
            for (int i = 0; i < answer.size(); i++) {
                System.out.print(answer.get(i) + " ");
            }
        }
    }
    private static void backtracking(int depth, int sum) {
        if (depth == m) {
            // 소수 판별 후
            // 소수인 경우 선별 리스트 추가
            if (prime(sum)) selected.add(sum);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                backtracking(depth + 1, sum + weight[i]);
                visited[i] = false;
            }
        }
    }

    private static boolean prime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
