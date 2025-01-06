package problem_solving.baekjoon.binary_search;

import java.util.*;
import java.io.*;

public class 가장_긴_증가하는_부분_수열 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        int[] len = new int[n];
        Arrays.fill(len, -1);
        for (int i = 0; i < n; i++) {
            int maxLen = 0;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && maxLen < len[j]) {
                    maxLen = len[j];
                }
            }
            len[i] = maxLen + 1;
            answer = Math.max(answer, len[i]);
        }

        System.out.println(answer);
    }
}
