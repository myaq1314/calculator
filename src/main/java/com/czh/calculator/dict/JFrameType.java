package com.czh.calculator.dict;

/**
 * @author : czh
 * @description : JFrameType 枚举
 * @email 916419307@qq.com
 */
public enum JFrameType {

    BASE(400, 600 + 30, 200, 0, CalculatorType.BASE),
    SCIENCE(600, 700 + 30, 200, 0, CalculatorType.SCIENCE),

    // 扩展位
    ;

    public final int width;
    public final int height;
    public final int x;
    public final int y;
    public final CalculatorType parent;

    JFrameType(int width,
               int height,
               int x,
               int y,
               CalculatorType parent) {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.parent = parent;
    }

    public static JFrameType getByParent(CalculatorType calculatorType) {
        if (calculatorType == null) {
            throw new RuntimeException("参数必填");
        }
        JFrameType[] jFrameTypes = JFrameType.values();
        for (JFrameType jFrameType : jFrameTypes) {
            if (jFrameType.parent.equals(calculatorType)) {
                return jFrameType;
            }
        }
        throw new RuntimeException("找不到符合条件的枚举");
    }
}
