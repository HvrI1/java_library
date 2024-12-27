package com.ui;

import com.component.BackGroundPanel;
import com.utils.DBUtils;
import com.utils.ScreenUtils;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterInterface {
    JFrame jf = new JFrame("注册页面");

    final int  WIDTH = 500;
    final int HEIGHT = 300;
    public void init() throws IOException {
        jf.setBounds(ScreenUtils.getScreenW() - WIDTH / 2, (ScreenUtils.getScreenH() - HEIGHT) / 2, WIDTH, HEIGHT);
        jf.setResizable(false);

//        jf.setIconImage(ImageIO.read(new File("src/img/logo.png")));

        BackGroundPanel bgPanel = new BackGroundPanel(ImageIO.read(new File("src/img/library.jpg")));
        bgPanel.setBounds(0,0,WIDTH,HEIGHT);
        Box vBox = Box.createVerticalBox();
        //组装用户名
        Box uBox = Box.createHorizontalBox();
        JLabel uLable = new JLabel("用户名");
        uLable.setForeground(Color.CYAN);
        JTextField uField = new JTextField(15);

        uBox.add(uLable);
        uBox.add(Box.createHorizontalStrut(20));
        uBox.add(uField);

        Box pBox = Box.createHorizontalBox();
        JLabel pLable = new JLabel("    密码");
        pLable.setForeground(Color.CYAN);
        JTextField pField = new JTextField(15);

        uBox.add(pLable);
        uBox.add(Box.createHorizontalStrut(20));
        uBox.add(pField);
        Box btnBox = Box.createHorizontalBox();

        JButton registBtn = new JButton("注册");
        JButton loginBtn = new JButton("返回登录页面");

        registBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = uField.getText().trim();
                String password = pField.getText().trim();
                String sql = "INSERT INTO `user`(username,password)value('"+username+"','"+password+"')";
                try {
                    int i = DBUtils.update(DBUtils.getConnection(), sql);
                    if (i > 0){
                        JOptionPane.showMessageDialog(jf,"注册成功！即将返回登录页面");
                        new MainInterface().init();
                        jf.dispose();
                    }else {
                        JOptionPane.showMessageDialog(jf,"注册失败！！！！！！");
                    }
                } catch (SQLException | ClassNotFoundException | IOException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new MainInterface().init();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                jf.dispose();
            }
        });
        btnBox.add(registBtn);
        btnBox.add(Box.createHorizontalStrut(100));
        btnBox.add(loginBtn);


        vBox.add(Box.createVerticalStrut(50));
        vBox.add(uBox);
        vBox.add(Box.createVerticalStrut(20));
        vBox.add(pBox);
        vBox.add(Box.createVerticalStrut(40));
        vBox.add(btnBox);
        jf.setLocationRelativeTo(null); // 窗口居中
        bgPanel.add(vBox);
        jf.add(bgPanel);
        jf.setVisible(true);
    }



}
