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
            /**
             *  - 기준이 되는 문자 다음 포인터가 문자열 길이 이상인 경우
             *  - 앞 뒤가 서로 다른 문자인 경우
             *
             *  -> 해당 문자에 대한 압축 결과를 입력
             */
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
