package com.hello.advanced.trace.strategy;

import com.hello.advanced.trace.strategy.code.strategy.ContextV2;
import com.hello.advanced.trace.strategy.code.strategy.StrategyLogic1;
import com.hello.advanced.trace.strategy.code.strategy.StrategyLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV2Test {

    @Test
    void strategyV1() {
        ContextV2 context = new ContextV2();
        context.execute(new StrategyLogic1());
        context.execute(new StrategyLogic2());
    }

}
