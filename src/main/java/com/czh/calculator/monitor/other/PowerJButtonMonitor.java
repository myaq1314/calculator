package com.czh.calculator.monitor.other;

import com.czh.calculator.CurrentField;
import com.czh.calculator.exceptions.CalculatorException;
import com.czh.calculator.layout.OperateJPanelFactory;
import com.czh.calculator.layout.ShowJPanelFactory;
import com.czh.calculator.monitor.global.OperateSymbolJButtonMonitor;
import com.czh.calculator.monitor.parent.JButtonMonitor;
import jdk.nashorn.internal.objects.Global;

import javax.swing.JButton;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author : czh
 * @description : 次方 监听器
 * @email 916419307@qq.com
 */
public class PowerJButtonMonitor implements JButtonMonitor {

    public static void power() {
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
                } else if ("x^y".equals(operate)) {
                    temp = new BigDecimal(input);
                } else {
                    OperateSymbolJButtonMonitor.setSymbol(operate);
                    CurrentField.setInput(null);
                    CurrentField.setOperate("x^y");
                    return;
                }
            }
        }

        if (temp != null) {
            Double pow = Math.pow(result.doubleValue(), temp.doubleValue());
            if ("Infinity".equals(String.valueOf(pow))) {
                throw new CalculatorException("无穷大", result.stripTrailingZeros().toPlainString() + " ^ " + temp.stripTrailingZeros().toPlainString());
            } else if ("NaN".equals(String.valueOf(pow))) {
                throw new CalculatorException("不是数字", result.stripTrailingZeros().toPlainString() + " ^ " + temp.stripTrailingZeros().toPlainString());
            }
            result = new BigDecimal(String.valueOf(pow)).setScale(12, RoundingMode.HALF_DOWN).stripTrailingZeros();
        }

        CurrentField.setResult(result.stripTrailingZeros());
        CurrentField.setInput(null);
        CurrentField.setOperate("x^y");

        ShowJPanelFactory.getShowJTextField().setText(result.toPlainString() + " ^ ");
        ShowJPanelFactory.getInputJTextField().setText("");
    }

    @Override
    public void addJButtonMonitor(JButton jButton) {
        jButton.addActionListener(e -> {
            power();
            OperateJPanelFactory.startCCleanJButton();
        });
    }
}
