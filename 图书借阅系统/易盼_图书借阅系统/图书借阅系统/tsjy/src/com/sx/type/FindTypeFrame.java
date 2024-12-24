package com.sx.type;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class FindTypeFrame extends JFrame  implements MouseListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	int count;

	String[][] data = null;

	String[] title = null;
    
	JTable  table = null;
	
	JTextField bh;
	JTextField mc;
	JTextField ms;
	public FindTypeFrame() {
		this.setLayout(null);
		this.setTitle("ͼ�����Ͳ�ѯ");

		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection conn = DriverManager.getConnection("jdbc:odbc:book",
					"sa", "");
			Statement stat = conn.createStatement();
			String sql = "select * from types";
			String sqlCount = "select count(*) from types";
			ResultSet resCount = stat.executeQuery(sqlCount);
			resCount.next();
			count = resCount.getInt(1);
			data = new String[count + 1][3];
			title = new String[] { "�鼮���ͱ��", "�鼮��������", "�鼮��������" };
			
			ResultSet res = stat.executeQuery(sql);
			data[0] = title;
			boolean b = res.next();
			int index = 1;
			if (b) {
				do {
					int id = res.getInt(1);
					String name = res.getString(2);
					String desc = res.getString(3);
					String str = id + "-" + name + "-" + desc;
					String[] row = str.split("-");
					data[index] = row;
					index++;
				} while (res.next());
			}
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		 
		//���ͱ�ſ�ʼ
		JLabel lxbh = new JLabel();
           lxbh.setText("���ͱ�ţ�");
           lxbh.setBounds(100,350,100,20);
           this.add(lxbh);
           
        bh = new JTextField();
         bh.setBounds(200, 350, 200, 20);
         this.add(bh);
          //���ͱ�Ž���
         
		//�������ƿ�ʼ
         JLabel lxmc = new JLabel();
         lxmc.setText("��������:");
         lxmc.setBounds(100,380,100,20);
         this.add(lxmc);
         
          mc = new JTextField();
         mc.setBounds(200, 380, 200, 20);
         this.add(mc);
		//�������ƿ�ʼ
		//����������ʼ
      JLabel  lxms = new JLabel();
         lxms.setText("����������");
         lxms.setBounds(100, 410, 100, 20);
         this.add(lxms);
         
          ms = new JTextField();
         ms.setBounds(200,410,200,20);
         this.add(ms);
         
		//������������
         
         JButton  update = new JButton();
         update.setText("�޸�");
         update.setBounds(200, 500, 60, 20);
         this.add(update);
         
         JButton delete = new JButton();
         delete.setText("ɾ��");
         delete.setBounds(270,500,60,20);
         this.add(delete);
         
         JButton cancel = new JButton();
         cancel.setText("ȡ��");
         cancel.setBounds(340,500,60,20);
         this.add(cancel);
         
         
		
		
		table = new JTable(data, title);
	
		table.addMouseListener(this);
		JScrollPane jsp = new JScrollPane(table);
		
		jsp.setSize(600, 250);
		jsp.setLocation(100, 50);
		this.add(jsp);
		this.setSize(800, 600);
		this.setLocation(100,50);
		this.setResizable(false);
		this.setVisible(true);

	}

	public static void main(String[] args) {
		new FindTypeFrame();
	}

	public void mouseClicked(MouseEvent arg0) {
		//JOptionPane.showMessageDialog(null, table.getValueAt(table.getSelectedRow(), 0));
		if(table.getSelectedRow() != -1){
    	bh.setText((String)table.getValueAt(table.getSelectedRow(), 0));	
		mc.setText((String)table.getValueAt(table.getSelectedRow(), 1));
		ms.setText((String)table.getValueAt(table.getSelectedRow(), 2));
		}
		
	}

	public void mouseEntered(MouseEvent arg0) {
		
		
	}

	public void mouseExited(MouseEvent arg0) {
		
		
	}

	public void mousePressed(MouseEvent arg0) {
		
		
	}

	public void mouseReleased(MouseEvent arg0) {
		
		
	}

}
