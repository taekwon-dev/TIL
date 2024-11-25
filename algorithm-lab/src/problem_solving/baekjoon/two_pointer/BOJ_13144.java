package problem_solving.baekjoon.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import java.util.*;
import java.io.*;

public class BOJ_13144 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] countArr = new int[100_001];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long answer = 0;
        int p2 = 0;
        for (int p1 = 0; p1 < n; p1++) {
            while (p2 < n && countArr[arr[p2]] < 1) {
                countArr[arr[p2]]++;
                p2++;
            }
            countArr[arr[p1]]--;

            answer += p2 - p1;
        }

        System.out.println(answer);
    }
}
