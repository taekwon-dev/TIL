package problem_solving.baekjoon.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20922 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] count = new int[100_001];
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int p2 = 0;
        int answer = 0;
        for (int p1 = 0; p1 < n; p1++) {
            while (p2 < n && count[arr[p2]] < k) {
                count[arr[p2]]++;
                p2++;
            }
            count[arr[p1]]--;

            answer = Math.max(answer, p2 - p1);
        }

        System.out.println(answer);
    }
}
