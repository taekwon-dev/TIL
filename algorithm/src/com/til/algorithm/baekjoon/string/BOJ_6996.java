package com.til.algorithm.baekjoon.string;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_6996 {

    private static boolean[] alphabet;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            String A = st.nextToken();
            String B = st.nextToken();
            if (isAnagram(A, B)) {
                bw.write(A + " & " + B + " are anagrams." + "\n");
                continue;
            }
            bw.write(A + " & " + B + " are NOT anagrams." + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static boolean isAnagram(String A, String B) {
        if (A.length() != B.length()) {
            return false;
        }
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();

        Arrays.sort(a);
        Arrays.sort(b);

        for (int i = 0; i < A.length(); i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }
}