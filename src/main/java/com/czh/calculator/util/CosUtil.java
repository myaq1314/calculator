package com.czh.calculator.util;

import com.czh.calculator.exceptions.CalculatorException;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author : czh
 * @description : CosUtil 实例
 * @email 916419307@qq.com
 */
public class CosUtil {

    public static BigDecimal cos(BigDecimal num) {
        if (num == null) {
            throw new CalculatorException("cos ", "请输入数值");
        }
        double radians = Math.toRadians(num.doubleValue());
        double cos = Math.cos(radians);

        return new BigDecimal(String.valueOf(cos)).setScale(12, RoundingMode.HALF_DOWN).stripTrailingZeros();
    }
}
