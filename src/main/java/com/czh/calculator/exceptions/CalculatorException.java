package com.czh.calculator.exceptions;

/**
 * @author : czh
 * @description : CalculatorException 实例
 * @email 916419307@qq.com
 */
public class CalculatorException extends RuntimeException {

    private final String input;
    private final String show;

    public CalculatorException(String input, String show) {
        this.input = input;
        this.show = show;
    }

    public String getInput() {
        return input;
    }

    public String getShow() {
        return show;
    }
}
