package com.test.login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.sx.client.BackBookInfo;
import com.sx.client.FindBookInfo;
import com.sx.client.SearchBookInfo;

public class MainFrame extends JFrame implements ActionListener  {
	
	private static final long serialVersionUID = 1L;
	public MainFrame(){
		this.setLayout(null);
		this.setTitle("��ӭ����ͼ�����ϵͳ");
		//���鰴ť
		JButton lend = new JButton(); 
		lend.setText("����");
		lend.setBounds(350, 50, 120, 50);
		lend.addActionListener(this);
		this.add(lend);
		
		//���鰴ť
		JButton back = new JButton();
		back.setText("����");
		back.setBounds(350, 150,120, 50);
		back.addActionListener(this);
		this.add(back);
		
		//��ѯ��ť
		JButton search  = new JButton();
		search.setText("��ѯ");
		search.setBounds(350,250,120,50);
		search.addActionListener(this);
		this.add(search);
		
		//���鰴ť
		JButton suggest = new JButton();
		suggest.setText("����");
		suggest.setBounds(350,350,120,50);
		suggest.addActionListener(this);
		this.add(suggest);
		
		this.setSize(800,600);
		this.setLocation(100,50);
		this.setResizable(false);
		this.setVisible(true);
	}
	public static void main(String []args){
		new MainFrame();
	}
	public void actionPerformed(ActionEvent e) {
		
		String command = e.getActionCommand();
		if(command.equals("����")){
			/*JTextField name = new JTextField();
			name.setSize(100,20);
			JOptionPane.showMessageDialog(null, name);*/
			new FindBookInfo();
			this.setVisible(false);
		}else if(command.equals("����")){
			new FindBookInfo();
			this.setVisible(false);
		}else if(command.equals("��ѯ")){
			new FindBookInfo();
			this.setVisible(false);
		}else if(command.equals("����")){
			
		}
		
		
		
	}
	

}
