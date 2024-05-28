package greedy;

import java.io.*;

public class BOJ_5585 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        final int[] changes = {500, 100, 50, 10, 5, 1};

        int payment = Integer.parseInt(br.readLine());
        int source = 1_000 - payment;

        int answer = 0;
        for (int change : changes) {
            if (source < change) {
                continue;
            }
            answer += source / change;
            source -= change * (source / change);
        }

        bw.write(answer + "\n");
        bw.flush();

        bw.close();
        br.close();
    }
}
