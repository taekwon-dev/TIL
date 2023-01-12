package com.til.algorithm.baekjoon.string;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class BOJ_9933 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        String[] p = new String[N];
        Set<String> passwords = new HashSet<>();
        for (int i = 0; i < N; i++) {
            String password = br.readLine();
            p[i] = password;
            passwords.add(password);
        }
        for (String password : p) {
            if (passwords.contains(password) && passwords.contains(new StringBuilder(password).reverse().toString())) {
                bw.write(password.length() + " " + password.charAt(password.length() / 2) + "\n");
                break;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}