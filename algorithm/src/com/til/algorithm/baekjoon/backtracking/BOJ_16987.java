package com.til.algorithm.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  계란으로 계란치기
 *
 *  각 계란에는 내구도와 무게가 정해져있다.
 *
 *  계란으로 계란을 치게 되면 각 계란의 내구도는 상대 계란의 무게만큼 깎이게 된다.
 *  내구도가 0 이하가 되는 순간 계란은 깨지게 된다.
 *
 *  일렬로 놓여있는 계란에 대해 왼쪽부터 차례로 들어서 한 번씩만 다른 계란을 쳐 최대한 많은 계란을 깨는 문제
 *
 *  1. 가장 왼쪽의 계란을 든다.
 *  2. 손에 들고 있는 계란으로 깨지지 않은 다른 계란 중에서 하나를 친다. 단, 손에 든 계란이 깨졌거나 깨지지 않은 다른 계란이 없으면 치지 않고 넘어간다. 이후 손에 든 계란을 원래 자리에 내려놓고 3번 과정을 진행한다.
 *  3. 가장 최근에 든 계란의 한 칸 오른쪽 계란을 손에 들고 2번 과정을 다시 진행한다. 단, 가장 최근에 든 계란이 가장 오른쪽에 위치한 계란일 경우 계란을 치는 과정을 종료한다.
 *
 *  일렬로 놓인 계란들의 내구도와 무게가 차례대로 주어졌을 때 최대 몇 개의 계란을 깰 수 있는지 알아맞춰보자.
 *
 *  계란 수 N(1 ≤ N ≤ 8)
 *
 *  각 계란 별로 위 과정을 진행하는데,
 *  진행 과정에서 시작 위치의 계란이 깨진 경우도 있을 수 있다.
 *  하지만 본질은 모든 계란을 시작 위치에 두고 깰 수 있는 계란의 개수를 카운팅하는 것.
 *
 *
 *
 *
 */
public class BOJ_16987 {
    static class Egg {
        int s;
        int w;

        public Egg(int s, int w) {
            this.s = s;
            this.w = w;
        }
    }
    static int n, answer;
    static Egg[] eggs;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        eggs = new Egg[n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            eggs[i] = new Egg(s, w);
        }
        backtracking(0);
        System.out.println(answer);
    }

    private static void backtracking(int index) {
        if (index == n) {
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if (eggs[i].s <= 0) cnt++;
            }
            answer = Math.max(answer, cnt);
            return;
        }
        // 현재 고른 계란이 깨져 있다면 다음 계란으로 넘어간다.
        if (eggs[index].s <= 0) backtracking(index + 1);
        else {
            // 뒤에 깰 계란이 있는 지 여부
            boolean broken = false;
            // 가장 왼쪽의 계란을 든다. 매번 0으로 고정
            for (int i = 0; i < n; i++) {
                if (i == index || eggs[i].s <= 0) continue;
                // 위 조건문을 통과한 경우 꺠지지 않은 계란 = 선택한 계란으로 히트할 대상
                broken = true;
                eggs[i].s -= eggs[index].w;
                eggs[index].s -= eggs[i].w;
                backtracking(index + 1);
                eggs[i].s += eggs[index].w;
                eggs[index].s += eggs[i].w;
            }
            // 깰 계란이 없는 경우, 다음 계란으로 넘어간다.
            if (!broken) {
                backtracking(index + 1);
            }
        }
    }
}
