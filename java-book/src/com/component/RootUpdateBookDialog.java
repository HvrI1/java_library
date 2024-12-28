package com.component;

import com.ui.ManagerInterfacs;
import com.utils.DBUtils;
import com.utils.ScreenUtils;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

public class RootUpdateBookDialog extends JDialog{
    final int WIDTH = 400;
    final int HEIGHT = 300;
    public RootUpdateBookDialog(JFrame jf,String title,boolean isModel) throws IOException {
        super(jf,title,isModel);


        this.setBounds(ScreenUtils.getScreenW() - WIDTH / 2, (ScreenUtils.getScreenH() - HEIGHT) / 2, WIDTH, HEIGHT);

        Box vBox = Box.createVerticalBox();

        Box nameBox = Box.createHorizontalBox();
        JLabel nameLable = new JLabel("  要修改的图书序号 ");
        JTextField nameField = new JTextField(15);

        nameBox.add(nameLable);
        nameBox.add(Box.createHorizontalStrut(20));
        nameBox.add(nameField);



        Box nameBoxUdate = Box.createHorizontalBox();
        JLabel nameLableUdate = new JLabel("  要修改后的图书名称");
        JTextField nameFieldUdate = new JTextField(15);

        nameBoxUdate.add(nameLableUdate);
        nameBoxUdate.add(Box.createHorizontalStrut(20));
        nameBoxUdate.add(nameFieldUdate);

        Box authorBox = Box.createHorizontalBox();
        JLabel authorLable = new JLabel("   修改后的库存");
        JTextField authorField = new JTextField(15);

        authorBox.add(authorLable);
        authorBox.add(Box.createHorizontalStrut(20));
        authorBox.add(authorField);

        Box btnBox = Box.createHorizontalBox();
        btnBox.add(Box.createVerticalStrut(50));
        JButton addBtn = new JButton("修改");
        btnBox.add(addBtn);

        vBox.add(Box.createVerticalStrut(40));
        vBox.add(nameBox);
        vBox.add(Box.createVerticalStrut(40));
        vBox.add(nameBoxUdate);
        vBox.add(Box.createVerticalStrut(40));
        vBox.add(authorBox);
        vBox.add(Box.createVerticalStrut(20));
        vBox.add(btnBox);



        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText().trim();
                String nameUpdate = nameFieldUdate.getText().trim();
                String author = authorField.getText().trim();
                String sql = "UPDATE  `books` set statm = '"+author+"' where name = '"+nameUpdate+"' and id = '"+name+"'";

                try {
                    int i = DBUtils.update(DBUtils.getConnection(), sql);
                    if (i > 0){
                        JOptionPane.showMessageDialog(jf,"修改成功！");
                        new ManagerInterfacs().init();
                        jf.dispose();
                    }else {
                        JOptionPane.showMessageDialog(jf,"修改失败！！！！！！");
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }

        });

        setLocationRelativeTo(null);

        this.add(vBox);

        jf.setVisible(true);

    }
}
