package com.sx.type;

import com.sx.commom.DBManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.JTable;
import javax.swing.JTextField;

public class UpdateTypeFrame extends JFrame  implements MouseListener,ActionListener{

	private static final long serialVersionUID = 1L;

	int count;

	String[][] data = null;

	String[] title = null;
    
	JTable  table = null;
	
	JTextField bh;
	JTextField mc;
	JTextField ms;
	//JButton  update;
	//JButton  delete;
	//JButton  cancel;
	public UpdateTypeFrame() {
		this.setLayout(null);
		this.setTitle("ͼ�����Ͳ�ѯ");

		try {
			
			String sql = "select * from types";
			String sqlCount = "select count(*) from types";
			ResultSet resCount =DBManager.executeSearch(sqlCount);
			resCount.next();
			count = resCount.getInt(1);
			data = new String[count + 1][3];
			title = new String[] { "�鼮���ͱ��", "�鼮��������", "�鼮��������" };
			
			ResultSet res = DBManager.executeSearch(sql);
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
         update.addActionListener(this);
         this.add(update);
         
         JButton delete = new JButton();
         delete.setText("ɾ��");
         delete.setBounds(270,500,60,20);
         delete.addActionListener(this);
         this.add(delete);
         
         JButton  cancel = new JButton();
         cancel.setText("ȡ��");
         cancel.setBounds(340,500,60,20);
         cancel.addActionListener(this);
         this.add(cancel);
         
         		
       	table = new JTable(data, title);
		table.addMouseListener(this);
		table.setSize(600, 250);
		table.setLocation(100, 50);
		this.add(table);
		this.setSize(800, 600);
		this.setLocation(100,50);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {
		new UpdateTypeFrame();
	}

	public void mouseClicked(MouseEvent arg0) {
		//JOptionPane.showMessageDialog(null, table.getValueAt(table.getSelectedRow(), 0));
		//System.out.println("hello");
		if(table.getSelectedRow()!= -1){
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

	public void actionPerformed(ActionEvent e) {
		//JOptionPane.showMessageDialog(null, "gg");
		String command = e.getActionCommand();
		//System.out.println(command);
		if(command.equals("�޸�")){
			//JOptionPane.showMessageDialog(null, "gg");
			
			String sql = "update types set types_name = '"+mc.getText()+"',types_desc = '"+ms.getText()+"' where types_id = '"+bh.getText()+"'";
		int count = DBManager.executeUpdate(sql);
			if(count == 1){
				table.setValueAt(mc.getText(),table.getSelectedRow() ,1);
				table.setValueAt(ms.getText(),table.getSelectedRow(),2);
				JOptionPane.showMessageDialog(null,"�޸ĳɹ�");
			}else{
				JOptionPane.showMessageDialog(null, "�޸�ʧ��");
			}
			
		}else if(command.equals("ɾ��")){
			  String sql = "delete from types where types_id = '"+bh.getText()+"'";
			  int count =DBManager.executeUpdate(sql);
			  if(count == 1){
				  
				  JOptionPane.showMessageDialog(null, "ɾ���ɹ�");
			  }else{
				  JOptionPane.showMessageDialog(null,"ɾ��ʧ��");
			  }
		}else if(command.equals("ȡ��")){
			bh.setText("");
			mc.setText("");
			ms.setText("");
		}
		
	}

}
