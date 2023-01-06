package com.til.algorithm.algorithm.string;

public class KMP {

    public static void main(String[] args) {
        String pattern = "abacaaba";
        int[] table = makeTable(pattern);

        for (int i = 0; i < table.length; i++) {
            System.out.print(table[i] + " ");
        }
    }

    /**
     *  접두사, 접미사 일치 최대 길이 테이블
     */
    private static int[] makeTable(String pattern) {
        int n = pattern.length();
        int[] table = new int[n];

        int j = 0;
        for (int i = 1; i < n; i++) {
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = table[j - 1];
            }
            if (pattern.charAt(i) == pattern.charAt(j)) {
                table[i] = ++j;
            }
        }
        return table;
    }

    /**
     *  탐색 과정
     *  https://www.youtube.com/watch?v=yWWbLrV4PZ8
     *  https://bowbowbow.tistory.com/6
     *  https://loosie.tistory.com/192
     */
}
