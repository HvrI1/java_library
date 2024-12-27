package com.component;

import com.mysql.cj.xdevapi.Table;
import com.pojo.Book;
import com.utils.DBUtils;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.List;

public class UserManageComponent extends Box {

    final int WIDTH = 850;
    final int HEIGHT = 600;
    JFrame jf = null;

    private JTable table;
    private Vector<String> titles;
    private Vector<Vector> tableData;
    private TableModel tableModel;
    private Container ct;

    public UserManageComponent(JFrame jf) throws SQLException, ClassNotFoundException {

        super(BoxLayout.Y_AXIS);

        this.jf = jf;
        JPanel btnPanel = new JPanel();
        Color color = new Color(203,220,217);
        btnPanel.setBackground(color);
        btnPanel.setMaximumSize(new Dimension(WIDTH,80));
        btnPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        JButton addBtn = new JButton("添加");
        JButton updateBtn = new JButton("修改");
        JButton deleteBtn = new JButton("删除");

        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new AddBookDialog(jf,"添加图书",true).setVisible(true);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        updateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new UpdateBookDialog(jf,"修改图书",true).setVisible(true);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new DeleteBookDialog(jf,"删除图书",true).setVisible(true);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });

        btnPanel.add(addBtn);
        btnPanel.add(updateBtn);
        btnPanel.add(deleteBtn);
        this.add(btnPanel);

        String[] ts = {"编号","书名","作者","图书数量"};
        titles = new Vector<>();
        for (String title : ts){
            titles.add(title);
        }


        //tableData = new Vector<>();

        tableModel = new DefaultTableModel(tableData,titles);
        Object[][] data = requestData();

        table = new JTable(tableModel){
            @Override
            public boolean isCellEditable(int row,int column) {
                return false;
            }

            @Override
            public void setModel(TableModel dataModel) {
                super.setModel(new DefaultTableModel(data,ts));
            }
        };

        table = new JTable(data,ts);
        this.setSize(new Dimension(300,50));
        JScrollPane scrollPane = new JScrollPane(table);
        //字段居中
        DefaultTableCellRenderer render = new DefaultTableCellRenderer();
        render.setHorizontalAlignment(SwingConstants.CENTER);
        table.setDefaultRenderer(Object.class, render);

        //DefaultTableModel tableModel = (DefaultTableModel) table.getModel();tableModel.setRowCount(3);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);


        this.add(scrollPane);//滑动
        this.add(table);


    }


    public Object[][] requestData() throws SQLException, ClassNotFoundException {
        //sql：选择所有图书
        String sql = "select * from books";
        //调用DBUtils操作数据库查询全部数据
        ResultSet query = DBUtils.query(DBUtils.getConnection(), sql);
        //准备一个集合
        List<Book> list = new ArrayList();
        //给Object[][] data = new Object[list.size()][4];腾一行
        list.add(new Book());
        while (query.next()) {
            //逐行添加进list集合
            Book book = new Book();
                 book.setId(query.getInt("id"));
                 book.setName(query.getString("name"));
                 book.setAuthor(query.getString("author"));
                 book.setStatm(query.getInt("statm"));
                 list.add(book);
        }
        //先添加图书表的第一行
        Object[][] data = new Object[list.size()][4];
        data[0][0] = "序号";
        data[0][1] = "书名";
        data[0][2] = "作者";
        data[0][3] = "图书数量";
        //逐行添加进Object[][] data中
        for (int i = 1; i < list.size(); i++) {
            data[i][0] = list.get(i).getId();
            data[i][1] = list.get(i).getName();
            data[i][2] = list.get(i).getAuthor();
            data[i][3] = list.get(i).getStatm();


        }
        return data;



    }
    public UserManageComponent(int axis) {
        super(axis);
    }
}
