package com.czh.calculator.layout;

import com.czh.calculator.CurrentField;
import com.czh.calculator.dict.CalculatorType;
import com.czh.calculator.dict.ComponentType;
import com.czh.calculator.dict.JFrameType;
import com.czh.calculator.dict.JPanelType;
import com.czh.calculator.monitor.function.CleanJButtonMonitor;
import com.czh.calculator.monitor.parent.MonitorInstance;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.List;

/**
 * @author : czh
 * @description : OperateJPanelFactory 实例
 * @email 916419307@qq.com
 */
public class OperateJPanelFactory {

    private static JPanel operateJPanel;
    private static JPanelType operateJPanelType;
    private static JButton cleanJButton;

    public static JPanel build() {
        CalculatorType calculatorType = CurrentField.get();
        JFrameType jFrameType = JFrameType.getByParent(calculatorType);
        operateJPanelType = JPanelType.getByParentAndOperate(jFrameType, "OPERATE");
        List<ComponentType> operateComponentTypeList = ComponentType.queryByParent(operateJPanelType);

        if (operateJPanel == null) {
            operateJPanel = new JPanel();
        } else {
            Component[] components = operateJPanel.getComponents();
            for (Component component : components) {
                operateJPanel.remove(component);
            }
        }
        operateJPanel.setLayout(null);
        operateJPanel.setSize(operateJPanelType.width, operateJPanelType.height);
        operateJPanel.setLocation(operateJPanelType.x, operateJPanelType.y);
        operateJPanel.setBackground(Color.WHITE);

        for (ComponentType componentType : operateComponentTypeList) {
            JButton operateJButton = new JButton(componentType.show);
            operateJButton.setOpaque(true);
            operateJButton.setBorderPainted(false);
            operateJButton.setBackground(componentType.color);
            operateJButton.setFont(new Font("楷体", Font.BOLD, 14));
            operateJButton.setSize(componentType.width, componentType.height);
            operateJButton.setLocation(componentType.x, componentType.y);
            if ("AC".equals(componentType.show)) {
                cleanJButton = operateJButton;
            }
            if (componentType.monitorClazz != null) {
                MonitorInstance.getInstance(componentType.monitorClazz).addMonitor(operateJButton);
            }
            operateJPanel.add(operateJButton, componentType.index);
        }

        return operateJPanel;
    }

    public static JPanelType getOperateJPanelType() {
        return operateJPanelType;
    }

    public static void startCCleanJButton() {
        CleanJButtonMonitor.startCCleanJButton(cleanJButton);
    }
}
