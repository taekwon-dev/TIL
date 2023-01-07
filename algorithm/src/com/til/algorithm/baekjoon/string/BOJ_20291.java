package com.til.algorithm.baekjoon.string;

import java.io.*;
import java.util.*;

public class BOJ_20291 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        Map<String, Integer> ext = new HashMap<>();
        while (N-- > 0) {
            String[] filename = br.readLine().split("\\.");
            String extension = filename[1];
            if (ext.containsKey(extension)) {
                ext.put(extension, ext.get(extension) + 1);
                continue;
            }
            ext.put(extension, 1);
        }
        List<String> extensions = new ArrayList<>(ext.keySet());
        Collections.sort(extensions, Comparator.naturalOrder());
        for (String extension : extensions) {
            bw.write(extension + " " + ext.get(extension) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}