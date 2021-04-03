package com.czh.calculator.monitor.num_constant;

import com.czh.calculator.CurrentField;
import com.czh.calculator.layout.OperateJPanelFactory;
import com.czh.calculator.layout.ShowJPanelFactory;
import com.czh.calculator.monitor.parent.JButtonMonitor;

import javax.swing.JButton;
import java.math.BigDecimal;

/**
 * @author : czh
 * @description : 数值 监听器
 * @email 916419307@qq.com
 */
public class OperateNumJButtonMonitor implements JButtonMonitor {

    public static void setNum(String text) {
        String input = CurrentField.getInput();
        String operate = CurrentField.getOperate();

        if (input == null) { // 之前没有输入数值
            if ("+/-".equals(text)) { // 正负状态
                input = "-";
            } else if (".".equals(text)) { // 当前输入的是点
                input = "0.";
            } else { // 当前输入的不是点
                input = new BigDecimal(text).stripTrailingZeros().toPlainString();
            }
        } else { // 之前有输入数值
            if ("+/-".equals(text)) { // 正负状态
                if (input.startsWith("-")) {
                    input = input.substring(1);
                } else {
                    input = "-" + input;
                }
            } else if (input.contains(".")) { // 判断之前输入数值是小数
                if (!".".equals(text)) {
                    input += text;
                }
            } else { // 判断之前输入数值是整数
                if (".".equals(text)) { // 当前输入的是点
                    input += ".";
                } else {
                    input = new BigDecimal(input + text).stripTrailingZeros().toPlainString();
                }
            }
        }
        if (operate == null) {
            CurrentField.setResult(null);
            ShowJPanelFactory.getShowJTextField().setText("");
        }
        CurrentField.setInput(input);
        ShowJPanelFactory.getInputJTextField().setText(input);
    }

    @Override
    public void addJButtonMonitor(JButton jButton) {
        jButton.addActionListener(e -> {
            setNum(e.getActionCommand());
            OperateJPanelFactory.startCCleanJButton();
        });
    }
}
