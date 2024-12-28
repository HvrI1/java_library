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

public class DeleteBookDialog extends JDialog {
    final int WIDTH = 400;
    final int HEIGHT = 300;
    public DeleteBookDialog(JFrame jf,String title,boolean isModel) throws IOException {
        super(jf,title,isModel);


        this.setBounds(ScreenUtils.getScreenW() - WIDTH / 2, (ScreenUtils.getScreenH() - HEIGHT) / 2, WIDTH, HEIGHT);

        Box vBox = Box.createVerticalBox();

        Box nameBox = Box.createHorizontalBox();
        JLabel nameLable = new JLabel("  图书序号");
        JTextField nameField = new JTextField(15);

        nameBox.add(nameLable);
        nameBox.add(Box.createHorizontalStrut(20));
        nameBox.add(nameField);

        Box authorBox = Box.createHorizontalBox();
        JLabel authorLable = new JLabel("  图书名称");
        JTextField authorField = new JTextField(15);

        authorBox.add(authorLable);
        authorBox.add(Box.createHorizontalStrut(20));
        authorBox.add(authorField);

        Box btnBox = Box.createHorizontalBox();
        btnBox.add(Box.createVerticalStrut(50));
        JButton addBtn = new JButton("删除");
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
                String sql = "DElETE from `books` where name = '"+name+"' or author = '"+author+"'";
                try {
                    int i = DBUtils.update(DBUtils.getConnection(), sql);
                    if (i > 0){
                        JOptionPane.showMessageDialog(jf,"删除成功！");
                        new ManagerInterfacs().init();
                        jf.dispose();
                    }else {
                        JOptionPane.showMessageDialog(jf,"删除失败！！！！！！");
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
