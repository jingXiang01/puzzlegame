package com.ui;

import javax.swing.*;

public class RegisterJFrame extends JFrame {
    //注册相关
    public RegisterJFrame(){
        this.setSize(488,500);
        //设置界面标题
        this.setTitle("拼图注册");
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
