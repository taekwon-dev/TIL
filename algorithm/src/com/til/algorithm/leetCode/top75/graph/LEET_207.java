package com.til.algorithm.leetCode.top75.graph;

/**
 *  Course Schedule
 *  [ a, b ] = b 를 수강하기 위해서는 반드시 a 를 선수강 해야 한다.
 *  ---
 *
 *  [ a, b ]
 *  [ b, a ]
 *
 *  위 처럼 주어지면, 각 수업의 선수 과목 조건으로 a, b 어떤 수업도 수강할 수 없음 -> false
 *  ---
 *  주어진 edges 를 통해서 위와 같은 상황이 발견 되면 return false (역 이용)
 *  시작 시점은 1로 고정 -> 1이 시작 조건이 될 수 없는 경우 (1을 듣기 위한 선수강 과목이 있으면?)
 *  ---
 *  위 생각에서 고려하지 못한 지점은 시작 지점을 1로 고정 했을 때 1을 수강하기 위해 필요한 선수강 과목이 없어야 한다는 전제가 필요하다는 것이다.
 *  즉, 1 ~ N 노드 중 선수강 과목이 없는 (= 자신 노드로 간선이 없는 경우, 유향 그래프) 노드를 찾고 -> 이를 시작 노드로 지정
 *
 */
public class LEET_207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        return false;
    }
}
