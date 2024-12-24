package com.sx.server;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.sx.book.FindBookFrame;
import com.sx.client.BackBookInfo;
import com.sx.client.FindBookInfo;
import com.sx.client.SearchBookInfo;
import com.sx.type.UpdateTypeFrame;
import com.sx.users.IndexUsersFrame;

public class ServerManager extends JFrame implements ActionListener  {
	
	private static final long serialVersionUID = 1L;
	public ServerManager(){
		this.setLayout(null);
		this.setTitle("欢迎进入图书管理系统");
		//借书按钮
		JButton lend = new JButton(); 
		lend.setText("图书信息管理");
		lend.setBounds(350, 50, 120, 50);
		lend.addActionListener(this);
		this.add(lend);
		
		//还书按钮
		JButton back = new JButton();
		back.setText("图书类型管理");
		back.setBounds(350, 150,120, 50);
		back.addActionListener(this);
		this.add(back);
		
		//查询按钮
		JButton search  = new JButton();
		search.setText("读者管理");
		search.setBounds(350,250,120,50);
		search.addActionListener(this);
		this.add(search);
		
		//建议按钮
		JButton suggest = new JButton();
		suggest.setText("建议");
		suggest.setBounds(350,350,120,50);
		suggest.addActionListener(this);
		this.add(suggest);
		
		this.setSize(800,600);
		this.setLocation(100,50);
		this.setResizable(false);
		this.setVisible(true);
	}
	public static void main(String []args){
		new ServerManager();
	}
	public void actionPerformed(ActionEvent e) {
		
		String command = e.getActionCommand();
		if(command.equals("图书信息管理")){
			/*JTextField name = new JTextField();
			name.setSize(100,20);
			JOptionPane.showMessageDialog(null, name);*/
			new  FindBookFrame();
			this.setVisible(false);
		}else if(command.equals("图书类型管理")){
			new UpdateTypeFrame();
			this.setVisible(false);
		}else if(command.equals("读者管理")){
			  new  IndexUsersFrame(); 
			this.setVisible(false);
		}else if(command.equals("建议")){
			
		}
		
		
		
	}
	

}
