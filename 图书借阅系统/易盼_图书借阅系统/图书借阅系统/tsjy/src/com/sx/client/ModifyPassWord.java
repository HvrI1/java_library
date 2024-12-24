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
	    this.setTitle("修改密码");
	    
	    //图书卡号开始
	    JLabel   jyzh = new JLabel();
	    jyzh.setText("图书卡号");
	   jyzh.setBounds(50, 50, 100, 20);
	   this.add(jyzh);
	   
	    zh = new JTextField();
	   zh.setBounds(150,50,200,20);
	   this.add(zh);
	   //图书卡号结束
	   
	   //密码开始
	   JLabel zhmm = new JLabel();
	   zhmm.setText("旧密码");
	   zhmm.setBounds(50,80,100,20);
	   this.add(zhmm);
	   
	     mm = new JTextField();
	    mm.setBounds(150,80,200,20);
	    this.add(mm);
	    
	    JLabel qrmm = new  JLabel();
	    qrmm.setText("新密码");
	    qrmm.setBounds(50, 110, 100, 20);
	    this.add(qrmm);
	    
	    qmm = new JTextField();
	    qmm.setBounds(150, 110, 200, 20);
	    this.add(qmm);
	    
	    JLabel qrxmm = new  JLabel();
	    qrxmm.setText("确认新密码");
	    qrxmm.setBounds(50, 140, 100, 20);
	    this.add(qrxmm);
	    
	    qxmm = new JTextField();
	    qxmm.setBounds(150, 140, 200, 20);
	    this.add(qxmm);
	   //密码结束
	    
	    //按钮开始
	    JButton confirm = new JButton();
	    confirm.setText("确认");
	    confirm.setBounds(100, 200, 60, 20);
	    confirm.addActionListener(this);
	    this.add(confirm);
	    
	    JButton cancel = new JButton();
	    cancel.setText("取消");
	    cancel.setBounds(180, 200, 60, 20);
	    cancel.addActionListener(this);
	    this.add(cancel);
	    //按钮结束
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
			int jp = JOptionPane.showConfirmDialog(null, "您确认要关闭窗口吗？","温馨提示！",JOptionPane.OK_CANCEL_OPTION);
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
		   if(command.equals("确认")){
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
							JOptionPane.showMessageDialog(null, "恭喜您！密码修改成功！");
							}else{
								JOptionPane.showMessageDialog(null,"数据写入故障，密码修改失败！");
							}
						}else{
							JOptionPane.showMessageDialog(null,"账号或密码错误，密码修改失败！");
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				     
				   }else{
					JOptionPane.showMessageDialog(null, "密码不一致");   
				    }
				   }else{
				   JOptionPane.showMessageDialog(null,"请输入卡号和密码");
			   }
		   }else if(command.equals("取消")){
			   zh.setText("");
			   mm.setText("");
			   qmm.setText("");
			   qxmm.setText("");
		   }
		
	}
}
