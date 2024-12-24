package com.lm.service;

import com.lm.mapper.SelectMapper;
import com.lm.pojo.Book;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.util.ArrayList;
import java.util.Vector;

public class UserFrameService extends JFrame {


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



        //借阅按钮
        JButton borrowBtn = new JButton("借阅");
        borrowBtn.setBounds(515,10,75,50);
        borrowBtn.setFont(new Font("宋体",Font.BOLD,18));
        contentPane.add(borrowBtn);

        //归还按钮
        JButton backBtn = new JButton("归还");
        backBtn.setBounds(600,10,75,50);
        backBtn.setFont(new Font("宋体",Font.BOLD,18));
        contentPane.add(backBtn);

        //返回按钮
        JButton quitBtn = new JButton("返回");
        quitBtn.setBounds(685,10,75,50);
        quitBtn.setFont(new Font("宋体",Font.BOLD,18));
        contentPane.add(quitBtn);
        quitBtn.addActionListener(e -> {this.dispose();new InitService().init();});

        //表格框
        //表格的列名
        JTextField jTextField_name = new JTextField("书名");
        jTextField_name.setBounds(10,80,190,25);
        contentPane.add(jTextField_name);
        JTextField jTextField_price = new JTextField("价格");
        jTextField_price.setBounds(200,80,190,25);
        contentPane.add(jTextField_price);
        JTextField jTextField_type = new JTextField("类型");
        jTextField_type.setBounds(390,80,190,25);
        contentPane.add(jTextField_type);
        JTextField jTextField_status = new JTextField("状态");
        jTextField_status.setBounds(580,80,190,25);
        contentPane.add(jTextField_status);


        Vector coVector = new Vector();
        Vector dataVector = new Vector();
        DefaultTableModel tableModel;
        JScrollPane pane;

        coVector.add("name");
        coVector.add("price");
        coVector.add("type");
        coVector.add("status");


        SelectMapper selectMapper = new SelectMapper();
        ArrayList<Book> books = selectMapper.selectAllBook();
        for(Book book : books){
            Vector data = new Vector();
            data.add(book.getName());
            data.add(book.getPrice());
            data.add(book.getType());
            data.add(book.getStatus());
            dataVector.add(data);
            System.out.println(dataVector);
        }
        tableModel = new DefaultTableModel(dataVector,coVector);
        JTable table = new JTable(tableModel);
        table.setRowHeight(25);
        table.setBounds(10,100,760,600);
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


