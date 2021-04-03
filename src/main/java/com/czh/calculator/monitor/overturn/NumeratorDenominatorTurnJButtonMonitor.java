package com.czh.calculator.monitor.overturn;

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
 * @description : 1/n 监听器
 * @email 916419307@qq.com
 */
public class NumeratorDenominatorTurnJButtonMonitor implements JButtonMonitor {

    public static void numeratorDenominatorTurn() {
        BigDecimal result = CurrentField.getResult();
        String input = CurrentField.getInput();
        String operate = CurrentField.getOperate();

        if (result == null) {
            if (input != null) {
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
                    numeratorDenominatorTurn();
                    return;
                }
            }
        }

        if (result == null || result.compareTo(BigDecimal.ZERO) == 0) {
            throw new CalculatorException("1/n运算错误：0不能做分母进行该运算", "1 / 0 = ");
        }

        CurrentField.setResult(BigDecimal.ONE.divide(result, 12, RoundingMode.HALF_DOWN).stripTrailingZeros());
        CurrentField.setInput(null);
        CurrentField.setOperate(null);

        ShowJPanelFactory.getShowJTextField().setText(1 + " / " + result.toPlainString() + " = ");
        ShowJPanelFactory.getInputJTextField().setText(CurrentField.getResult().toPlainString());
    }

    @Override
    public void addJButtonMonitor(JButton jButton) {
        jButton.addActionListener(e -> {
            numeratorDenominatorTurn();
            OperateJPanelFactory.startCCleanJButton();
        });
    }
}
