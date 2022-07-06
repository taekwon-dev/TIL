package com.til.algorithm.programmers.kit.sort;

import java.util.Arrays;

public class LV2_H_INDEX {

    /**
     *  정렬을 해야된다는 생각
     */
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);

        for (int i = 0; i < citations.length; i++) {
            int h = citations.length - i;

            if (citations[i] >= h) {
                answer = h;
                break;
            }
        }
        return answer;
    }

}
