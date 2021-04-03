package com.czh.calculator.monitor.other;

import com.czh.calculator.CurrentField;
import com.czh.calculator.layout.OperateJPanelFactory;
import com.czh.calculator.layout.ShowJPanelFactory;
import com.czh.calculator.monitor.global.OperateSymbolJButtonMonitor;
import com.czh.calculator.monitor.parent.JButtonMonitor;
import com.czh.calculator.util.PrimeNumUtil;

import javax.swing.JButton;
import java.math.BigDecimal;

/**
 * @author : czh
 * @description : 质数 监听器
 * @email 916419307@qq.com
 */
public class PrimeNumJButtonMonitor implements JButtonMonitor {

    public static void primeNum() {
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
                    primeNum();
                    return;
                }
            }
        }

        String text = PrimeNumUtil.checkPrimeNum(result);

        CurrentField.setResult(null);
        CurrentField.setInput(null);
        CurrentField.setOperate(null);

        ShowJPanelFactory.getShowJTextField().setText("判断 " + result.toPlainString() + " 是不是质数：");
        ShowJPanelFactory.getInputJTextField().setText(text);
    }

    @Override
    public void addJButtonMonitor(JButton jButton) {
        jButton.addActionListener(e -> {
            primeNum();
            OperateJPanelFactory.startCCleanJButton();
        });
    }
}
