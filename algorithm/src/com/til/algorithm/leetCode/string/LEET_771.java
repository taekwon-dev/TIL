package com.til.algorithm.leetCode.string;

public class LEET_771 {

    public int numJewelsInStones(String jewels, String stones) {
        int answer = 0;
        for (int i = 0; i < jewels.length(); i++) {
            for (int j = 0; j < stones.length(); j++) {
                if (jewels.charAt(i) == stones.charAt(j)) {
                    answer++;
                }
            }
        }
        return answer;
    }
}