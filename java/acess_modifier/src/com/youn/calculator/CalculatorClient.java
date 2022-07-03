package com.youn.calculator;

/**
 * Created by Youn on 2022/06/26.
 * Title :
 * Hint  :
 */
public class CalculatorClient {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.setOprands(10, 30);
        calculator.sumDecoPlus();
        calculator.sumDecoMinus();
    }
}
