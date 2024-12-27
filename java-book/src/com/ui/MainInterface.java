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
import java.sql.*;

public class MainInterface {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/library_wangming?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";


    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "root";
    static final String PASS = "123456";

    JFrame jf = new JFrame("王明图书管理系统");

    final int  WIDTH = 500;
    final int HEIGHT = 300;

    public void init() throws IOException {
        jf.setBounds(ScreenUtils.getScreenW()-WIDTH/2,(ScreenUtils.getScreenH()-HEIGHT)/2,WIDTH,HEIGHT);
        jf.setResizable(false);

//        jf.setIconImage(ImageIO.read(new File("src/img/logo.png")));

        BackGroundPanel bgPanel = new BackGroundPanel(ImageIO.read(new File("src/img/library.jpg")));

        Box vBox = Box.createVerticalBox();
        //组装用户名
        Box uBox = Box.createHorizontalBox();
        JLabel uLable = new JLabel("用户名");
        uLable.setForeground(Color.BLACK);
        JTextField uField = new JTextField(15);

        uBox.add(uLable);
        uBox.add(Box.createHorizontalStrut(20));
        uBox.add(uField);

        Box pBox = Box.createHorizontalBox();
        JLabel pLable = new JLabel("    密码");
        pLable.setForeground(Color.BLACK);
        JTextField pField = new JTextField(15);

        uBox.add(pLable);
        uBox.add(Box.createHorizontalStrut(20));
        uBox.add(pField);
        Box btnBox = Box.createHorizontalBox();
        JButton loginBtn = new JButton("管理员登录");
        JButton userLoginBtn = new JButton("登录");
        JButton registBtn = new JButton("注册");

        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = uField.getText().trim();
                String password = pField.getText().trim();
                String sql = "select * from user where username = '"+username+"' and password = '"+password+"' and statm = 1";
                try {
                    ResultSet query = DBUtils.query(DBUtils.getConnection(), sql);
                    if (query.next()){
                        JOptionPane.showMessageDialog(jf,"登录成功！");
                        new ManagerInterfacs().init();
                        jf.dispose();
                    }else {
                        JOptionPane.showMessageDialog(jf,"用户名或密码错误！");
                    }
                } catch (SQLException | ClassNotFoundException | IOException throwables) {
                    throwables.printStackTrace();
                }
            }
        });

        userLoginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = uField.getText().trim();
                String password = pField.getText().trim();
                String sql = "select * from user where username = '"+username+"' and password = '"+password+"' and statm = 0";
                try {
                    ResultSet query = DBUtils.query(DBUtils.getConnection(), sql);
                    if (query.next()){
                        JOptionPane.showMessageDialog(jf,"登录成功！");
                        new UserManagerInterfacs().init(username);
                        jf.dispose();
                    }else {
                        JOptionPane.showMessageDialog(jf,"用户名或密码错误！");
                    }
                } catch (SQLException | ClassNotFoundException | IOException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        registBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //JOptionPane.showMessageDialog(jf,"注册成功！即将返回登录页面");
                try {
                    new RegisterInterface().init();
                    jf.dispose();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });

        btnBox.add(loginBtn);
        btnBox.add(Box.createHorizontalStrut(100));
        btnBox.add(userLoginBtn);
        btnBox.add(Box.createHorizontalStrut(100));
        btnBox.add(registBtn);

        vBox.add(Box.createVerticalStrut(50));
        vBox.add(uBox);
        vBox.add(Box.createVerticalStrut(20));
        vBox.add(pBox);
        vBox.add(Box.createVerticalStrut(40));
        vBox.add(btnBox);

        jf.setLocationRelativeTo(null); // 窗口居中
        //jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        bgPanel.add(vBox);
        jf.add(bgPanel);
        jf.setVisible(true);
    }

    public static void main(String[] args) {

        try {
            new MainInterface().init();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
