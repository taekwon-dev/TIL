package com.hello.advanced.trace.callback;

import com.hello.advanced.trace.TraceStatus;
import com.hello.advanced.trace.logtrace.LogTrace;

/**
 *  인터페이스가 아니다.
 *  빈으로 등록된 로그 트레이스에 의존한다.
 */
public class TraceTemplate {
    private final LogTrace trace;

    // 코드를 통한 수동 DI
    public TraceTemplate(LogTrace trace) {
        this.trace = trace;
    }

    public <T> T execute(String message, TraceCallback<T> callback) {
        TraceStatus status = null;
        try {
            status = trace.begin(message);
            T result = callback.call();
            trace.end(status);
            return result;
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }
}
