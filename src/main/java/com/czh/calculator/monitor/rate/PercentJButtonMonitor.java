package com.czh.calculator.monitor.rate;

import com.czh.calculator.CurrentField;
import com.czh.calculator.layout.OperateJPanelFactory;
import com.czh.calculator.layout.ShowJPanelFactory;
import com.czh.calculator.monitor.global.OperateSymbolJButtonMonitor;
import com.czh.calculator.monitor.parent.JButtonMonitor;

import javax.swing.JButton;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author : czh
 * @description : 百分号 监听器
 * @email 916419307@qq.com
 */
public class PercentJButtonMonitor implements JButtonMonitor {

    public static void percent() {
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
                    CurrentField.setInput(null);
                    CurrentField.setOperate(null);
                    percent();
                    return;
                }
            }
        }

        CurrentField.setResult(result.divide(new BigDecimal(100), 12, RoundingMode.HALF_DOWN).stripTrailingZeros());
        CurrentField.setInput(null);
        CurrentField.setOperate(null);

        ShowJPanelFactory.getShowJTextField().setText(result.toPlainString() + " % = ");
        ShowJPanelFactory.getInputJTextField().setText(CurrentField.getResult().toPlainString());
    }

    @Override
    public void addJButtonMonitor(JButton jButton) {
        jButton.addActionListener(e -> {
            percent();
            OperateJPanelFactory.startCCleanJButton();
        });
    }
}
