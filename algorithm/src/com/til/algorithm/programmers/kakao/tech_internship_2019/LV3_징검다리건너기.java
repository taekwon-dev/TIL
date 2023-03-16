package com.til.algorithm.programmers.kakao.tech_internship_2019;

/**
 *  Binary Search 힌트 찾기 (주어진 범위에서 최소, 최대 범위를 정의할 수 있는 경우)
 */
public class LV3_징검다리건너기 {

    public int solution(int[] stones, int k) {
        int answer = 0;
        int min = 1;
        int max = 200_000_000;

        while (min <= max) {
            int mid = (min + max) / 2;
            if (isCrossable(stones, k, mid)) {
                min = mid + 1;
                answer = mid;
            } else {
                max = mid - 1;
            }
        }
        return answer;
    }

    private boolean isCrossable(int[] stones, int k, int mid) {
        int count = 0;
        for (int stone : stones) {
            if (stone < mid) {
                count++;
                if (count >= k) {
                    return false;
                }
            } else {
                count = 0;
            }
        }
        return true;
    }
}
