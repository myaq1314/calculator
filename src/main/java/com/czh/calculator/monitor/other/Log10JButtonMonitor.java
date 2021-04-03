package com.czh.calculator.monitor.other;

import com.czh.calculator.CurrentField;
import com.czh.calculator.exceptions.CalculatorException;
import com.czh.calculator.layout.OperateJPanelFactory;
import com.czh.calculator.layout.ShowJPanelFactory;
import com.czh.calculator.monitor.global.OperateSymbolJButtonMonitor;
import com.czh.calculator.monitor.parent.JButtonMonitor;

import javax.swing.JButton;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author : czh
 * @description : Log10 监听器
 * @email 916419307@qq.com
 */
public class Log10JButtonMonitor implements JButtonMonitor {

    public static void log10() {
        BigDecimal result = CurrentField.getResult();
        String input = CurrentField.getInput();
        String operate = CurrentField.getOperate();

        if (result == null) {
            if (input != null) {
                result = new BigDecimal(input).stripTrailingZeros();
            }
        } else {
            if (input != null) {
                if (operate == null) {
                    result = new BigDecimal(input).stripTrailingZeros();
                } else {
                    OperateSymbolJButtonMonitor.setSymbol(operate);
                    CurrentField.setInput(null);
                    CurrentField.setOperate(null);
                    log10();
                    return;
                }
            }
        }

        if (result == null || result.compareTo(BigDecimal.ZERO) <= 0) {
            throw new CalculatorException("Log10运算错误：请输入大于0的数值", "log(10) " + result + " = ");
        }

        CurrentField.setResult(new BigDecimal(String.valueOf(Math.log10(result.doubleValue()))).setScale(12, RoundingMode.HALF_DOWN).stripTrailingZeros());
        CurrentField.setInput(null);
        CurrentField.setOperate(null);

        ShowJPanelFactory.getShowJTextField().setText("log(10) " + result.toPlainString() + " = ");
        ShowJPanelFactory.getInputJTextField().setText(CurrentField.getResult().toPlainString());
    }

    @Override
    public void addJButtonMonitor(JButton jButton) {
        jButton.addActionListener(e -> {
            log10();
            OperateJPanelFactory.startCCleanJButton();
        });
    }

}
