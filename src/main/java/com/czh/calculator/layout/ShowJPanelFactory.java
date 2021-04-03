package com.czh.calculator.layout;

import com.czh.calculator.CurrentField;
import com.czh.calculator.dict.CalculatorType;
import com.czh.calculator.dict.ComponentType;
import com.czh.calculator.dict.JFrameType;
import com.czh.calculator.dict.JPanelType;
import com.czh.calculator.monitor.parent.MonitorInstance;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

/**
 * @author : czh
 * @description : ShowJPanelFactory 实例
 * @email 916419307@qq.com
 */
public class ShowJPanelFactory {

    private static JPanel showJPanel;
    private static JPanelType showJPanelType;
    private static JTextField showJTextField;
    private static JTextField inputJTextField;

    public static JPanel build() {
        CalculatorType calculatorType = CurrentField.get();
        JFrameType jFrameType = JFrameType.getByParent(calculatorType);
        showJPanelType = JPanelType.getByParentAndOperate(jFrameType, "SHOW");
        ComponentType showTextType = ComponentType.getByParentAndOperate(showJPanelType, "SHOW_TEXT");
        ComponentType inputTextType = ComponentType.getByParentAndOperate(showJPanelType, "INPUT_TEXT");
        ComponentType switchoverJButtonType = ComponentType.getByParentAndOperate(showJPanelType, "SWITCHOVER");

        if (showJPanel == null) {
            showJPanel = new JPanel();
        } else {
            Component[] components = showJPanel.getComponents();
            for (Component component : components) {
                showJPanel.remove(component);
            }
        }
        showJPanel.setLayout(null);
        showJPanel.setSize(showJPanelType.width, showJPanelType.height);
        showJPanel.setLocation(showJPanelType.x, showJPanelType.y);
        showJPanel.setBackground(Color.WHITE);

        showJTextField = new JTextField();
        showJTextField.setSize(showTextType.width, showTextType.height);
        showJTextField.setLocation(showTextType.x, showTextType.y);
        showJTextField.setHorizontalAlignment(JTextField.RIGHT);
        showJTextField.setEditable(false);
        showJTextField.setText(showTextType.show);
        showJTextField.setFont(new Font("楷体", Font.BOLD, 20));
        showJTextField.setBackground(showTextType.color);
        showJPanel.add(showJTextField, showTextType.index);

        inputJTextField = new JTextField();
        inputJTextField.setSize(inputTextType.width, inputTextType.height);
        inputJTextField.setLocation(inputTextType.x, inputTextType.y);
        inputJTextField.setHorizontalAlignment(JTextField.RIGHT);
        inputJTextField.setEditable(false);
        inputJTextField.setText(inputTextType.show);
        inputJTextField.setFont(new Font("楷体", Font.BOLD, 20));
        inputJTextField.setBackground(inputTextType.color);
        showJPanel.add(inputJTextField, inputTextType.index);

        JButton switchoverJButton = new JButton(switchoverJButtonType.show);
        switchoverJButton.setOpaque(true);
        switchoverJButton.setBorderPainted(false);
        switchoverJButton.setBackground(switchoverJButtonType.color);
        switchoverJButton.setFont(new Font("楷体", Font.BOLD, 20));
        switchoverJButton.setSize(switchoverJButtonType.width, switchoverJButtonType.height);
        switchoverJButton.setLocation(switchoverJButtonType.x, switchoverJButtonType.y);
        switchoverJButton.setHorizontalAlignment(JButton.CENTER);
        if (switchoverJButtonType.monitorClazz != null) {
            MonitorInstance.getInstance(switchoverJButtonType.monitorClazz).addMonitor(switchoverJButton);
        }
        showJPanel.add(switchoverJButton, switchoverJButtonType.index);

        return showJPanel;
    }

    public static JPanelType getShowJPanelType() {
        return showJPanelType;
    }

    public static JTextField getShowJTextField() {
        return showJTextField;
    }

    public static JTextField getInputJTextField() {
        return inputJTextField;
    }
}
