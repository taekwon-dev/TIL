package com.til.algorithm.bigstone.week_3;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 *  숨바꼭질 5
 *
 *  1) 수빈이와 동생이 매 초 별로 움직인 위치가 동일한 경우
 *
 *  2) 수빈이가 동생보다 먼저 특정 위치에 도달한 경우
 *     - 수빈이는 뒤로 -1 만큼 이동할 수 있다.
 *     - 예를 들어, 수빈이가 2초에 `15` 에 도달하고 동생이 4초에 `15`에 도달한다고 가정해보자.
 *       수빈이는 3초에 `16(+1)` 으로 이동한 뒤 4초에 `15(-1)`로 다시 오면 동생과 만날 수 있다.
 *     - 이 때 주의할 점은 수빈이가 이동하는 양상을 통해 생각해볼 수 있는데,
 *       수빈이가 먼저 방문한 경우, 뒤로 돌아와야 동생과 만날 수 있고, 뒤로 움직여 원래 있던 위치로 올 떄는
 *       앞으로 한 번 이동했다가 (1초 소요), 다시 뒤로 돌아오는 (1초 소요) 과정을 통해 진행되므로 2초가 소요된다.
 *       따라서, 수빈이와 동생이 특정 위치에 도달하는 시간은 둘다 짝수 시간대거나 홀수 시간대여야 한다.
 */
public class BOJ_17071 {

    private static int N;
    private static int K;
    private static boolean[][] visited = new boolean[500_001][2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (N == K) {
            bw.write(0 + "\n");
        } else {
            bw.write(bfs(N) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static int bfs(int N) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);
        int time = 0;
        visited[N][time] = true;

        while (!queue.isEmpty()) {
            if (K > 500_000) {
                return -1;
            }
            int mod = time % 2;
            if (visited[K][mod]) {
                return time;
            }
            for (int i = 0, size = queue.size(); i < size; i++) {
                int now = queue.poll();
                int nextTime = (time + 1) % 2;
                int nx;

                nx = now - 1;
                if (nx >= 0 && !visited[nx][nextTime]) {
                    queue.offer(nx);
                    visited[nx][nextTime] = true;
                }
                nx = now + 1;
                if (nx < 500_001 && !visited[nx][nextTime]) {
                    queue.offer(nx);
                    visited[nx][nextTime] = true;
                }
                nx = now * 2;
                if (nx < 500_001 && !visited[nx][nextTime]) {
                    queue.offer(nx);
                    visited[nx][nextTime] = true;
                }
            }
            K += ++time;
        }
        return -1;
    }
}