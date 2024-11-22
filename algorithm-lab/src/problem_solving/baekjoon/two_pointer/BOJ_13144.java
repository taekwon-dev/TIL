package problem_solving.baekjoon.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_13144 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] count = new int[100_001];
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int p2 = 0;
        long answer = 0;
        for (int p1 = 0; p1 < n; p1++) {
            while (p2 < n && count[arr[p2]] == 0) {
                count[arr[p2]]++;
                p2++;
            }
            count[arr[p1]]--;

            answer += p2 - p1;
        }

        System.out.println(answer);
    }
}
