package com.til.algorithm.baekjoon.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 *  트리
 *
 *  트리에서 리프 노드란, 자식의 개수가 0인 노드를 말한다.
 *
 *  트리가 주어졌을 때, 노드 하나를 지울 것이다.
 *  그 때, 남은 트리에서 리프 노드의 개수를 구하는 프로그램을 작성하시오.
 *
 *  노드를 지우면 그 노드와 노드의 모든 자손이 트리에서 제거된다.
 *
 *  리프 노드 (= 자식 노드가 없는 노드)
 *
 *  각 노드의 부모 노드가 주어진다.
 *
 *  [잘못된 접근 - 트리 구조만 보고 해당 노드 삭제 후 해당 자식 노드는 신경 안 써도 되는 것 처럼 생각함]
 *  0번 부터 그래프 탐색
 *  -> 삭제할 노드를 만나면 패스
 *  -> 그렇지 않다면 방문
 *      -> 자식 노드가 없는 경우 + 1 (= 리프 노드)
 *
 *  단순히 삭제할 노드 그 자체만 제거하는 것이 아니라 해당 노드의 자식 노드가 없을 때 까지 계속 제거하는 로직을 돌려야 함.
 */
public class BOJ_1068 {

    static int n;
    static ArrayList<Integer>[] adjList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        adjList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int root = -1;
        for (int i = 0; i < n; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if (parent == -1) {
                root = i;
                continue;
            }
            // i (= 인덱스, 자식 노드)
            adjList[parent].add(i);
        }

        int remove = Integer.parseInt(br.readLine());
        removeNode(remove);
        if (remove == root) {
            System.out.println(0);
        } else {
            System.out.println(countLeafNodes(root));
        }
    }

    private static void removeNode(int target) {
        // 삭제할 자식노드가 1개 이상 있는 경우
        if (adjList[target].size() > 0) {
            int size = adjList[target].size();
            while (size > 0) {
                int child = adjList[target].get(--size);
                removeNode(child);
            }
        }

        for (int i = 0; i < n; i++) {
            if (adjList[i].contains(target)) {
                for (int j = 0; j < adjList[i].size(); j++) {
                    if (adjList[i].get(j) == target) {
                        adjList[i].remove(j);
                    }
                }
            }
        }
    }

    private static int countLeafNodes(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        int count = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            if (adjList[node].size() == 0) {
                count++;
                continue;
            }
            for (int adj : adjList[node]) {
                queue.add(adj);
            }
        }
        return count;
    }


}
