package com.youn.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorClientTest {

    @Test
    @DisplayName("ㄴㅇㄹㄴㅇㄹ")
    void access_modifier() {
        Calculator calculator = new Calculator();
        calculator.setOprands(10, 30);
        calculator.sumDecoPlus();
        calculator.sumDecoMinus();
    }

}