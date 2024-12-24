package com.sx.book;
import com.sx.commom.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class AddBook extends JFrame implements ActionListener{
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		JTextField textBh;
		 JTextField textName;
		 JComboBox comType;
		 JTextField   textPrice;
		  JTextField   textCount;
		  JTextField   textPublish ;
		  JTextField   textAuthor ;
		  JTextArea   textDesc ;
     public  AddBook() throws ClassNotFoundException, SQLException{
    	 this.setLayout(null);
    	 this.setTitle("ͼ����Ϣ���");
    	 //ͼ����Ϣ 1.ͼ���� 2.ͼ������ 3.ͼ������ 4.ͼ�鵥�� 5.ͼ������6.ͼ�������7.ͼ������8.ͼ������
    	 //1.ͼ���ſ�ʼ
	    	  JLabel bh = new JLabel();
	    	  bh.setText("ͼ���ţ�");
	    	  bh.setBounds(10,10,100,20);
	    	  this.add(bh);
	    	 
	    	 textBh = new JTextField();
	    	  textBh.setBounds(110,10,200,20);
	    	  this.add(textBh);
    	 //ͼ���Ž���
    	    
    	  //2.ͼ�����ƿ�ʼ
	    	  JLabel name = new JLabel();
	    	  name.setText("ͼ�����ƣ�");
	    	  name.setBounds(10,35,100,20);
	    	  this.add(name);
	    	  
	    	  textName = new JTextField();
	    	  textName.setBounds(110,35,200,20);
	    	  this.add(textName);
	      //ͼ�����ƽ���
	    	  
	      //3.ͼ�����Ϳ�ʼ
	    	  JLabel type = new JLabel();
	    	  type.setText("ͼ�����ͣ�");
	    	  type.setBounds(10,60,100,20);
	    	  this.add(type);
	    	  
	    	  comType = new JComboBox();
	    	  comType.setBounds(110,60,200,20);
	    	 
	    	 String sql ="select *from types";
	    	ResultSet res =DBManager.executeSearch(sql);
	    	 while(res.next()){
	    		 comType.addItem(res.getString(2));
	    	 }
	    	 
	    	  this.add(comType);
    	   //ͼ�����ͽ���
	    	  
	    	  //4.ͼ�鵥�ۿ�ʼ
	    	  JLabel price =new JLabel();
	    	  price.setText("ͼ�鵥�ۣ�");
	    	  price.setBounds(10,85,100,20);
	    	  this.add(price);
	    	  
	    	   textPrice= new JTextField();
	    	  textPrice.setBounds(110,85,200,20);
	    	  this.add(textPrice);
	    	  //ͼ�鵥�۽���
	    	  
	    	  //5.ͼ��������ʼ
	    	  JLabel count =new JLabel();
	    	  count.setText("ͼ��������");
	    	  count.setBounds(10,110,100,20);
	    	  this.add(count);
	    	  
	    	   textCount= new JTextField();
	    	  textCount.setBounds(110,110,200,20);
	    	  this.add( textCount);
	    	  //ͼ����������
	    	  
	    	  //6.ͼ������翪ʼ
	    	  JLabel publish =new JLabel();
	    	  publish .setText("ͼ������磺");
	    	  publish .setBounds(10,135,100,20);
	    	  this.add(publish );
	    	  
	    	  textPublish = new JTextField();
	    	  textPublish.setBounds(110,135,200,20);
	    	  this.add( textPublish);
	    	  //ͼ����������
	    	  
            	//7.ͼ�����߿�ʼ
	    	  JLabel author =new JLabel();
	    	  author .setText("ͼ�����ߣ�");
	    	  author .setBounds(10,160,100,20);
	    	  this.add(author );
	    	  
	    	  textAuthor = new JTextField();
	    	  textAuthor.setBounds(110,160,200,20);
	    	  this.add( textAuthor);
	    	  //ͼ�����߽���
	    	  
	    	  //8.ͼ��������ʼ
	    	  JLabel desc =new JLabel();
	    	 desc.setText("ͼ��������");
	    	 desc.setBounds(10,185,100,20);
	    	  this.add(desc);
	    	  
	    	   textDesc = new JTextArea();
	    	  textDesc.setBounds(110,185,200,40);
	    	  this.add( textDesc);
	    	  //ͼ����������
	    	  
	    	  //��ť��ʼ
	    	  JButton save = new JButton();
	    	  save.setText("����");
	    	  save.setBounds(120,230, 60, 20);
	    	  save.addActionListener(this);
	    	  this.add(save);
	    	  
	    	  JButton cancel = new JButton();
	    	  cancel.setText("ȡ��");
	    	  cancel.setBounds(190,230, 60, 20);
	    	  cancel.addActionListener(this);
	    	  this.add(cancel);
	    	  //��ť����
    	 this.setSize(400,300);
    	 this.setLocation(200,200);
    	 this.setResizable(false);
    	 this.setVisible(true);
    	 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     }
	
	public static void main(String[] args) {
		try {
			new AddBook();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void actionPerformed(ActionEvent e) {
		
		String command = e.getActionCommand();
	
		if(command.equals("����")){
			if(!textBh.getText().equals("")){
			try {
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				 Connection conn = DriverManager.getConnection("jdbc:odbc:book","sa","");
		    	 Statement stat = conn.createStatement();
		    	 
		    	String    textBh = this.textBh.getText();
				String    textName = this.textName.getText();
				String 	comType = (String)this.comType.getSelectedItem();
				String	  textPrice = this.textPrice.getText();
				String	   textCount= this.textCount.getText();
				String	  textPublish  = this.textPublish.getText();
				String	    textAuthor = this.textAuthor.getText();
				String    textDesc = this.textDesc.getText();
		    	 
		    	    String sql ="insert into book(book_bh,book_name,book_author,book_publish,book_type,book_count,book_price,book_desc)" +
		    	 		"values('"+textBh+"','"+textName+"','"+textAuthor+"','"+textPublish+"','"+comType+"','"+textCount+"','"+textPrice+"','"+textDesc+"')";
		    	int count = stat.executeUpdate(sql);
		    	 if(count == 1){
		    		JOptionPane.showMessageDialog(null,"��ӳɹ�"); 
		    	 }else{
		    		 JOptionPane.showMessageDialog(null,"���ʧ��"); 
		    	 }
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		}else{
				JOptionPane.showMessageDialog(null, "��Ų���Ϊ��");
			}
	    	
		}else{
				textBh.setText("");
			   textName.setText("");
			   textPrice.setText("");
			    textCount.setText("");
			     textPublish.setText("") ;
			    textAuthor.setText("") ;
			    textDesc.setText("") ;
		
	}


		
	}

}
