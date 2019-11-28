package Interaction.wechatform;

import javax.swing.*;

/**
 * @program: classprogram
 * @Description:
 * @author: Mr Wu
 * @date: 2019/11/28 15:15
 */
public class WeChatForm extends JFrame {
    private JPanel panelMain;

    public WeChatForm(){
        setTitle("WeChat Form");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panelMain = new JPanel();
        panelMain.setLayout(null);

    }

    /**
     * @Description:设置主界面可见
     * @Param: [visible]
     * @return: void
     * @Author: Mr.Cheng
     * @Date: 2019/11/13 1:52 下午
     */
    public void setFrameWeChatVisible(Boolean visible){
        setVisible(visible);
    }
}
