package com.czh.calculator.util;

import com.czh.calculator.exceptions.CalculatorException;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author : czh
 * @description : TanUtil 实例
 * @email 916419307@qq.com
 */
public class TanUtil {

    public static BigDecimal tan(BigDecimal num) {
        if (num == null) {
            throw new CalculatorException("tan ", "请输入数值");
        }
        if (new BigDecimal(90).compareTo(num) == 0) {
            throw new CalculatorException("NAN", "tan(90)");
        }
        double radians = Math.toRadians(num.doubleValue());
        double cos = Math.cos(radians);

        return new BigDecimal(String.valueOf(cos)).setScale(12, RoundingMode.HALF_DOWN).stripTrailingZeros();
    }

}
