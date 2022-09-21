package com.til.algorithm.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 알바생 강호
 * <p>
 * 손님을 8시가 될 때 까지, 문앞에 줄 세워 놓는다. 그리고 8시가 되는 순간 손님들은 모두 입구에서 커피를 하나씩 받고, 자리로 간다
 * <p>
 * 손님들은 입구에 들어갈 때, 강호에게 팁을 준다.
 * 손님들은 자기가 커피를 몇 번째 받는지에 따라 팁을 다른 액수로 강호에게 준다.
 * 각 손님은 강호에게 원래 주려고 생각했던 돈 - (받은 등수 - 1) 만큼의 팁을 강호에게 준다.
 * 만약, 위의 식으로 나온 값이 음수라면, 강호는 팁을 받을 수 없다.
 * <p>
 * 손님의 순서를 적절히 바꿨을 때, 강호가 받을 수 잇는 팁의 최댓값
 * <p>
 * N = 스타벅스 앞에 서 있는 사람의 수
 * N은 100,000보다 작거나 같은 자연수이다
 * <p>
 * 팀은 100,000보다 작거나 같은 자연수
 * <p>
 * 예) N = 4
 * (순서 - 원래 주려고 했던 팁)
 * 1등 - 3
 * 2등 - 3
 * 3등 - 3
 * 4등 - 3
 * <p>
 * 3 - (1-1) = 3
 * 3 - (2-1) = 2
 * 3 - (3-1) = 1
 * 3 - (4-1) = 0
 * <p>
 * 총 6을 팁으로 받는다.
 * <p>
 * 각 순서별로 모두 주려고 했던 팁이 같아서 순서를 조정해도 최댓값은 동일하다.
 * <p>
 * 핵심은 원래 주려고 했던 팁이 큰 사람이 앞에 위치해야 하는 지 뒤에 위치해야 하는지를 아는 것!
 * <p>
 * 예2) N = 3
 * <p>
 * 1등 - 1  ->  1 - (1-1) = 1
 * 2등 - 2  ->  2 - (2-1) = 1
 * 3등 - 3  ->  3 - (3-1) = 1
 * <p>
 * 총 3
 * <p>
 * 순서 재조정
 * <p>
 * 1등 -> 3 -> 3 - (1-1) = 3
 * 2등 -> 2 -> 2 - (2-1) = 1
 * 3등 -> 1 -> 1 - (3-1) = -1
 * <p>
 * 총 4
 * <p>
 * 순서가 뒤로 갈 수록 원래 내려고 했던 팁에서 마이너스되는 돈이 커진다.
 * 따라서 원래 내려고 했던 금액이 큰 순서대로 배치를 했을 때 가장 큰 팁을 얻을 수 있다.
 * -> 내림차순
 * <p>
 * Arrays.sort(arr, Comparator.reverseOrder());
 */
public class BOJ_1758 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] tips = new Integer[n];
        for (int i = 0; i < n; i++) {
            tips[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(tips, Comparator.reverseOrder());
        long tip = 0;
        for (int i = 0; i < n; i++) {
            if (tips[i] - i <= 0) {
                break;
            }
            tip += tips[i] - i;
        }
        System.out.println(tip);
    }
}
