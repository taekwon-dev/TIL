package com.til.algorithm.baekjoon.string;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_6996 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            String A = st.nextToken();
            String B = st.nextToken();

            if (A.equals(B)) {
                bw.write(A + " & " + B + " are anagrams." + "\n");
                continue;
            }
            if (A.length() != B.length()) {
                bw.write(A + " & " + B + " are NOT anagrams." + "\n");
                continue;
            }
            char[] a = A.toCharArray();
            char[] b = B.toCharArray();
            Arrays.sort(a);
            Arrays.sort(b);

            boolean isAnagram = true;
            for (int i = 0; i < a.length; i++) {
                if (a[i] != b[i]) {
                    bw.write(A + " & " + B + " are NOT anagrams." + "\n");
                    isAnagram = false;
                    break;
                }
            }
            if (isAnagram) {
                bw.write(A + " & " + B + " are anagrams." + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}