package problem_solving.baekjoon.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import java.util.*;
import java.io.*;

public class BOJ_20922 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int[] countArr = new int[100_001];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int maxLen = 0;
        int p2 = 0;
        for (int p1 = 0; p1 < n; p1++) {
            while (p2 < n && countArr[arr[p2]] < k) {
                countArr[arr[p2]]++;
                p2++;
            }
            if (p2 == n) break;

            int len = p2 - p1;
            if (maxLen < len) {
                maxLen = len;
            }
            countArr[arr[p1]]--;
        }

        System.out.println(maxLen);
    }
}
