package com.til.algorithm.programmers.kit;

import java.util.HashSet;

public class LV2_연속부분수열합의개수 {

    public int solution(int[] elements) {
        HashSet<Integer> set = new HashSet<>();

        for (int size = 1; size <= elements.length; size++) {
            for (int i = 0; i < elements.length; i++) {
                int pSum = 0;
                for (int j = i; j < i + size; j++) {
                    pSum += elements[j % elements.length];
                }
                set.add(pSum);
            }
        }
        return set.size();
    }
}