package com.til.algorithm.bigstone.week_6;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2792 {

    private static int[] jewels;
    private static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        jewels = new int[M];

        for (int i = 0; i < M; i++) {
            jewels[i] = Integer.parseInt(br.readLine());
            if (max < jewels[i]) {
                max = jewels[i];
            }
        }

        bw.write(binary_search(N) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static int binary_search(int N) {
        int min = max;
        int high = max;
        int low = 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int people = 0;
            for (int jewel : jewels) {
                people += jewel / mid;
                if (jewel % mid != 0) {
                    people++;
                }
            }
            if (people > N) {
                low = mid + 1;
            } else {
                high = mid - 1;
                min = mid;
            }
        }
        return min;
    }
}