package com.czh.calculator.monitor.global;

import com.czh.calculator.monitor.num_constant.OperateNumJButtonMonitor;
import com.czh.calculator.monitor.parent.Monitor;

import java.awt.AWTEvent;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : czh
 * @description : 窗口组件 监听器
 * @email 916419307@qq.com
 */
public class JFrameMonitor implements Monitor {

    @Override
    public void addMonitor(Object obj) {
        String s = "1234567890.";
        char[] chars = s.toCharArray();
        List<Character> charList = new ArrayList<>(chars.length);
        for (char aChar : chars) {
            charList.add(aChar);
        }

        Toolkit.getDefaultToolkit().addAWTEventListener(event -> {
            if (event.getID() == KeyEvent.KEY_PRESSED) {
                char keyChar = ((KeyEvent) event).getKeyChar();
                if (charList.contains(keyChar)) {
                    OperateNumJButtonMonitor.setNum(String.valueOf(keyChar));
                }
            }
        }, AWTEvent.KEY_EVENT_MASK);
    }
}
