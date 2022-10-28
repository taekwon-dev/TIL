package com.til.algorithm.algorithm.string;

public class CompressionString {

    public static void main(String[] args) {
        System.out.println(compressString("aaabbc"));
        System.out.println(compressString("aaabbb"));
        System.out.println(compressString("aaabbbc"));
    }

    private static String compressString(String str) {
        String newStr = compress(str);
        return str.length() < newStr.length() ? str : newStr;
    }

    private static String compress(String str) {
        int count = 0;
        /**
         *     private void ensureCapacityInternal(int minimumCapacity) {
         *         // overflow-conscious code
         *         int oldCapacity = value.length >> coder;
         *         if (minimumCapacity - oldCapacity > 0) {
         *             value = Arrays.copyOf(value,
         *                     newCapacity(minimumCapacity) << coder);
         *         }
         *     }
         */
        StringBuilder sb = new StringBuilder(getTotal(str));
        for (int i = 0; i < str.length(); i++) {
            count++;
            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                sb.append(count);
                sb.append(str.charAt(i));
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
