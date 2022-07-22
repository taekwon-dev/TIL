package com.taekwonv.jdbc.exception.basic;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

@Slf4j
public class CheckedTest {

    @Test
    void checked_catch() {
        Service service = new Service();
        service.callCatch();
    }

    @Test
    void checked_throw() {
        Service service = new Service();
        Assertions.assertThatThrownBy(() -> service.callThrow()).isInstanceOf(MyCheckedException.class);
    }

    /**
     *  Exception 상속 받은 예외는 체크 예외가 된다.
     */
    static class MyCheckedException extends Exception {
        public MyCheckedException(String message) {
            super(message);
        }
    }

    static class Service {
        Repository repository = new Repository();
        /**
         * 예외를 잡아서 처리하는 부분
         */
        public void callCatch() {
            try {
                repository.call();
            } catch (MyCheckedException ex) {
                log.info("예외 처리, message={}", ex.getMessage(), ex);
            }
        }

        /**
         * 체크 예외는 직접 처리하기 않고 호출자에 위임하려면 `throws` 키워드를 반드시 선언
         * @throws MyCheckedException
         */
        public void callThrow() throws MyCheckedException {
            repository.call();
        }
    }

    static class Repository {
        // Checked Exception 은 선언 (= 명시)해야 한다.
        // 직접 처리하거나 호출하는 쪽으로 위임
        public void call() throws MyCheckedException {
            throw new MyCheckedException("ex");
        }
    }

}
