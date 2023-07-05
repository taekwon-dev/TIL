package com.til.algorithm.programmers.kit;

/**
 *  String.indexOf()를 통해 문자열 탐색 + 시작 위치 값 반환되는 것을 활용
 */
public class LV0_문자열밀기_아이디어 {

    public int solution(String A, String B) {
        String tempB = B.repeat(2);
        return tempB.indexOf(A);
    }
}