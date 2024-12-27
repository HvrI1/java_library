package com.component;

import com.ui.MainInterface;
import com.ui.ManagerInterfacs;
import com.utils.DBUtils;
import com.utils.ScreenUtils;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

public class AddBookDialog extends JDialog {
    final int WIDTH = 400;
    final int HEIGHT = 300;
    public AddBookDialog(JFrame jf,String title,boolean isModel) throws IOException {
        super(jf,title,isModel);


        this.setBounds(ScreenUtils.getScreenW() - WIDTH / 2, (ScreenUtils.getScreenH() - HEIGHT) / 2, WIDTH, HEIGHT);

        Box vBox = Box.createVerticalBox();

        Box nameBox = Box.createHorizontalBox();
        JLabel nameLable = new JLabel("  图书名称");
        JTextField nameField = new JTextField(15);

        nameBox.add(nameLable);
        nameBox.add(Box.createHorizontalStrut(20));
        nameBox.add(nameField);


        Box authorBox = Box.createHorizontalBox();
        JLabel authorLable = new JLabel("  图书作者");
        JTextField authorField = new JTextField(15);


        authorBox.add(authorLable);
        authorBox.add(Box.createHorizontalStrut(20));
        authorBox.add(authorField);

        Box btnBox = Box.createHorizontalBox();
        btnBox.add(Box.createVerticalStrut(50));
        JButton addBtn = new JButton("添加");
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
                String name = nameField.getText().trim();
                String author = authorField.getText().trim();
                String sql = "INSERT INTO `books`(name,author,statm)value('"+name+"','"+author+"',1)";

                try {
                    int i = DBUtils.update(DBUtils.getConnection(), sql);
                    if (i > 0 && !Objects.equals(name, "")) {
                        JOptionPane.showMessageDialog(jf,"添加成功！");
                        new ManagerInterfacs().init();
                        jf.dispose();
                    }else {
                        JOptionPane.showMessageDialog(jf,"添加失败！！！！！！");
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
