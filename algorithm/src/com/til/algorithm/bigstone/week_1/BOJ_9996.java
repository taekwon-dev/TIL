package com.til.algorithm.bigstone.week_1;

import java.io.*;

public class BOJ_9996 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String[] pattern = br.readLine().split("\\*");
        String s = pattern[0];
        String e = pattern[1];

        while (n-- > 0) {
            String filename = br.readLine();
            if ((s + e).length() - 1 > filename.length()) {
                bw.write("NE" + "\n");
                continue;
            }
            if (filename.startsWith(s) && filename.endsWith(e)) {
                bw.write("DA" + "\n");
                continue;
            }
            bw.write("NE" + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}