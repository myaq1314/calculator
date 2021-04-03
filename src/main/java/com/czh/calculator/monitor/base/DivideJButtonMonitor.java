package com.czh.calculator.monitor.base;

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
 * @description : 除号 监听器
 * @email 916419307@qq.com
 */
public class DivideJButtonMonitor implements JButtonMonitor {

    public static void divide() {
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
                } else if ("÷".equals(operate)) {
                    BigDecimal inputNum = new BigDecimal(input);
                    if (BigDecimal.ZERO.compareTo(inputNum) == 0) {
                        throw new CalculatorException("除法运算错误：被除数不能为0", result.stripTrailingZeros().toPlainString() + " ÷ 0 ");
                    } else {
                        result = result.divide(inputNum, 8, RoundingMode.HALF_DOWN);
                    }
                } else {
                    OperateSymbolJButtonMonitor.setSymbol(operate);
                    CurrentField.setInput(null);
                    CurrentField.setOperate("÷");
                    divide();
                    return;
                }
            }
        }
        CurrentField.setResult(result.stripTrailingZeros());
        CurrentField.setInput(null);
        CurrentField.setOperate("÷");

        ShowJPanelFactory.getShowJTextField().setText(CurrentField.getResult().toPlainString() + " ÷ ");
        ShowJPanelFactory.getInputJTextField().setText("");
    }

    @Override
    public void addJButtonMonitor(JButton jButton) {
        jButton.addActionListener(e -> {
            divide();
            OperateJPanelFactory.startCCleanJButton();
        });
    }
}
