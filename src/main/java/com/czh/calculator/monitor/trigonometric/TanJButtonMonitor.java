package com.czh.calculator.monitor.trigonometric;

import com.czh.calculator.CurrentField;
import com.czh.calculator.layout.OperateJPanelFactory;
import com.czh.calculator.layout.ShowJPanelFactory;
import com.czh.calculator.monitor.global.OperateSymbolJButtonMonitor;
import com.czh.calculator.monitor.parent.JButtonMonitor;
import com.czh.calculator.util.TanUtil;

import javax.swing.JButton;
import java.math.BigDecimal;

/**
 * @author : czh
 * @description : TAN 监听器
 * @email 916419307@qq.com
 */
public class TanJButtonMonitor implements JButtonMonitor {

    public static void tan() {
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
                    tan();
                    return;
                }
            }
        }

        CurrentField.setResult(TanUtil.tan(result));
        CurrentField.setInput(null);
        CurrentField.setOperate(null);

        ShowJPanelFactory.getShowJTextField().setText("tan(" + result + ") = ");
        ShowJPanelFactory.getInputJTextField().setText(CurrentField.getResult().toPlainString());
    }

    @Override
    public void addJButtonMonitor(JButton jButton) {
        jButton.addActionListener(e -> {
            tan();
            OperateJPanelFactory.startCCleanJButton();
        });
    }
}