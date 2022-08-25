package com.hello.advanced.app.v5.manual_di;

import com.hello.advanced.trace.callback.TraceTemplate;
import com.hello.advanced.trace.logtrace.LogTrace;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceV5 {

    private final OrderRepositoryV5 orderRepository;
    private final TraceTemplate template;

    public OrderServiceV5(OrderRepositoryV5 orderRepository, LogTrace trace) {
        this.orderRepository = orderRepository;
        this.template = new TraceTemplate(trace);
    }

    public void orderItem(String itemId) {

        template.execute("OrderService.orderItem()", () -> {
            // 전략
            orderRepository.save(itemId);
            return null;
        });
    }
}
