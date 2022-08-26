package com.youn.template.v1;

/**
 *  Generic 지정
 *  인터페이스를 구현하는 쪽에서 타입 지정 시 아래 추상 메서드 반환 타입까지 연동
 */
public interface Callback<T> {
    T callback();
}
