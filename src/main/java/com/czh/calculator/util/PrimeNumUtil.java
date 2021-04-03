package com.czh.calculator.util;

import com.czh.calculator.exceptions.CalculatorException;

import java.math.BigDecimal;

/**
 * @author : czh
 * @description : PrimeNumUtil 实例
 * @email 916419307@qq.com
 */
public class PrimeNumUtil {

    public static String checkPrimeNum(BigDecimal num) {
        if (num == null) {
            num = BigDecimal.ZERO;
        }

        int i = num.compareTo(BigDecimal.ZERO);
        if (i == 0) {
            throw new CalculatorException("0不是质数", "判断 0 是不是质数：");
        } else if (i < 0) {
            throw new CalculatorException("负数不是质数", "判断 " + num + " 是不是质数：");
        }

        if (num.stripTrailingZeros().toPlainString().contains(".")) {
            throw new CalculatorException("小数不是质数", "判断 " + num.toPlainString() + " 是不是质数：");
        }

        long l = num.longValue();
        if (l == 1) {
            return "不是质数";
        } else if (l % 2 == 0) {
            if (l == 2) {
                return "质数";
            }
            return "不是质数";
        }
        for (int j = 3; j <= Math.sqrt(l); j += 2) {
            if (l % j == 0) {
                return "不是质数";
            }
        }
        return "质数";
    }
}
