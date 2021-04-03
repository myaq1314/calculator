package com.czh.calculator.monitor.global;

import com.czh.calculator.CurrentField;
import com.czh.calculator.exceptions.CalculatorException;
import com.czh.calculator.layout.OperateJPanelFactory;
import com.czh.calculator.layout.ShowJPanelFactory;
import com.czh.calculator.monitor.parent.JButtonMonitor;

import javax.swing.JButton;
import java.math.BigDecimal;

/**
 * @author : czh
 * @description : 等号 监听器
 * @email 916419307@qq.com
 */
public class EqualSignJButtonMonitor implements JButtonMonitor {

    public static void equalSign() {
        BigDecimal result = CurrentField.getResult();
        String input = CurrentField.getInput();
        String operate = CurrentField.getOperate();

        if (operate == null) {
            if (result == null) {
                if (input == null) {
                    result = BigDecimal.ZERO;
                } else {
                    result = new BigDecimal(input);
                }
            } else {
                if (input != null) {
                    result = new BigDecimal(input);
                }
            }

            CurrentField.setResult(result.stripTrailingZeros());
            CurrentField.setInput(null);
            CurrentField.setOperate(null);

            ShowJPanelFactory.getShowJTextField().setText(CurrentField.getResult().toPlainString() + " = ");
            ShowJPanelFactory.getInputJTextField().setText(CurrentField.getResult().toPlainString());
            return;
        }
        if (input == null) {
            if (result == null) {
                result = BigDecimal.ZERO;
            }
            CurrentField.setResult(result.stripTrailingZeros());
            CurrentField.setInput(null);
            CurrentField.setOperate(null);

            ShowJPanelFactory.getShowJTextField().setText(CurrentField.getResult().toPlainString() + " = ");
            ShowJPanelFactory.getInputJTextField().setText(CurrentField.getResult().toPlainString());
            return;
        }

        BigDecimal temp = new BigDecimal(input);
        try {
            OperateSymbolJButtonMonitor.setSymbol(operate);
            CurrentField.setInput(null);
            CurrentField.setOperate(null);
            ShowJPanelFactory.getInputJTextField().setText(CurrentField.getResult().toPlainString());
        } catch (CalculatorException ce) {
            CurrentField.setError(ce.getInput(), ce.getShow());
        } finally {
            if ("y√x".equals(operate)) {
                ShowJPanelFactory.getShowJTextField().setText(temp.toPlainString() + " √ " + result.toPlainString() + " = ");
            } else if ("x^y".equals(operate)) {
                ShowJPanelFactory.getShowJTextField().setText(result.toPlainString() + " ^ " + temp.toPlainString() + " = ");
            } else {
                ShowJPanelFactory.getShowJTextField().setText(result.toPlainString() + " " + operate + " " + temp.toPlainString() + " = ");

            }
        }
    }

    @Override
    public void addJButtonMonitor(JButton jButton) {
        jButton.addActionListener(e -> {
            try {
                equalSign();
            } catch (CalculatorException ce) {
                CurrentField.setError(ce.getInput(), ce.getShow());
            }
            OperateJPanelFactory.startCCleanJButton();
        });
    }
}
