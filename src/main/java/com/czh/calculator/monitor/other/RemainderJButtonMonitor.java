package com.czh.calculator.monitor.other;

import com.czh.calculator.CurrentField;
import com.czh.calculator.exceptions.CalculatorException;
import com.czh.calculator.layout.OperateJPanelFactory;
import com.czh.calculator.layout.ShowJPanelFactory;
import com.czh.calculator.monitor.global.OperateSymbolJButtonMonitor;
import com.czh.calculator.monitor.parent.JButtonMonitor;

import javax.swing.JButton;
import java.math.BigDecimal;

/**
 * @author : czh
 * @description : 取余 监听器
 * @email 916419307@qq.com
 */
public class RemainderJButtonMonitor implements JButtonMonitor {

    public static void remainder() {
        BigDecimal result = CurrentField.getResult();
        String input = CurrentField.getInput();
        String operate = CurrentField.getOperate();

        BigDecimal temp = null;
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
                } else if ("取余".equals(operate)) {
                    temp = new BigDecimal(input);
                } else {
                    OperateSymbolJButtonMonitor.setSymbol(operate);
                    CurrentField.setInput(null);
                    CurrentField.setOperate("取余");
                    return;
                }
            }
        }

        if (result.stripTrailingZeros().toPlainString().contains(".")) {
            throw new CalculatorException("取余运算错误：请输入整数", result.stripTrailingZeros().toPlainString() + " 取余 ");
        }
        if (temp != null && temp.stripTrailingZeros().toPlainString().contains(".")) {
            throw new CalculatorException("取余运算错误：请输入整数", result.stripTrailingZeros().toPlainString() + " 取余 " + temp.stripTrailingZeros().toPlainString());
        }

        if (temp != null) {
            result = new BigDecimal(result.longValue() % temp.longValue()).stripTrailingZeros();
        }

        CurrentField.setResult(result.stripTrailingZeros());
        CurrentField.setInput(null);
        CurrentField.setOperate("取余");

        ShowJPanelFactory.getShowJTextField().setText(CurrentField.getResult().toPlainString() + " 取余 ");
        ShowJPanelFactory.getInputJTextField().setText("");
    }

    @Override
    public void addJButtonMonitor(JButton jButton) {
        jButton.addActionListener(e -> {
            remainder();
            OperateJPanelFactory.startCCleanJButton();
        });
    }
}