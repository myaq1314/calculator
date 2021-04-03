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
 * @description : 根号 监听器
 * @email 916419307@qq.com
 */
public class SignEvolutionJButtonMonitor implements JButtonMonitor {

    public static void signEvolution() {
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
                } else if ("y√x".equals(operate)) {
                    temp = new BigDecimal(input);
                } else {
                    OperateSymbolJButtonMonitor.setSymbol(operate);
                    CurrentField.setInput(null);
                    CurrentField.setOperate("y√x");
                    return;
                }
            }
        }

        if (temp == null) {
            CurrentField.setResult(result.stripTrailingZeros());
            CurrentField.setInput(null);
            CurrentField.setOperate("y√x");

            ShowJPanelFactory.getShowJTextField().setText("y√" + CurrentField.getResult().toPlainString());
            ShowJPanelFactory.getInputJTextField().setText("");
        } else if (temp.compareTo(BigDecimal.ZERO) == 0) {
            if (result.compareTo(BigDecimal.ZERO) < 0) {
                throw new CalculatorException("根号运算错误：负数 不能对 0 开跟", result.stripTrailingZeros().toPlainString() + "√" + temp.stripTrailingZeros().toPlainString() + " ：");
            }
            CurrentField.setResult(BigDecimal.ZERO);
            CurrentField.setInput(null);
            CurrentField.setOperate("y√x");

            ShowJPanelFactory.getShowJTextField().setText("y√" + CurrentField.getResult().toPlainString());
            ShowJPanelFactory.getInputJTextField().setText("");
        } else {
            temp = BigDecimal.ONE.divide(temp, 12, RoundingMode.HALF_DOWN);
            double pow = Math.pow(result.doubleValue(), temp.doubleValue());
            if ("Infinity".equals(String.valueOf(pow))) {
                throw new CalculatorException("无穷大", temp.stripTrailingZeros().toPlainString() + "√" + result.stripTrailingZeros().toPlainString());
            } else if ("NaN".equals(String.valueOf(pow))) {
                throw new CalculatorException("根号运算错误：不是数字", temp.stripTrailingZeros().toPlainString() + "√" + result.stripTrailingZeros().toPlainString());
            }

            CurrentField.setResult(new BigDecimal(String.valueOf(pow)).stripTrailingZeros());
            CurrentField.setInput(null);
            CurrentField.setOperate("y√x");

            ShowJPanelFactory.getShowJTextField().setText("y√" + CurrentField.getResult().toPlainString());
            ShowJPanelFactory.getInputJTextField().setText("");
        }

    }

    @Override
    public void addJButtonMonitor(JButton jButton) {
        jButton.addActionListener(e -> {
            signEvolution();
            OperateJPanelFactory.startCCleanJButton();
        });
    }
}

