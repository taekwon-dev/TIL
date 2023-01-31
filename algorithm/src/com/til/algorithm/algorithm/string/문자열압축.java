package com.til.algorithm.algorithm.string;

/**
 *  인접한 문자(= 한 문자 단위) 압축
 *  aabbcc = 2a2b2c
 *  aabbcccc = 2a2b4c
 *  aabbc = 2a2bc
 */
public class 문자열압축 {

    public static void main(String[] args) {
        System.out.println(compressString("aabbcc"));   // 2a2b2c
        System.out.println(compressString("aabbcccc")); // 2a2b4c
        System.out.println(compressString("aabbc"));    // 2a2bc
    }

    private static String compressString(String str) {
        String newStr = compress(str);
        return str.length() < newStr.length() ? str : newStr;
    }

    private static String compress(String str) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            count++;
            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                if (count != 1) {
                    sb.append(count);
                }
                sb.append(str.charAt(i));
                count = 0;
            }
        }
        return sb.toString();
    }
}
