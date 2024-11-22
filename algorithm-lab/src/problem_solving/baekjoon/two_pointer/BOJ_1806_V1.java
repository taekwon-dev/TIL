package problem_solving.baekjoon.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// sum = arr[0]
public class BOJ_1806_V1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] a = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int sum = a[0];
        int min = Integer.MAX_VALUE;
        int p2 = 0;

        for (int p1 = 0; p1 < n; p1++) {
            while (p2 < n && sum < s) {
                p2++;
                if (p2 != n) sum += a[p2];
            }

            if (p2 == n) break;
            min = Math.min(min, p2 - p1 + 1);
            sum -= a[p1];
        }

        if (min == Integer.MAX_VALUE) min = 0;
        System.out.println(min);
    }
}
