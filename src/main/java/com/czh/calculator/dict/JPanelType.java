package com.czh.calculator.dict;

/**
 * @author : czh
 * @description : JPanelType 枚举
 * @email 916419307@qq.com
 */
public enum JPanelType {

    BASE_SHOW(400, 100, 0, 0, 0, JFrameType.BASE, "SHOW"),
    BASE_OPERATE(400, 500, 0, 100, 1, JFrameType.BASE, "OPERATE"),
    SCIENCE_SHOW(600, 100, 0, 0, 0, JFrameType.SCIENCE, "SHOW"),
    SCIENCE_OPERATE(600, 600, 0, 100, 1, JFrameType.SCIENCE, "OPERATE"),

    // 扩展位
    ;

    public final int width;
    public final int height;
    public final int x;
    public final int y;
    public final int index;
    public final JFrameType parent;
    public final String operate;

    JPanelType(int width,
               int height,
               int x,
               int y,
               int index,
               JFrameType parent,
               String operate) {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.index = index;
        this.parent = parent;
        this.operate = operate;
    }

    public static JPanelType getByParentAndOperate(JFrameType jFrameType, String operate) {
        if (jFrameType == null || operate == null) {
            throw new RuntimeException("参数必填");
        }

        JPanelType[] jPanelTypes = JPanelType.values();
        for (JPanelType jPanelType : jPanelTypes) {
            if (jPanelType.parent.equals(jFrameType) && jPanelType.operate.equals(operate)) {
                return jPanelType;
            }
        }
        throw new RuntimeException("找不到符合条件的枚举");
    }
}
