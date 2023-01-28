package com.til.algorithm.bigstone.hidden_1.sort;

import java.io.*;
import java.util.Arrays;

public class BOJ_2587 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int sum = 0;
        int[] arr = new int[5];
        for (int i = 0; i < 5; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        Arrays.sort(arr);

        bw.write(sum / 5 + "\n");
        bw.write(arr[(0 + 5) / 2] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}