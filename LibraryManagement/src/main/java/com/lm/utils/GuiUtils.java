package com.lm.utils;

import javax.swing.*;
import java.awt.*;

public class GuiUtils {


        /**
         * 创建并显示一个简单的窗口
         * @param title 窗口标题
         * @param width 窗口宽度
         * @param height 窗口高度
         */
        public static JFrame createAndShowGUI(String title, int width, int height) {
            JFrame frame = new JFrame(title);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(width, height);
            frame.setLocationRelativeTo(null); // 居中显示
            frame.setVisible(true);
            return frame;
        }

        /**
         * 添加一个标签到容器中
         * @param container 容器
         * @param text 标签文本
         * @param x x坐标
         * @param y y坐标
         */
        public static void addLabel(Container container, String text, int x, int y, int width, int height,Color color) {
            JLabel label = new JLabel(text);
            label.setBounds(x, y, width, height);
            label.setBackground(color);
            container.add(label);
        }

        /**
         * 添加一个文本框到容器中
         * @param container 容器
         * @param x x坐标
         * @param y y坐标
         * @param width 宽度
         * @param height 高度
         * @return JTextField 对象
         */
        public static JTextField addTextField(Container container, int x, int y, int width, int height) {
            JTextField textField = new JTextField();
            textField.setBounds(x, y, width, height);
            container.add(textField);
            return textField;
        }

        /**
         * 添加一个按钮到容器中
         * @param container 容器
         * @param text 按钮文本
         * @param x x坐标
         * @param y y坐标
         * @param width 宽度
         * @param height 高度
         * @return JButton 对象
         */
        public static JButton addButton(Container container, String text, int x, int y, int width, int height) {
            JButton button = new JButton(text);
            button.setBounds(x, y, width, height);
            container.add(button);
            return button;
        }

        /**
         * 设置容器布局为网格布局
         * @param container 容器
         * @param rows 行数
         * @param cols 列数
         * @param hgap 水平间距
         * @param vgap 垂直间距
         */
        public static void setGridLayout(Container container, int rows, int cols, int hgap, int vgap) {
            container.setLayout(new GridLayout(rows, cols, hgap, vgap));
        }

        /**
         * 设置容器布局为边界布局
         * @param container 容器
         */
        public static void setBorderLayout(Container container) {
            container.setLayout(new BorderLayout());
        }

        /**
         * 设置容器布局为流式布局
         * @param container 容器
         */
        public static void setFlowLayout(Container container) {
            container.setLayout(new FlowLayout());
        }

        /**
         * 设置容器布局为空布局
         * @param container 容器
         */
        public static void setNullLayout(Container container) {
            container.setLayout(null);
        }
}
