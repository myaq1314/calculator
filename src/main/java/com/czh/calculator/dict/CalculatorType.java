package com.czh.calculator.dict;

/**
 * @author : czh
 * @description : CalculatorType 枚举
 * @email 916419307@qq.com
 */
public enum CalculatorType {

    BASE("基本计算器", 1, 2),
    SCIENCE("科学计算器", 2, 1),

    // 扩展位
    ;

    public final String title;
    public final Integer index;
    public final Integer next;


    CalculatorType(String title, Integer index, Integer next) {
        this.title = title;
        this.index = index;
        this.next = next;
    }

    public static CalculatorType getByIndex(Integer index) {
        if (index == null) {
            throw new RuntimeException("参数必填");
        }
        CalculatorType[] calculatorTypes = CalculatorType.values();
        for (CalculatorType calculatorType : calculatorTypes) {
            if (calculatorType.index.equals(index)) {
                return calculatorType;
            }
        }
        throw new RuntimeException("找不到符合条件的枚举");
    }
}
