package com.til.algorithm.leetCode.top75.graph;

import com.til.algorithm.leetCode.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 *   undirected graph
 *   a deep copy (clone) of the graph
 *
 *
 *   <풀이전 생각>
 *   - 주어진 노드를 기준으로 BFS OR DFS 통해서 순회 하면서 노드의 개수를 파악
 *   - 각 노드 간 간선 -> 이차원 배열
 *   - 위 간선 정보를 통해서 새로운 그래프 생성 및 반환
 *
 *   <솔루션>
 *   https://www.programcreek.com/2012/12/leetcode-clone-graph-java/
 *   - 위 생각에서 노드 개수 파악하는 것과 간선 정보를 파악하고 저장하는 과정이 동시에 진행될 수 없음 (순차)
 *   - 각 노드를 방문 하면서 해당 노드를 새로 생성한 뒤 연결해주면 되는데, 이 때 연결관계가 동일하므로 이 구조가 가능
 *   - 이 때 기존 노드 : 새로운 노드 (맵 구조 활용)
 *
 */

public class LEET_133 {
    HashMap<Node, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {

        if (node == null) return node;

        map.put(node, new Node(node.val, new ArrayList<>()));

        for (Node adj : node.neighbors) {
            if (map.containsKey(adj)) {
                map.get(node).neighbors.add(map.get(adj));
            } else {
                map.get(node).neighbors.add(cloneGraph(adj));
            }
        }
        return map.get(node);
    }

    private Node bfs(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        map.put(node, new Node(node.val, new ArrayList<>()));

        while (!queue.isEmpty()) {

            Node now = queue.poll();

            for (Node neighbor : now.neighbors) {
                // 현재 노드에 인접한 노드 리스트 순회 -> 아직 맵에 등록되지 않은 경우에만 -> 등록
                if (!map.containsKey(neighbor)) {
                    queue.add(neighbor);
                    map.put(neighbor, new Node(neighbor.val, new ArrayList<>()));
                }
                map.get(now).neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node);
    }
}
