package com.lm.service;

import com.lm.mapper.SelectMapper;
import com.lm.pojo.Book;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Vector;

public class InitDateService {
    public JTable init(Container contentPane){
        //表格框
        //表格的列名
        JTextField jTextField_name = new JTextField("书名");
        jTextField_name.setBounds(10,75,190,25);
        contentPane.add(jTextField_name);
        JTextField jTextField_price = new JTextField("价格");
        jTextField_price.setBounds(200,75,190,25);
        contentPane.add(jTextField_price);
        JTextField jTextField_type = new JTextField("类型");
        jTextField_type.setBounds(390,75,190,25);
        contentPane.add(jTextField_type);
        JTextField jTextField_status = new JTextField("状态");
        jTextField_status.setBounds(580,75,190,25);
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
        }
        tableModel = new DefaultTableModel(dataVector,coVector);
        JTable table = new JTable(tableModel);
        table.setRowHeight(25);
        table.setBounds(10,100,760,600);

        return table;
    }
}
