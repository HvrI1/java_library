package com.sx.client;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import  javax.swing.*;

import com.sx.commom.DBManager;
public class ModifyPassWord extends JFrame implements  ActionListener{
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	 JTextField zh,mm,qmm,qxmm;
	public   ModifyPassWord(){
	    this.setLayout(null); 
	    this.setTitle("�޸�����");
	    
	    //ͼ�鿨�ſ�ʼ
	    JLabel   jyzh = new JLabel();
	    jyzh.setText("ͼ�鿨��");
	   jyzh.setBounds(50, 50, 100, 20);
	   this.add(jyzh);
	   
	    zh = new JTextField();
	   zh.setBounds(150,50,200,20);
	   this.add(zh);
	   //ͼ�鿨�Ž���
	   
	   //���뿪ʼ
	   JLabel zhmm = new JLabel();
	   zhmm.setText("������");
	   zhmm.setBounds(50,80,100,20);
	   this.add(zhmm);
	   
	     mm = new JTextField();
	    mm.setBounds(150,80,200,20);
	    this.add(mm);
	    
	    JLabel qrmm = new  JLabel();
	    qrmm.setText("������");
	    qrmm.setBounds(50, 110, 100, 20);
	    this.add(qrmm);
	    
	    qmm = new JTextField();
	    qmm.setBounds(150, 110, 200, 20);
	    this.add(qmm);
	    
	    JLabel qrxmm = new  JLabel();
	    qrxmm.setText("ȷ��������");
	    qrxmm.setBounds(50, 140, 100, 20);
	    this.add(qrxmm);
	    
	    qxmm = new JTextField();
	    qxmm.setBounds(150, 140, 200, 20);
	    this.add(qxmm);
	   //�������
	    
	    //��ť��ʼ
	    JButton confirm = new JButton();
	    confirm.setText("ȷ��");
	    confirm.setBounds(100, 200, 60, 20);
	    confirm.addActionListener(this);
	    this.add(confirm);
	    
	    JButton cancel = new JButton();
	    cancel.setText("ȡ��");
	    cancel.setBounds(180, 200, 60, 20);
	    cancel.addActionListener(this);
	    this.add(cancel);
	    //��ť����
	    this.getContentPane().setBackground(new Color(100,200,30));
	    
	    
	   Dimension  d = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) d.getWidth();
	    int y = (int) d.getHeight();
		this.setBounds((x- 400)/2, (y-300)/2, 400, 300);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.addWindowListener( new  WindowAdapter(){
			public void windowClosing(WindowEvent e){
			int jp = JOptionPane.showConfirmDialog(null, "��ȷ��Ҫ�رմ�����","��ܰ��ʾ��",JOptionPane.OK_CANCEL_OPTION);
				if(jp == 0){
					System.exit(0);
					
				}
			}
		});
	}
    public static void main(String[]args){
    	new ModifyPassWord();
    }
	public void actionPerformed(ActionEvent e) {
		   String command = e.getActionCommand();
		   if(command.equals("ȷ��")){
			 //System.out.println(zh.getText());
			   String bh = zh.getText();
			   String pass = mm.getText(); 
			   String tPass =this.qmm.getText();
			   String ttPass = this.qxmm.getText();
			   if(bh.trim().length()>0&&pass.trim().length()>0&&tPass.trim().length()>0&&ttPass.trim().length()>0){
				   if(tPass.equals(ttPass)){
				   String sql = " select count(*) from users where users_jyzh ='"+bh+"' and users_mm='"+pass+"' ";
				     ResultSet res = DBManager.executeSearch(sql);
				     try {
						res.next();
						int count =res.getInt(1);
						if(count == 1){
							String sqlCount = "update users set users_mm='"+tPass+"'where users_jyzh='"+bh+"'";
							int re = DBManager.executeUpdate(sqlCount); 
							if(re == 1){
							JOptionPane.showMessageDialog(null, "��ϲ���������޸ĳɹ���");
							}else{
								JOptionPane.showMessageDialog(null,"����д����ϣ������޸�ʧ�ܣ�");
							}
						}else{
							JOptionPane.showMessageDialog(null,"�˺Ż�������������޸�ʧ�ܣ�");
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				     
				   }else{
					JOptionPane.showMessageDialog(null, "���벻һ��");   
				    }
				   }else{
				   JOptionPane.showMessageDialog(null,"�����뿨�ź�����");
			   }
		   }else if(command.equals("ȡ��")){
			   zh.setText("");
			   mm.setText("");
			   qmm.setText("");
			   qxmm.setText("");
		   }
		
	}
}
