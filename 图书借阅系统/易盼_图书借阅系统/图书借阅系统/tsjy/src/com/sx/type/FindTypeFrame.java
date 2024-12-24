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
		this.setTitle("图书类型查询");

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
			title = new String[] { "书籍类型编号", "书籍类型名称", "书籍类型描述" };
			
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

		 
		//类型编号开始
		JLabel lxbh = new JLabel();
           lxbh.setText("类型编号：");
           lxbh.setBounds(100,350,100,20);
           this.add(lxbh);
           
        bh = new JTextField();
         bh.setBounds(200, 350, 200, 20);
         this.add(bh);
          //类型编号结束
         
		//类型名称开始
         JLabel lxmc = new JLabel();
         lxmc.setText("类型名称:");
         lxmc.setBounds(100,380,100,20);
         this.add(lxmc);
         
          mc = new JTextField();
         mc.setBounds(200, 380, 200, 20);
         this.add(mc);
		//类型名称开始
		//类型描述开始
      JLabel  lxms = new JLabel();
         lxms.setText("类型描述：");
         lxms.setBounds(100, 410, 100, 20);
         this.add(lxms);
         
          ms = new JTextField();
         ms.setBounds(200,410,200,20);
         this.add(ms);
         
		//类型描述结束
         
         JButton  update = new JButton();
         update.setText("修改");
         update.setBounds(200, 500, 60, 20);
         this.add(update);
         
         JButton delete = new JButton();
         delete.setText("删除");
         delete.setBounds(270,500,60,20);
         this.add(delete);
         
         JButton cancel = new JButton();
         cancel.setText("取消");
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
