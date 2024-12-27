package com.lm.service;

import javax.swing.*;
import java.awt.*;

public class InitService extends JFrame{
    public void init(){
        //生成容器
        Container contentPane = this.getContentPane();
        contentPane.setLayout(null);

        //用户登录按钮
        JButton userBtn = new JButton("用户入口");
        userBtn.setBounds(300,450,200,100);
        userBtn.setFont(new Font("宋体",Font.BOLD,24));
        contentPane.add(userBtn);
        //给用户登录按钮添加点击跳转事件
        userBtn.addActionListener(e -> {this.dispose();new UserFrameService().init();});

        //管理员登录按钮
        JButton adminBtn = new JButton("管理员入口");
        adminBtn.setBounds(300,300,200,100);
        adminBtn.setFont(new Font("宋体",Font.BOLD,24));
        contentPane.add(adminBtn);
        adminBtn.addActionListener(e -> {this.dispose();new AdminFrameService().init();});

        //JF窗体的初始化一定要放在其他组件最后，否则组件会显示不全
        //设置标题
        JLabel titletLabel = new JLabel("图书管理系统欢迎您");
        titletLabel.setBounds(100,150,600,100);
        titletLabel.setFont(new Font("宋体",Font.BOLD,60));
        titletLabel.setForeground(Color.RED);
        contentPane.add(titletLabel);
        //设置背景图片
        String url = getClass().getResource("/images/background_img.jpg").getPath();
        JLabel imgLabel = new JLabel();
        ImageIcon imageIcon = new ImageIcon(url);
        imgLabel.setIcon(imageIcon);
        imgLabel.setBounds(0,0,800,800);
        imgLabel.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(imgLabel);
        this.setTitle("图书管理系统");
        this.setBounds(100,100,800,800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }




}
