package com.czh.calculator.monitor.function;

import com.czh.calculator.CurrentField;
import com.czh.calculator.dict.CalculatorType;
import com.czh.calculator.layout.AssembleLayoutFactory;
import com.czh.calculator.layout.JFrameFactory;
import com.czh.calculator.layout.OperateJPanelFactory;
import com.czh.calculator.monitor.parent.JButtonMonitor;

import javax.swing.JButton;

/**
 * @author : czh
 * @description : 转换 按钮 监听器
 * @email 916419307@qq.com
 */
public class SwitchoverJButtonMonitor implements JButtonMonitor {

    @Override
    public void addJButtonMonitor(JButton jButton) {
        jButton.addActionListener(e -> {
            // 计算下一阶段计算器类型
            CalculatorType calculatorType = CurrentField.get();
            CalculatorType nextCalculatorType = CalculatorType.getByIndex(calculatorType.next);
            CurrentField.build(nextCalculatorType);

            // 开始布局下一阶段计算器
            AssembleLayoutFactory.assemble();

            // 开始绘画下一阶段计算器
            JFrameFactory.getCalculatorJFrame().setVisible(true);

            // 触发清空按钮 清空原有缓存值
            OperateJPanelFactory.startCCleanJButton();
        });
    }
}
