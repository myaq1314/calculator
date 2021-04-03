package com.czh.calculator;

import com.czh.calculator.dict.CalculatorType;
import com.czh.calculator.layout.AssembleLayoutFactory;
import com.czh.calculator.layout.JFrameFactory;
import com.czh.calculator.monitor.global.JFrameMonitor;

/**
 * @author : czh
 * @description : Main 实例
 * @email 916419307@qq.com
 */
public class Main {

    public static void main(String[] args) {
        CurrentField.build(CalculatorType.BASE);
        AssembleLayoutFactory.assemble();
        // 添加键盘事件监听
        new JFrameMonitor().addMonitor(null);
        // 数据模型已经构造好了，允许JVM可以根据数据模型执行paint方法开始画图并显示到屏幕上了，
        // 并不是显示图形，而是可以运行开始画图了
        // 一般放到项目最后面
        JFrameFactory.getCalculatorJFrame().setVisible(true);
    }
}
