package com.czh.calculator.dict;

import com.czh.calculator.monitor.base.AddJButtonMonitor;
import com.czh.calculator.monitor.function.CleanJButtonMonitor;
import com.czh.calculator.monitor.function.SwitchoverJButtonMonitor;
import com.czh.calculator.monitor.global.EqualSignJButtonMonitor;
import com.czh.calculator.monitor.global.OperateSymbolJButtonMonitor;
import com.czh.calculator.monitor.num_constant.OperateNumJButtonMonitor;
import com.czh.calculator.monitor.parent.Monitor;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : czh
 * @description : ComponentType 枚举
 * @email 916419307@qq.com
 */
public enum ComponentType {

    BASE_SHOW_TEXT("", "SHOW_TEXT", Color.YELLOW,
            290, 38, 5, 10, 0, null, JPanelType.BASE_SHOW),
    BASE_INPUT_TEXT("0", "INPUT_TEXT", Color.YELLOW,
            290, 38, 5, 52, 1, null, JPanelType.BASE_SHOW),
    BASE_SWITCHOVER("<html>转<br/>换</html>", "SWITCHOVER", Color.GREEN,
            90, 80, 305, 10, 2, SwitchoverJButtonMonitor.class, JPanelType.BASE_SHOW),

    BASE_CLEAN("AC", "CLEAN", Color.GREEN,
            90, 80, 5, 110, 0, CleanJButtonMonitor.class, JPanelType.BASE_OPERATE),
    BASE_OVERTURN("+/-", "NUM", Color.CYAN,
            90, 80, 105, 110, 1, OperateNumJButtonMonitor.class, JPanelType.BASE_OPERATE),
    BASE_PER_CENT("%", "OPERATION", Color.PINK,
            90, 80, 205, 110, 2, OperateSymbolJButtonMonitor.class, JPanelType.BASE_OPERATE),
    BASE_DIVISION("÷", "OPERATION", Color.PINK,
            90, 80, 305, 110, 3, OperateSymbolJButtonMonitor.class, JPanelType.BASE_OPERATE),

    BASE_SEVEN("7", "NUM", Color.CYAN,
            90, 80, 5, 210, 4, OperateNumJButtonMonitor.class, JPanelType.BASE_OPERATE),
    BASE_EIGHT("8", "NUM", Color.CYAN,
            90, 80, 105, 210, 5, OperateNumJButtonMonitor.class, JPanelType.BASE_OPERATE),
    BASE_NINE("9", "NUM", Color.CYAN,
            90, 80, 205, 210, 6, OperateNumJButtonMonitor.class, JPanelType.BASE_OPERATE),
    BASE_MULTIPLY("×", "OPERATION", Color.PINK,
            90, 80, 305, 210, 7, OperateSymbolJButtonMonitor.class, JPanelType.BASE_OPERATE),

    BASE_FOUR("4", "NUM", Color.CYAN,
            90, 80, 5, 310, 8, OperateNumJButtonMonitor.class, JPanelType.BASE_OPERATE),
    BASE_FIVE("5", "NUM", Color.CYAN,
            90, 80, 105, 310, 9, OperateNumJButtonMonitor.class, JPanelType.BASE_OPERATE),
    BASE_SIX("6", "NUM", Color.CYAN,
            90, 80, 205, 310, 10, OperateNumJButtonMonitor.class, JPanelType.BASE_OPERATE),
    BASE_SUBTRACT("-", "OPERATION", Color.PINK,
            90, 80, 305, 310, 11, OperateSymbolJButtonMonitor.class, JPanelType.BASE_OPERATE),

    BASE_ONE("1", "NUM", Color.CYAN,
            90, 80, 5, 410, 12, OperateNumJButtonMonitor.class, JPanelType.BASE_OPERATE),
    BASE_TWO("2", "NUM", Color.CYAN,
            90, 80, 105, 410, 13, OperateNumJButtonMonitor.class, JPanelType.BASE_OPERATE),
    BASE_THREE("3", "NUM", Color.CYAN,
            90, 80, 205, 410, 14, OperateNumJButtonMonitor.class, JPanelType.BASE_OPERATE),
    BASE_ADD("+", "OPERATION", Color.PINK,
            90, 80, 305, 410, 15, AddJButtonMonitor.class, JPanelType.BASE_OPERATE),

    BASE_ZERO("0", "NUM", Color.CYAN,
            90, 80, 5, 510, 16, OperateNumJButtonMonitor.class, JPanelType.BASE_OPERATE),
    BASE_TWO_ZERO("00", "NUM", Color.CYAN,
            90, 80, 105, 510, 17, OperateNumJButtonMonitor.class, JPanelType.BASE_OPERATE),
    BASE_POINT(".", "NUM", Color.CYAN,
            90, 80, 205, 510, 18, OperateNumJButtonMonitor.class, JPanelType.BASE_OPERATE),
    BASE_EQUALS("=", "OPERATION", Color.PINK,
            90, 80, 305, 510, 19, EqualSignJButtonMonitor.class, JPanelType.BASE_OPERATE),

    SCIENCE_SHOW_TEXT("", "SHOW_TEXT", Color.YELLOW,
            490, 38, 5, 10, 0, null, JPanelType.SCIENCE_SHOW),
    SCIENCE_INPUT_TEXT("0", "INPUT_TEXT", Color.YELLOW,
            490, 38, 5, 52, 1, null, JPanelType.SCIENCE_SHOW),
    SCIENCE_SWITCHOVER("<html>转<br/>换</html>", "SWITCHOVER", Color.GREEN,
            90, 80, 505, 10, 2, SwitchoverJButtonMonitor.class, JPanelType.SCIENCE_SHOW),

    SCIENCE_CLEAN("AC", "CLEAN", Color.GREEN,
            90, 80, 5, 110, 0, CleanJButtonMonitor.class, JPanelType.SCIENCE_OPERATE),
    SCIENCE_LOG10("Log10", "OPERATION", Color.PINK,
            90, 80, 105, 110, 1, OperateSymbolJButtonMonitor.class, JPanelType.SCIENCE_OPERATE),
    SCIENCE_FRACTIONAL("1/n", "OPERATION", Color.PINK,
            90, 80, 205, 110, 2, OperateSymbolJButtonMonitor.class, JPanelType.SCIENCE_OPERATE),
    SCIENCE_OVERTURN("+/-", "NUM", Color.CYAN,
            90, 80, 305, 110, 3, OperateNumJButtonMonitor.class, JPanelType.SCIENCE_OPERATE),
    SCIENCE_PER_CENT("%", "OPERATION", Color.PINK,
            90, 80, 405, 110, 4, OperateSymbolJButtonMonitor.class, JPanelType.SCIENCE_OPERATE),
    SCIENCE_DIVISION("÷", "OPERATION", Color.PINK,
            90, 80, 505, 110, 5, OperateSymbolJButtonMonitor.class, JPanelType.SCIENCE_OPERATE),

    SCIENCE_SIN("sin", "OPERATION", Color.PINK,
            90, 80, 5, 210, 6, OperateSymbolJButtonMonitor.class, JPanelType.SCIENCE_OPERATE),
    SCIENCE_POWER("x^y", "OPERATION", Color.PINK,
            90, 80, 105, 210, 7, OperateSymbolJButtonMonitor.class, JPanelType.SCIENCE_OPERATE),
    SCIENCE_SEVEN("7", "NUM", Color.CYAN,
            90, 80, 205, 210, 8, OperateNumJButtonMonitor.class, JPanelType.SCIENCE_OPERATE),
    SCIENCE_EIGHT("8", "NUM", Color.CYAN,
            90, 80, 305, 210, 9, OperateNumJButtonMonitor.class, JPanelType.SCIENCE_OPERATE),
    SCIENCE_NINE("9", "NUM", Color.CYAN,
            90, 80, 405, 210, 10, OperateNumJButtonMonitor.class, JPanelType.SCIENCE_OPERATE),
    SCIENCE_MULTIPLY("×", "OPERATION", Color.PINK,
            90, 80, 505, 210, 11, OperateSymbolJButtonMonitor.class, JPanelType.SCIENCE_OPERATE),

    SCIENCE_COS("cos", "OPERATION", Color.PINK,
            90, 80, 5, 310, 12, OperateSymbolJButtonMonitor.class, JPanelType.SCIENCE_OPERATE),
    SCIENCE_SIGN_EVOLUTION("y√x", "OPERATION", Color.PINK,
            90, 80, 105, 310, 13, OperateSymbolJButtonMonitor.class, JPanelType.SCIENCE_OPERATE),
    SCIENCE_FOUR("4", "NUM", Color.CYAN,
            90, 80, 205, 310, 14, OperateNumJButtonMonitor.class, JPanelType.SCIENCE_OPERATE),
    SCIENCE_FIVE("5", "NUM", Color.CYAN,
            90, 80, 305, 310, 15, OperateNumJButtonMonitor.class, JPanelType.SCIENCE_OPERATE),
    SCIENCE_SIX("6", "NUM", Color.CYAN,
            90, 80, 405, 310, 16, OperateNumJButtonMonitor.class, JPanelType.SCIENCE_OPERATE),
    SCIENCE_SUBTRACT("-", "OPERATION", Color.PINK,
            90, 80, 505, 310, 17, OperateSymbolJButtonMonitor.class, JPanelType.SCIENCE_OPERATE),

    SCIENCE_TAN("tan", "OPERATION", Color.PINK,
            90, 80, 5, 410, 18, OperateSymbolJButtonMonitor.class, JPanelType.SCIENCE_OPERATE),
    SCIENCE_FACTORIAL("x!", "OPERATION", Color.PINK,
            90, 80, 105, 410, 19, OperateSymbolJButtonMonitor.class, JPanelType.SCIENCE_OPERATE),
    SCIENCE_ONE("1", "NUM", Color.CYAN,
            90, 80, 205, 410, 20, OperateNumJButtonMonitor.class, JPanelType.SCIENCE_OPERATE),
    SCIENCE_TWO("2", "NUM", Color.CYAN,
            90, 80, 305, 410, 21, OperateNumJButtonMonitor.class, JPanelType.SCIENCE_OPERATE),
    SCIENCE_THREE("3", "NUM", Color.CYAN,
            90, 80, 405, 410, 22, OperateNumJButtonMonitor.class, JPanelType.SCIENCE_OPERATE),
    SCIENCE_ADD("+", "OPERATION", Color.PINK,
            90, 80, 505, 410, 23, AddJButtonMonitor.class, JPanelType.SCIENCE_OPERATE),

    SCIENCE_E("e", "OPERATION", Color.CYAN,
            90, 80, 5, 510, 24, OperateSymbolJButtonMonitor.class, JPanelType.SCIENCE_OPERATE),
    SCIENCE_PAI("π", "OPERATION", Color.CYAN,
            90, 80, 105, 510, 25, OperateSymbolJButtonMonitor.class, JPanelType.SCIENCE_OPERATE),
    SCIENCE_ZERO("0", "NUM", Color.CYAN,
            90, 80, 205, 510, 26, OperateNumJButtonMonitor.class, JPanelType.SCIENCE_OPERATE),
    SCIENCE_TWO_ZERO("00", "NUM", Color.CYAN,
            90, 80, 305, 510, 27, OperateNumJButtonMonitor.class, JPanelType.SCIENCE_OPERATE),
    SCIENCE_POINT(".", "NUM", Color.CYAN,
            90, 80, 405, 510, 28, OperateNumJButtonMonitor.class, JPanelType.SCIENCE_OPERATE),
    SCIENCE_EQUALS("=", "OPERATION", Color.PINK,
            90, 80, 505, 510, 29, EqualSignJButtonMonitor.class, JPanelType.SCIENCE_OPERATE),

    SCIENCE_EXACT_DIVISION("整除", "OPERATION", Color.PINK,
            90, 80, 5, 610, 30, OperateSymbolJButtonMonitor.class, JPanelType.SCIENCE_OPERATE),
    SCIENCE_REMAINDER("取余", "OPERATION", Color.PINK,
            90, 80, 105, 610, 31, OperateSymbolJButtonMonitor.class, JPanelType.SCIENCE_OPERATE),
    SCIENCE_PRIME_NUM("质数", "OPERATION", Color.PINK,
            90, 80, 205, 610, 32, OperateSymbolJButtonMonitor.class, JPanelType.SCIENCE_OPERATE),
    SCIENCE_RESERVED1("预留1", "RESERVED", Color.gray,
            90, 80, 305, 610, 33, null, JPanelType.SCIENCE_OPERATE),
    SCIENCE_RESERVED2("预留2", "RESERVED", Color.gray,
            90, 80, 405, 610, 34, null, JPanelType.SCIENCE_OPERATE),
    SCIENCE_RESERVED3("预留3", "RESERVED", Color.gray,
            90, 80, 505, 610, 35, null, JPanelType.SCIENCE_OPERATE),

    // 扩展位
    ;

    public final String show;
    public final String operate;
    public final Color color;
    public final int width;
    public final int height;
    public final int x;
    public final int y;
    public final int index;
    public final Class<? extends Monitor> monitorClazz;
    public final JPanelType parent;

    ComponentType(String show,
                  String operate,
                  Color color,
                  int width,
                  int height,
                  int x, int y, int index, Class<? extends Monitor> monitorClazz, JPanelType parent) {
        this.show = show;
        this.operate = operate;
        this.color = color;
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.index = index;
        this.monitorClazz = monitorClazz;
        this.parent = parent;
    }

    public static List<ComponentType> queryByParent(JPanelType jPanelType) {
        if (jPanelType == null) {
            throw new RuntimeException("参数必填");
        }
        List<ComponentType> componentTypeList = new ArrayList<>();
        ComponentType[] componentTypes = ComponentType.values();
        for (ComponentType componentType : componentTypes) {
            if (componentType.parent.equals(jPanelType)) {
                componentTypeList.add(componentType);
            }
        }
        if (componentTypeList.size() == 0) {
            throw new RuntimeException("找不到符合条件的枚举");
        }
        return componentTypeList;
    }

    public static ComponentType getByParentAndOperate(JPanelType jPanelType, String operate) {
        if (jPanelType == null || operate == null) {
            throw new RuntimeException("参数必填");
        }
        ComponentType[] componentTypes = ComponentType.values();
        for (ComponentType componentType : componentTypes) {
            if (componentType.parent.equals(jPanelType) && componentType.operate.equals(operate)) {
                return componentType;
            }
        }
        throw new RuntimeException("找不到符合条件的枚举");
    }

    public static ComponentType getByParentAndShow(JPanelType jPanelType, String show) {
        if (jPanelType == null || show == null) {
            throw new RuntimeException("参数必填");
        }
        ComponentType[] componentTypes = ComponentType.values();
        for (ComponentType componentType : componentTypes) {
            if (componentType.parent.equals(jPanelType) && componentType.show.equals(show)) {
                return componentType;
            }
        }
        throw new RuntimeException("找不到符合条件的枚举");
    }
}
