package com.czh.calculator.monitor.function;

import com.czh.calculator.CurrentField;
import com.czh.calculator.layout.ShowJPanelFactory;
import com.czh.calculator.monitor.parent.JButtonMonitor;

import javax.swing.JButton;

/**
 * @author : czh
 * @description : 清空 监听器
 * @email 916419307@qq.com
 */
public class CleanJButtonMonitor implements JButtonMonitor {

    private static boolean cleanFlag = true;

    public static void startAcCleanJButton(JButton cleanJButton) {
        CurrentField.setResult(null);
        CurrentField.setInput(null);
        CurrentField.setOperate(null);

        ShowJPanelFactory.getShowJTextField().setText("");
        ShowJPanelFactory.getInputJTextField().setText("0");

        cleanJButton.setText("AC");
        cleanFlag = true;
    }

    public static void startCCleanJButton(JButton cleanJButton) {
        if (cleanFlag) {
            cleanJButton.setText("C");
            cleanFlag = false;
        }
    }

    @Override
    public void addJButtonMonitor(JButton jButton) {
        jButton.addActionListener(e -> startAcCleanJButton(jButton));
    }
}
