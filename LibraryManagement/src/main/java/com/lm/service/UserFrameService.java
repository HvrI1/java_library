package com.lm.service;

import com.lm.mapper.SelectMapper;
import com.lm.pojo.Book;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Vector;

public class UserFrameService extends JFrame {
    JTable table;

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
        selectBtn.addActionListener(e->{
            //获取文本框的内容
            String text = textField.getText();
            Book book =null;
//            Book book = null;
//            if(!text.equals(""))
            //查询指定name的书籍
            if(!text.equals("")) book = new SelectMapper().selectByNameBook(text);

                if (!text.equals("") && (text.equals(book.getName()))) {

                    //删除之前查询的全部数据
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    for (int i = 0; ; i++) {
                        //删除每一行数据
                        model.removeRow(0);
                        if (table.getRowCount() == 0) break;
                    }
                    //将查询到的数据添加到表格中
                    Vector coVector = new Vector();
                    Vector dataVector = new Vector();
                    DefaultTableModel tableModel;
                    JScrollPane pane;
                    coVector.add("name");
                    coVector.add("price");
                    coVector.add("type");
                    coVector.add("status");
                    Vector data = new Vector();
                    data.add(book.getName());
                    data.add(book.getPrice());
                    data.add(book.getType());
                    data.add(book.getStatus());
                    dataVector.add(data);
                    tableModel = new DefaultTableModel(dataVector, coVector);
                    table.setModel(tableModel);
                    contentPane.add(table);
                } else if (text.equals("")) {
                    //删除之前查询的全部数据
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    while (true) {
                        //删除每一行数据
                        model.removeRow(0);
                        System.out.println(1);
                        if (table.getRowCount() == 0) break;
                        System.out.println(2);
                    }

                    System.out.println(3);
                    table = new InitDateService().init(contentPane);
                    System.out.println(4);
                    contentPane.add(table);
                    System.out.println(5);
                } else {
                    JOptionPane.showMessageDialog(null, "请输入正确的书名", "错误", JOptionPane.ERROR_MESSAGE);
                }

        });






        //借阅按钮
        JButton borrowBtn = new JButton("借阅");
        borrowBtn.setBounds(515,10,75,50);
        borrowBtn.setFont(new Font("宋体",Font.BOLD,18));
        contentPane.add(borrowBtn);
        borrowBtn.addActionListener(e->{
            System.out.println(111111);
            table = new InitDateService().init(contentPane);
            contentPane.add(table);
        });



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
        table = new InitDateService().init(contentPane);
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


