package com.czh.calculator.monitor.num_constant;

import com.czh.calculator.CurrentField;
import com.czh.calculator.layout.OperateJPanelFactory;
import com.czh.calculator.layout.ShowJPanelFactory;
import com.czh.calculator.monitor.parent.JButtonMonitor;

import javax.swing.JButton;
import java.math.BigDecimal;

/**
 * @author : czh
 * @description : e实例 监听器
 * @email 916419307@qq.com
 */
public class EJButtonMonitor implements JButtonMonitor {

    public static void e() {
        BigDecimal result = new BigDecimal(String.valueOf(Math.E));

        CurrentField.setResult(result);
        CurrentField.setInput(null);
        CurrentField.setOperate(null);

        ShowJPanelFactory.getShowJTextField().setText("e = ");
        ShowJPanelFactory.getInputJTextField().setText(result.toPlainString());
    }

    @Override
    public void addJButtonMonitor(JButton jButton) {
        jButton.addActionListener(e -> {
            e();
            OperateJPanelFactory.startCCleanJButton();
        });
    }
}
