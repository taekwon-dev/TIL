package com.til.algorithm.algorithm.string;

/**
 *  aaabbc = a3b2c1
 */
public class CompressionString {

    public static void main(String[] args) {
        System.out.println(compressString("aaaaabbbbcccdde"));
        System.out.println("abcde");
    }

    private static String compressString(String str) {
        String newStr = compress(str);
        return str.length() < newStr.length() ? str : newStr;
    }

    private static String compress(String str) {
        int count = 0;
        StringBuilder sb = new StringBuilder(getTotal(str));
        for (int i = 0; i < str.length(); i++) {
            count++;
            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                sb.append(str.charAt(i));
                sb.append(count);
                count = 0;
            }
        }
        return sb.toString();
    }

    private static int getTotal(String str) {
        int count = 0;
        int total = 0;
        for (int i = 0; i < str.length(); i++) {
            count++;
            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                total += 1 + String.valueOf(count).length();
                count = 0;
            }
        }
        return total;
    }
}
