package com.czh.calculator.monitor.base;

import com.czh.calculator.CurrentField;
import com.czh.calculator.layout.OperateJPanelFactory;
import com.czh.calculator.layout.ShowJPanelFactory;
import com.czh.calculator.monitor.global.OperateSymbolJButtonMonitor;
import com.czh.calculator.monitor.parent.JButtonMonitor;

import javax.swing.JButton;
import java.math.BigDecimal;

/**
 * @author : czh
 * @description : 乘号 监听器
 * @email 916419307@qq.com
 */
public class MultiplyJButtonMonitor implements JButtonMonitor {

    public static void multiply() {
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
                } else if ("×".equals(operate)) {
                    result = result.multiply(new BigDecimal(input));
                } else {
                    OperateSymbolJButtonMonitor.setSymbol(operate);
                    CurrentField.setInput(null);
                    CurrentField.setOperate("×");
                    multiply();
                    return;
                }
            }
        }
        CurrentField.setResult(result.stripTrailingZeros());
        CurrentField.setInput(null);
        CurrentField.setOperate("×");

        ShowJPanelFactory.getShowJTextField().setText(CurrentField.getResult().toPlainString() + " * ");
        ShowJPanelFactory.getInputJTextField().setText("");
    }

    @Override
    public void addJButtonMonitor(JButton jButton) {
        jButton.addActionListener(e -> {
            multiply();
            OperateJPanelFactory.startCCleanJButton();
        });
    }
}
