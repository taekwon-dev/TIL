package com.til.algorithm.softeer;

import java.io.*;

public class LV2_8단변속기 {

    private static final int A = 1;
    private static final int D = 2;
    private static final int M = 3;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int[] arr = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        int result = -1;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (result == -1 && arr[i] < arr[j]) {
                    result = A;
                } else if (result == -1 && arr[i] > arr[j]) {
                    result = D;
                } else if (result != -1) {
                    if (result == A && arr[i] > arr[j]) {
                        result = M;
                    } else if (result == D && arr[i] < arr[j]) {
                        result = M;
                    }
                }
            }
        }

        if (result == A) {
            bw.write("ascending" + "\n");
        } else if (result == D) {
            bw.write("descending" + "\n");
        } else {
            bw.write("mixed" + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}