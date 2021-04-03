package com.czh.calculator.util;

import com.czh.calculator.exceptions.CalculatorException;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author : czh
 * @description : SinUtil 实例
 * @email 916419307@qq.com
 */
public class SinUtil {

    public static BigDecimal sin(BigDecimal num) {
        if (num == null) {
            throw new CalculatorException("sin ", "请输入数值");
        }
        double radians = Math.toRadians(num.doubleValue());
        double sin = Math.sin(radians);

        return new BigDecimal(String.valueOf(sin)).setScale(12, RoundingMode.HALF_DOWN).stripTrailingZeros();
    }

}
