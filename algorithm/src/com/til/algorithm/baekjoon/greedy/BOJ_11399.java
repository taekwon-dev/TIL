package com.til.algorithm.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *  ATM
 *
 *  인하은행에는 ATM이 1대밖에 없다. 지금 이 ATM앞에 N명의 사람들이 줄을 서있다. N(1 ≤ N ≤ 1,000)
 *  사람은 1번부터 N번까지 번호가 매겨져 있으며,
 *  i번 사람이 돈을 인출하는데 걸리는 시간은 Pi분이다. (1 ≤ Pi ≤ 1,000)
 *
 *  사람들이 줄을 서는 순서에 따라서, 돈을 인출하는데 필요한 시간의 합이 달라지게 된다*
 *  각 사람이 돈을 인출하는데 필요한 시간의 합의 최솟값 구하기
 *
 *  P1 - 3 -> +3 = 3
 *  P2 - 1 -> +3 | +1 = 4 (3 + 1)
 *  P3 - 4 -> +3 +1 | +4 = 8 (4 + 4)
 *  P4 - 3 -> +3 +1 +4 | +3 = 11 (8 + 3)
 *  P5 - 2 -> +3 +1 +4 +3 | +2 = 13 (11 + 2)
 *
 *  위와 같은 순서로 배치 했을 때 모든 사람이 인출하기까지 걸린 시간 = 39
 *  위에서 모든 사람이 인출하는데 걸리는 시간이 오래 걸리게 하는 요인 -> 대기 시간
 *  따라서, 대기 시간을 줄이기 위해서는 CPU 스케줄링에서 SJF 개념과 같이 짧은 시간이 걸리는 사람을
 *  앞 순서로 배치하는 것이 중요!
 *
 *  따라서 현재 각 인덱스 별로 인출하는데 걸리는 시간이 들어가 있으므로,
 *  오름차순으로 배치하고, 인출하는데 걸리는 시간을 계산하면 된다.
 *
 * 1
 * 2
 * 3
 *
 * 1          = 1
 * 1 + 2      = 3
 * 1 + 2 + 3  = 6
 * --------------
 *              10
 *
 * wait 1
 * sum  1
 *
 * wait 3
 * sum  4
 *
 * wait 6
 * sum  10
 */
public class BOJ_11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] time = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            time[i] = Integer.parseInt(st.nextToken());
        }
        // 짧은 시간이 소요되는 사람을 앞 순서에 배치하기 위해서
        // 오름차순 정렬 적용
        Arrays.sort(time);
        int wait = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            wait += time[i];
            sum += wait;
        }
        System.out.println(sum);
    }
}


