package com.czh.calculator.monitor.parent;

import javax.swing.JButton;

/**
 * @author : czh
 * @description : 按钮 监听器 接口
 * @email 916419307@qq.com
 */
public interface JButtonMonitor extends Monitor {

    default void addMonitor(Object obj) {
        assert obj != null;
        if (!(obj instanceof JButton)) {
            return;
        }
        addJButtonMonitor((JButton) obj);
    }

    void addJButtonMonitor(JButton jButton);

}
