package com.til.algorithm.bigstone.week_5;

import java.io.*;

public class BOJ_9935_string_builder {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String parent = br.readLine();
        String pattern = br.readLine();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < parent.length(); i++) {
            sb.append(parent.charAt(i));
            if (sb.length() >= pattern.length()) {
                boolean contains = true;
                for (int j = 0; j < pattern.length(); j++) {
                    if (sb.charAt(sb.length() - pattern.length() + j) != pattern.charAt(j)) {
                        contains = false;
                        break;
                    }
                }
                if (contains) {
                    sb.delete(sb.length() - pattern.length(), sb.length());
                }
            }
        }
        if (sb.length() == 0) {
            bw.write("FRULA" + "\n");
        } else {
            bw.write(sb.toString() + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}