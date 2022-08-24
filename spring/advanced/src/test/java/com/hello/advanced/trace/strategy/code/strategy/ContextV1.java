package com.hello.advanced.trace.strategy.code.strategy;

import lombok.extern.slf4j.Slf4j;

/**
 *  필드에 전략을 보관하는 방식
 */

@Slf4j
public class ContextV1 {

    // 컨텍스트에서는 구현체가 아닌 인터페이스(추상화)에만 의존한다.
    private Strategy strategy;

    /** 생서자를 통해 의존관계 주입 */
    public ContextV1(Strategy strategy) {
        this.strategy = strategy;
    }

    public void execute() {
        long startTime = System.currentTimeMillis();

        // 비즈니스 로직 실행
        strategy.call();
        // 비즈니스 로직 종료

        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime={}", resultTime);
    }
}
