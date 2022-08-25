package com.hello.advanced.app.v5.manual_di;

import com.hello.advanced.trace.callback.TraceTemplate;
import com.hello.advanced.trace.logtrace.LogTrace;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepositoryV5 {

    private final TraceTemplate template;

    // 생성자가 하나만 있을 때는 별도 자동 주입 선언할 필요 없다.
    public OrderRepositoryV5(LogTrace trace) {
        this.template = new TraceTemplate(trace);
    }


    public void save(String itemId) {

        template.execute("OrderRepository.save()", () -> {
            if (itemId.equals("ex")) {
                throw new IllegalStateException("예외 발생!");
            }
            sleep(1000);
            return null;
        });
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
