package com.taekwonv.jdbc.exception.basic;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

@Slf4j
public class UnCheckedTest {

    @Test
    void unchecked_catch() {
        Service service = new Service();
        service.callCatch();
    }

    @Test
    void unchecked_throw() {
        Service service = new Service();
        Assertions.assertThatThrownBy(() -> service.callThrow()).isInstanceOf(MyUncheckedException.class);
    }


    static class MyUncheckedException extends RuntimeException {
        public MyUncheckedException(String message) {
            super(message);
        }
    }

    static class Service {
        Repository repository = new Repository();

        /**
         * 필요한 경우 예외를 잡아서 처리한다.
         */
        public void callCatch() {
            try {
                repository.call();
            } catch (MyUncheckedException ex) {
                log.info("예외 처리, message={}", ex.getMessage(), ex);
            }
        }

        /**
         * 예외를 별도로 선언하지 않아도 호출자에서 예외 발생
         */
        public void callThrow() {
            repository.call();
        }

    }

    static class Repository {
        // Checked Exception 은 선언 (= 명시)해야 한다.
        // 직접 처리하거나 호출하는 쪽으로 위임
        public void call() {
            throw new MyUncheckedException("ex");
        }
    }

}
