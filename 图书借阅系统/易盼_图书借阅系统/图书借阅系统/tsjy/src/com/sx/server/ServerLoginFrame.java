package com.sx.server;
import com.sx.commom.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ServerLoginFrame extends JFrame implements ActionListener {
    
	private static final long serialVersionUID = 1L;
	
	JTextField textAccount;
	
	JTextField passw ;
	
	public   ServerLoginFrame(){
    	this.setLayout(null);
    	this.setTitle("ͼ�����ϵͳ");
    	//�˺�
    	JLabel account = new JLabel();
    	account.setText("�˺ţ�");
    	account.setBounds(10, 10, 60, 20);
    	this.add(account);
    	
    	textAccount = new JTextField();
    	textAccount.setBounds(70,10,190,20);
    	this.add(textAccount);
    	
    	//����
    	JLabel pw = new JLabel();
    	pw.setText("���룺");
    	pw.setBounds(10,40,60,20);
    	this.add(pw);
    	
    	 passw  = new JTextField();
    	passw.setBounds(70,40,190,20);
        this.add(passw);
        
        //��ť
        JButton save = new JButton();
        save.setBounds(20,80,100,20);
        save.setText("��½");
        save.addActionListener(this);
        this.add(save);
        
        JButton cancel = new JButton();
        cancel.setBounds(150,80,100,20);
        cancel.setText("ȡ��");
        cancel.addActionListener(this);
        this.add(cancel);
        
     	this.setSize(300,150);
    	this.setLocation(300,200);
    	this.setResizable(false);
    	this.setVisible(true);
    }
	
	public static void main(String[] args) {
	   new  ServerLoginFrame(); 

	}

	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if(command.equals("��½")){
			    //JOptionPane.showMessageDialog(null,"hello");
			String sql ="select * from users  where users_jyzh = '"+this.textAccount.getText()+"' and users_mm = '"+this.passw.getText()+"' ";
		 ResultSet res = DBManager.executeSearch(sql);
		 try {
			if(res.next()){
				 JOptionPane.showMessageDialog(null, "��½�ɹ���");
				 new ServerManager();
				this.setVisible(false);
			 }else{
				 JOptionPane.showMessageDialog(null, "��¼ʧ�ܣ�");
			 }
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		}else{
			textAccount.setText("");
			passw.setText("");
		}
		
	}

}
