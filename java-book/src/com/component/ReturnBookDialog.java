package com.component;

import com.ui.ManagerInterfacs;
import com.ui.UserManagerInterfacs;
import com.utils.DBUtils;
import com.utils.ScreenUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class ReturnBookDialog extends JDialog {
    final int WIDTH = 400;
    final int HEIGHT = 300;
    public ReturnBookDialog(JFrame jf, String title, boolean isModel, String username) throws IOException {
        super(jf,title,isModel);


        this.setBounds(ScreenUtils.getScreenW() - WIDTH / 2, (ScreenUtils.getScreenH() - HEIGHT) / 2, WIDTH, HEIGHT);

        Box vBox = Box.createVerticalBox();

        Box nameBox = Box.createHorizontalBox();
        JLabel nameLable = new JLabel("要归还图书序号");
        JTextField nameField = new JTextField(15);

        nameBox.add(nameLable);
        nameBox.add(Box.createHorizontalStrut(20));
        nameBox.add(nameField);

        Box authorBox = Box.createHorizontalBox();
        JLabel authorLable = new JLabel("要归还图书名称");
        JTextField authorField = new JTextField(15);

        authorBox.add(authorLable);
        authorBox.add(Box.createHorizontalStrut(20));
        authorBox.add(authorField);

        Box btnBox = Box.createHorizontalBox();
        btnBox.add(Box.createVerticalStrut(50));
        JButton addBtn = new JButton("确定");
        btnBox.add(addBtn);

        vBox.add(Box.createVerticalStrut(40));
        vBox.add(nameBox);
        vBox.add(Box.createVerticalStrut(80));
        vBox.add(authorBox);
        vBox.add(Box.createVerticalStrut(20));
        vBox.add(btnBox);



        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = nameField.getText().trim();
                String name = authorField.getText().trim();
                String sql = "select * from `books` where id = '"+id+"' and name = '"+name+"'  and statm >= 0";
                //String sql1 = "UPDATE  `books` set statm = '"+ 1 +"' where id = '"+id+"'";
                String sql1 = "UPDATE  `books` set statm = 1 + statm where id = '"+id+"'";
                String sql2 = "select * from `user_books` where bid = '"+id+"' and uid = '"+username+"'";
                String sql3 = "delete from `user_books` where bid = '"+id+"' and uid = '"+username+"'";
                try {
                    ResultSet query = DBUtils.query(DBUtils.getConnection(), sql);
                    ResultSet i2 = DBUtils.query(DBUtils.getConnection(), sql2);

                    if (i2.next()) {
                        int i1 = DBUtils.update(DBUtils.getConnection(), sql1);
                        if (i1 > 0){
                            DBUtils.update(DBUtils.getConnection(), sql3);
                            JOptionPane.showMessageDialog(jf,"归还成功！");
                        }else {
                            JOptionPane.showMessageDialog(jf,"归还失败！！！！");
                        }

                        new UserManagerInterfacs().init(username);
                        jf.dispose();
                    }else {
                        JOptionPane.showMessageDialog(jf,"你未借阅该图书！！！！！！");
                    }
                } catch (SQLException | ClassNotFoundException | IOException throwables) {
                    throwables.printStackTrace();
                }
            }

        });


        setLocationRelativeTo(null);

        this.add(vBox);

        jf.setVisible(true);

    }
}
