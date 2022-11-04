package com.ui;

import javax.swing.*;

public class LoginJFrame extends JFrame {

    public LoginJFrame(){
        this.setSize(488,430);
        //设置界面标题
        this.setTitle("拼图登录");
        //设置界面置顶
        this.setAlwaysOnTop(true);
        //设置界面剧中
        this.setLocationRelativeTo(null);
        //设置关闭模式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //让显示出来，写在最后
        this.setVisible(true);
    }
}
