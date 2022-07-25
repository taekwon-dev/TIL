package com.til.algorithm.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *  넴모넴모 (Easy)
 *
 *  격자판의 비어 있는 칸을 임의로 골라 “넴모”를 하나 올려놓거나,
 *  넴모”가 올라간 칸 네 개가 2 × 2 사각형을 이루는 부분을 찾아
 *  그 위에 있는 “넴모”들을 모두 없애는 것을 질릴 때까지 반복하면 된다.
 *
 *  “넴모”를 없애고 싶은데 격자판 위에 없앨 수 있는 “넴모”가 없으면
 *  게임을 그만두기로 했다.
 *
 *
 *  네모가 게임을 그만두었을 때 나올 수 있는
 *  “넴모”의 배치의 가짓수를 구하여라.
 *
 *  = 게임 종료 조건의 경우의 수를 구하라. (문제 해석)
 *
 *  게임 흐름
 *  - 빈 칸 중 임의로 한 곳을 골라 네모를 올린다.
 *  - 그 상태에서 2X2 인 영역(네 개의 네모)을 지운다.
 *    -> 매 번 네모를 착수할 때마다 검사 -> 그래프 탐색을 통해서 영역 중 2X2 인 곳 있는 지 여부 검사
 *    -> 단순히 영역의 크기로 구분할 수 없음
 *    -> 크기가 4이고, 순환하는 조건일 떄 2X2 (정사각형) 조건임을 알 수 있음
 *    -> 지우게 되면 해당 부분은 다시 네모를 올릴 수 있으므로 해당 부분에 대한 방문 여부를 초기화 처리 해야 함
 *  - 단, 2X2 가 없는 경우 게임을 종료하고, 경우의 수 ++
 *
 *  행의 개수 N, 열의 개수 M(1 ≤ N, M ≤ 25, 1 ≤ N × M ≤ 25)
 *
 *  ----
 *
 *  위 방식으로 풀면 일종의 구현 + 시뮬레이션 문제가 되는데 상당히 복잡하다.
 *  다른 관점으로 볼 수도 있는데,
 *
 *  지금 궁금한 것은 게임 진행 상황에서 2X2가 없어서 게임이 종료되는 경우의 수를 찾는 것
 *  하나씩 네모를 착수하면서 검사하게 되면 처음 (위에서 생각한) 방식으로 구현해야 하는데,
 *
 *  - - - - - | 도달하면 한 줄 아래로
 *  - - - - - |
 *  .
 *  .
 *  .
 *  - - - - - | 마지막 줄에 도달 했을 때 해당 시점에 놓인 상태에서 2X2가 있는 지 확인
 *
 *
 *
 *
 */
public class BOJ_14712 {
    static int n, m;
    static boolean[][] map;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new boolean[n][m];
        backtracking(0, 0);
        System.out.println(answer);
    }

    private static void backtracking(int row, int col) {
        if (row == n) {
            // 네 칸씩 확인 (2 X 2)
            for (int i = 0; i <= n - 2; i++) {
                for (int j = 0; j <= m - 2; j++) {
                    if (map[i][j] && map[i][j + 1] && map[i + 1][j] && map[i + 1][j + 1]) {
                        return;
                    }
                }
            }
            answer++;
            return;
        }
        int nc = (col + 1 == m) ? 0 : col + 1;
        int nr = (nc == 0) ? row + 1 : row;

        map[row][col] = true;
        backtracking(nr, nc);

        map[row][col] = false;
        backtracking(nr, nc);
    }
}
