package com.youn.calculator;

/**
 * Created by Youn on 2022/06/26.
 * Title :
 * Hint  :
 */
public class Calculator {
    private int left, right;

    public void setOprands(int left, int right) {
        this.left = left;
        this.right = right;
    }

    private int sum() {
        return this.left + this.right;
    }

    public void sumDecoPlus() {
        System.out.println("++++sum++++");
    }

    public void sumDecoMinus() {
        System.out.println("----sum----");
    }
}
