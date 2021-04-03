package com.czh.calculator.layout;

import com.czh.calculator.CurrentField;
import com.czh.calculator.dict.CalculatorType;
import com.czh.calculator.dict.JFrameType;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 * @author : czh
 * @description : JFrameFactory 实例
 * @email 916419307@qq.com
 */
public class JFrameFactory {

    // 计算器窗口组件
    private static JFrame calculatorJFrame;

    public static JFrame build() {
        CalculatorType calculatorType = CurrentField.get();
        JFrameType jFrameType = JFrameType.getByParent(calculatorType);

        if (calculatorJFrame == null) {
            calculatorJFrame = new JFrame(calculatorType.title);
        } else {
            calculatorJFrame.setTitle(calculatorType.title);
        }
        // 大小
        calculatorJFrame.setSize(jFrameType.width, jFrameType.height);
        // 禁止放大
        calculatorJFrame.setResizable(false);
        // 相对于桌面位置
        calculatorJFrame.setLocation(jFrameType.x, jFrameType.y);
        // 关闭按钮作用
        calculatorJFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        return calculatorJFrame;
    }

    public static JFrame getCalculatorJFrame() {
        return calculatorJFrame;
    }
}
