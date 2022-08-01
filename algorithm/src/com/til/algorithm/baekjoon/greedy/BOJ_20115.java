package com.til.algorithm.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *  에너지 드링크
 *
 *  페인은 에너지 드링크를 좋아하는 회사원이다. 에너지 드링크는 카페인, 아르기닌, 타우린, 나이아신 등의 성분이 들어있어 피로 회복에 도움을 주는 에너지 보충 음료수이다.
 *  야근을 마치고 한밤중에 퇴근하니 벌써 새벽 1시. 하지만 주말은 아직 멀었고, 다음 날에도 정시에 출근해야 하는 페인은 오늘도 에너지 드링크를 찾는다.
 *
 *  반복되는 야근에 지친 나머지, 평소보다 더 많은 에너지와 피로 회복이 필요했던 페인은 집에 있던
 *  에너지 드링크들을 한 데 합쳐서, 하나의 에너지 드링크로 만들어 한번에 마시려 한다.
 *
 *  페인이 에너지 드링크들을 합치는 과정
 *  1. 임의의 서로 다른 두 에너지 드링크를 고른다. (A, B)
 *  2. 한쪽 에너지 드링크를 다른 쪽 에너지 드링크에 모두 붓는다. 단, 페인은 야근 후유증으로 인해 손이 떨려, 붓는 과정에서 원래 양의 절반을 바닥에 흘리게 된다. (A, B 중 선택한 음료수)
 *  3. 다 붓고 남은 빈 에너지 드링크는 버린다.
 *  4. 1~3 과정을 에너지 드링크가 하나만 남을 때까지 반복한다.
 *
 *  페인은 합쳐진 에너지 드링크의 양을 최대로 하려 한다
 *
 *  에너지 드링크의 수 N이 주어진다. (2 ≤ N ≤ 10^5)
 *
 *  하나로 합치는 과정에서 남은 한 쪽으로 옮기는 과정에서 1/2가 사라지는 구조.
 *  비율이므로, 원래 갖고 있는 양이 클 수록 많이 버려지므로, 한 쪽으로 옮기는 대상이 반드시 제일 작은 용량을 가져야
 *  최대값을 가질 수 있다.
 *
 *  예)
 *  N = 5
 *  3 2 10 9 6
 *  -> 오름차순 정렬
 *  2 3 6 9 10
 *
 *  1 + 1.5 + 3 + 4.5 + 10 = 20
 */
public class BOJ_20115 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        double max = arr[n - 1];
        for (int i = 0; i < n - 1; i++) {
            max += (double) arr[i] / 2;
        }
        System.out.println(max);
    }
}
