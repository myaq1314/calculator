package com.czh.calculator.monitor.parent;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : czh
 * @description : 监听器 实例
 * @email 916419307@qq.com
 */
public class MonitorInstance {

    private static final Map<Class<? extends Monitor>, Monitor> monitorMap = new HashMap<>();

    public static Monitor getInstance(Class<? extends Monitor> eClazz) {
        try {
            if (monitorMap.get(eClazz) == null) {
                monitorMap.put(eClazz, eClazz.newInstance());
            }
            return monitorMap.get(eClazz);
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException("获取监听器失败");
        }
    }
}
