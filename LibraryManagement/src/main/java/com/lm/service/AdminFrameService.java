package com.lm.service;

import javax.swing.*;
import java.awt.*;

public class AdminFrameService extends JFrame{

    public void init(){
        //生成容器
        Container contentPane = this.getContentPane();
        contentPane.setLayout(null);

        //文本框
        JTextField textField = new JTextField();
        textField.setBounds(10,10,400,50);
        textField.setFont(new Font("宋体",Font.BOLD,24));
        contentPane.add(textField);



        //查询按钮
        JButton selectBtn = new JButton("查询");
        selectBtn.setBounds(430,10,75,50);
        selectBtn.setFont(new Font("宋体",Font.BOLD,18));
        contentPane.add(selectBtn);
        //给用户登录按钮添加点击跳转事件


        //借阅按钮
        JButton addBtn = new JButton("增加");
        addBtn.setBounds(515,10,75,50);
        addBtn.setFont(new Font("宋体",Font.BOLD,18));
        contentPane.add(addBtn);

        //归还按钮
        JButton deleteBtn = new JButton("删除");
        deleteBtn.setBounds(600,10,75,50);
        deleteBtn.setFont(new Font("宋体",Font.BOLD,18));
        contentPane.add(deleteBtn);

        //返回按钮
        JButton quitBtn = new JButton("返回");
        quitBtn.setBounds(685,10,75,50);
        quitBtn.setFont(new Font("宋体",Font.BOLD,18));
        contentPane.add(quitBtn);
        quitBtn.addActionListener(e -> {this.dispose();new InitService().init();});

        //表格框
        JTable table = new JTable();
        table.setBounds(10,70,760,680);
        contentPane.add(table);


        //JF窗体的初始化一定要放在其他组件最后，否则组件会显示不全
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
