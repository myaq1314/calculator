package com.czh.calculator;

import com.czh.calculator.dict.CalculatorType;
import com.czh.calculator.layout.ShowJPanelFactory;

import java.math.BigDecimal;

/**
 * @author : czh
 * @description : Current 实例
 * @email 916419307@qq.com
 */
public class CurrentField {

    private static CalculatorType calculatorType;

    private static BigDecimal result = null;
    private static String input = null;
    private static String operate = null;


    public static CalculatorType get() {
        if (calculatorType == null) {
            build(CalculatorType.BASE);
        }
        return calculatorType;
    }

    public static void build(CalculatorType current) {
        CurrentField.calculatorType = current;
    }

    public static String getInput() {
        return input;
    }

    public static void setInput(String input) {
        CurrentField.input = input;
    }

    public static BigDecimal getResult() {
        return result;
    }

    public static void setResult(BigDecimal result) {
        CurrentField.result = result;
    }

    public static String getOperate() {
        return operate;
    }

    public static void setOperate(String operate) {
        CurrentField.operate = operate;
    }

    public static void setError(String input, String show) {
        setResult(null);
        setInput(null);
        setOperate(null);
        ShowJPanelFactory.getInputJTextField().setText(input);
        ShowJPanelFactory.getShowJTextField().setText(show);
    }
}
