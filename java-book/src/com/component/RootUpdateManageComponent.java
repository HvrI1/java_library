package com.component;

import com.pojo.Book;
import com.utils.DBUtils;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class RootUpdateManageComponent extends Box {

    final int WIDTH = 850;
    final int HEIGHT = 600;
    JFrame jf = null;

    private JTable table;
    private Vector<String> titles;
    private Vector<Vector> tableData;
    private TableModel tableModel;
    private Container ct;

    public RootUpdateManageComponent(JFrame jf) throws SQLException, ClassNotFoundException {

        super(BoxLayout.Y_AXIS);


        this.jf = jf;
        JPanel btnPanel = new JPanel();
        Color color = new Color(203,220,217);
        btnPanel.setBackground(color);
        btnPanel.setMaximumSize(new Dimension(WIDTH,80));
        btnPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        JButton borrowBtn = new JButton("修改图书数量");
        //JButton returnBtn = new JButton("归还图书");
        borrowBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new RootUpdateBookDialog(jf,"修改图书数量",true).setVisible(true);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });



        btnPanel.add(borrowBtn);
        this.add(btnPanel);

        String[] ts = {"编号","书名","作者","图书数量"};
        titles = new Vector<>();
        for (String title : ts){
            titles.add(title);
        }



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
        String sql = "select * from books";
        ResultSet query = DBUtils.query(DBUtils.getConnection(), sql);
        List<Book> list = new ArrayList();
        list.add(new Book());
        while (query.next()) {
            //String name = query.getString("name");
            //String author = query.getString("author");
            //String statm = query.getString("statm");
            Book book = new Book();
                 book.setId(query.getInt("id"));
                 book.setName(query.getString("name"));
                 book.setAuthor(query.getString("author"));
                 book.setStatm(query.getInt("statm"));
                 list.add(book);
        }
        Object[][] data = new Object[list.size()][4];
        data[0][0] = "序号";
        data[0][1] = "书名";
        data[0][2] = "作者";
        data[0][3] = "图书数量";
        for (int i = 1; i < list.size(); i++) {
            data[i][0] = list.get(i).getId();
            data[i][1] = list.get(i).getName();
            data[i][2] = list.get(i).getAuthor();
            data[i][3] = list.get(i).getStatm();

        }
        return data;



    }
    public RootUpdateManageComponent(int axis) {
        super(axis);
    }
}
