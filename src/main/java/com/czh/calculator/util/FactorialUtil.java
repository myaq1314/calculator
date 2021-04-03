package com.czh.calculator.util;

import java.math.BigDecimal;

/**
 * @author : czh
 * @description : FactorialUtil 实例
 * @email 916419307@qq.com
 */
public class FactorialUtil {

    public static long factorial(long num) {
        boolean flag = num >= 0;
        if (flag) {
            return recurrence(num);
        }
        return recurrence(num * -1) * -1;
    }

    private static long recurrence(long num) {
        long result = 1;
        for (long i = 2; i <= num; i++) {
            result *= i;
        }
        return result;
    }


    public static BigDecimal factorial(BigDecimal num) {
        boolean flag = num.compareTo(BigDecimal.ZERO) >= 0;
        if (flag) {
            return recurrence(num);
        }
        return recurrence(num.multiply(new BigDecimal(-1))).multiply(new BigDecimal(-1));
    }

    private static BigDecimal recurrence(BigDecimal num) {
        BigDecimal result = BigDecimal.ONE;
        for (BigDecimal i = new BigDecimal(2); i.compareTo(num) <= 0; i = i.add(BigDecimal.ONE)) {
            result = result.multiply(i);
        }
        return result;
    }
}
