package com.czh.calculator.layout;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author : czh
 * @description : AssembleFactory 实例
 * @email 916419307@qq.com
 */
public class AssembleLayoutFactory {

    public static void assemble() {
        JFrame jFrame = JFrameFactory.build();
        JPanel showJPanel = ShowJPanelFactory.build();
        JPanel operateJPanel = OperateJPanelFactory.build();

        jFrame.add(showJPanel, ShowJPanelFactory.getShowJPanelType().index);
        jFrame.add(operateJPanel, OperateJPanelFactory.getOperateJPanelType().index);
    }
}
