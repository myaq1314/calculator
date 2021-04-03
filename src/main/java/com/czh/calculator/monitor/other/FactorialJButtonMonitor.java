package com.czh.calculator.monitor.other;

import com.czh.calculator.CurrentField;
import com.czh.calculator.exceptions.CalculatorException;
import com.czh.calculator.layout.OperateJPanelFactory;
import com.czh.calculator.layout.ShowJPanelFactory;
import com.czh.calculator.monitor.global.OperateSymbolJButtonMonitor;
import com.czh.calculator.monitor.parent.JButtonMonitor;
import com.czh.calculator.util.FactorialUtil;

import javax.swing.JButton;
import java.math.BigDecimal;

/**
 * @author : czh
 * @description : 阶乘
 * @email 916419307@qq.com
 */
public class FactorialJButtonMonitor implements JButtonMonitor {

    public static void factorial() {
        BigDecimal result = CurrentField.getResult();
        String input = CurrentField.getInput();
        String operate = CurrentField.getOperate();

        if (result == null) {
            if (input == null) {
                result = BigDecimal.ZERO;
            } else {
                result = new BigDecimal(input);
            }
        } else {
            if (input != null) {
                if (operate == null) {
                    result = new BigDecimal(input);
                } else {
                    OperateSymbolJButtonMonitor.setSymbol(operate);
                    CurrentField.setOperate(null);
                    CurrentField.setInput(null);
                    factorial();
                    return;
                }

            }
        }

        if (result.stripTrailingZeros().toPlainString().contains(".")) {
            throw new CalculatorException("阶乘运算错误：请输入整数", result.stripTrailingZeros().toPlainString() + "! = ");
        }
        if (result.compareTo(new BigDecimal(100)) > 0) {
            throw new CalculatorException("阶乘运算错误：数值过大", result.stripTrailingZeros().toPlainString() + "! = ");
        }

        CurrentField.setResult(FactorialUtil.factorial(result).stripTrailingZeros());
        CurrentField.setInput(null);
        CurrentField.setOperate(null);

        ShowJPanelFactory.getInputJTextField().setText(CurrentField.getResult().toPlainString());
        ShowJPanelFactory.getShowJTextField().setText(result.stripTrailingZeros().toPlainString() + "! = ");
    }

    @Override
    public void addJButtonMonitor(JButton jButton) {
        jButton.addActionListener(e -> {
            factorial();
            OperateJPanelFactory.startCCleanJButton();
        });
    }

}
