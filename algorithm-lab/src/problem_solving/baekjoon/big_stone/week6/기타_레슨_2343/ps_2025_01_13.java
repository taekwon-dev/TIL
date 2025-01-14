package problem_solving.baekjoon.big_stone.week6.기타_레슨_2343;

import java.io.*;
import java.util.StringTokenizer;

public class ps_2025_01_13 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] jewels = new int[M];

        int low = 1;
        int high = 0;
        for (int i = 0; i < M; i++) {
            jewels[i] = Integer.parseInt(br.readLine());
            high = Math.max(high, jewels[i]);
        }

        int answer = 0;
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
                answer = mid;
            }
        }

        System.out.println(answer);
    }
}
