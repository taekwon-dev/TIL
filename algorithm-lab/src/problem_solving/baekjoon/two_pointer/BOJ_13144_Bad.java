package problem_solving.baekjoon.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 시간 초과 O(n^2), n <= 100_000
public class BOJ_13144_Bad {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] count = new int[100_001];
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        for (int p1 = 0; p1 < n; p1++) {
            int p2 = p1;
            while (p2 < n && count[arr[p2]] == 0) {
                answer++;
                count[arr[p2]]++;
                p2++;
            }
            Arrays.fill(count, 0);
        }

        System.out.println(answer);
    }
}
