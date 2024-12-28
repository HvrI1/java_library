package com.ui;

import com.component.*;
import com.utils.ScreenUtils;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public class UserManagerInterfacs {
    JFrame jf = new JFrame("王明图书馆，欢迎您");
    final int  WIDTH = 1000;
    final int HEIGHT = 600;

    public UserManagerInterfacs() {
    }


    public void init(String username) throws IOException {

        //JOptionPane.showMessageDialog(jf,username);

        jf.setBounds(ScreenUtils.getScreenW() - WIDTH / 2, (ScreenUtils.getScreenH() - HEIGHT) / 2, WIDTH, HEIGHT);
        jf.setResizable(false);

//        jf.setIconImage(ImageIO.read(new File("src/img/logo.png")));

        BackGroundPanel bgPanel = new BackGroundPanel(ImageIO.read(new File("src/img/enna.jpg")));
        bgPanel.setBounds(0, 0, WIDTH, HEIGHT);
        Box vBox = Box.createVerticalBox();
        //设置菜单栏
        JMenuBar jmb = new JMenuBar();
        JMenu jMenu = new JMenu("设置");
        JMenuItem m1 = new JMenuItem("切换账号");
        JMenuItem m2 = new JMenuItem("退出程序");
        m1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new MainInterface().init();
                    jf.dispose();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        m2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        jf.setLocationRelativeTo(null); // 窗口居中

        jMenu.add(m1);
        jMenu.add(m2);
        jmb.add(jMenu);
        jf.setJMenuBar(jmb);
        //设置分隔面板
        JSplitPane sp = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        sp.setContinuousLayout(true);
        sp.setDividerLocation(150);
        sp.setDividerSize(7);
        //jf.add(sp);

        //DefaultMutableTreeNode root = new DefaultMutableTreeNode("系统管理");
        //DefaultMutableTreeNode bookManage = new DefaultMutableTreeNode("图书管理");
        DefaultMutableTreeNode borrowManage = new DefaultMutableTreeNode("借阅图书");

        //root.add(bookManage);
        //root.add(borrowManage);
        //JTree tree = new JTree(root);
        //sp.setLeftComponent(tree);
        try {
            sp.setRightComponent(new BorrowManageComponent(jf,username));
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        sp.setDividerLocation(150);
        jf.add(sp);

        //设置当前tree默认选中
        //tree.setSelectionRow(2);
//        tree. addTreeSelectionListener (new TreeSelectionListener(){
//            //当条目选中变化后，这个方法会执行
//            @Override
//            public void valueChanged(TreeSelectionEvent e) {
////得到当前选中的结点对象
//                Object lastPathComponent = e.getNewLeadSelectionPath().getLastPathComponent();
//                if (bookManage.equals(lastPathComponent)) {
//                    try {
//                        sp.setRightComponent(new UserManageComponent(jf));
//                        sp.setDividerLocation(150);
//                    } catch (SQLException | ClassNotFoundException throwables) {
//                        throwables.printStackTrace();
//                    }
//
//                }
//                if (borrowManage.equals(lastPathComponent)) {
//                    try {
//                        sp.setRightComponent(new BorrowManageComponent(jf));
//                        sp.setDividerLocation(150);
//                    } catch (SQLException | ClassNotFoundException throwables) {
//                        throwables.printStackTrace();
//                    }
//
//                }
//            }
//        });


        jf.setVisible(true);
    }



}
