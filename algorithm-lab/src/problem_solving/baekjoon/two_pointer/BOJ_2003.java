package problem_solving.baekjoon.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2003 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer= 0;
        int sum = 0;
        int p2 = 0;
        for (int p1 = 0; p1 < n; p1++) {
            while (p2 < n && sum < m) {
                sum += arr[p2++];
            }
            if (sum == m) {
                answer++;
            }
            sum -= arr[p1];
        }

        System.out.println(answer);
    }
}