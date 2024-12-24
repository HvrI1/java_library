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
    	 this.setTitle("图书信息添加");
    	 //图书信息 1.图书编号 2.图书名称 3.图书类型 4.图书单价 5.图书数量6.图书出版社7.图书作者8.图书描述
    	 //1.图书编号开始
	    	  JLabel bh = new JLabel();
	    	  bh.setText("图书编号：");
	    	  bh.setBounds(10,10,100,20);
	    	  this.add(bh);
	    	 
	    	 textBh = new JTextField();
	    	  textBh.setBounds(110,10,200,20);
	    	  this.add(textBh);
    	 //图书编号结束
    	    
    	  //2.图书名称开始
	    	  JLabel name = new JLabel();
	    	  name.setText("图书名称：");
	    	  name.setBounds(10,35,100,20);
	    	  this.add(name);
	    	  
	    	  textName = new JTextField();
	    	  textName.setBounds(110,35,200,20);
	    	  this.add(textName);
	      //图书名称结束
	    	  
	      //3.图书类型开始
	    	  JLabel type = new JLabel();
	    	  type.setText("图书类型：");
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
    	   //图书类型结束
	    	  
	    	  //4.图书单价开始
	    	  JLabel price =new JLabel();
	    	  price.setText("图书单价：");
	    	  price.setBounds(10,85,100,20);
	    	  this.add(price);
	    	  
	    	   textPrice= new JTextField();
	    	  textPrice.setBounds(110,85,200,20);
	    	  this.add(textPrice);
	    	  //图书单价结束
	    	  
	    	  //5.图书数量开始
	    	  JLabel count =new JLabel();
	    	  count.setText("图书数量：");
	    	  count.setBounds(10,110,100,20);
	    	  this.add(count);
	    	  
	    	   textCount= new JTextField();
	    	  textCount.setBounds(110,110,200,20);
	    	  this.add( textCount);
	    	  //图书数量结束
	    	  
	    	  //6.图书出版社开始
	    	  JLabel publish =new JLabel();
	    	  publish .setText("图书出版社：");
	    	  publish .setBounds(10,135,100,20);
	    	  this.add(publish );
	    	  
	    	  textPublish = new JTextField();
	    	  textPublish.setBounds(110,135,200,20);
	    	  this.add( textPublish);
	    	  //图书出版社结束
	    	  
            	//7.图书作者开始
	    	  JLabel author =new JLabel();
	    	  author .setText("图书作者：");
	    	  author .setBounds(10,160,100,20);
	    	  this.add(author );
	    	  
	    	  textAuthor = new JTextField();
	    	  textAuthor.setBounds(110,160,200,20);
	    	  this.add( textAuthor);
	    	  //图书作者结束
	    	  
	    	  //8.图书描述开始
	    	  JLabel desc =new JLabel();
	    	 desc.setText("图书描述：");
	    	 desc.setBounds(10,185,100,20);
	    	  this.add(desc);
	    	  
	    	   textDesc = new JTextArea();
	    	  textDesc.setBounds(110,185,200,40);
	    	  this.add( textDesc);
	    	  //图书描述结束
	    	  
	    	  //按钮开始
	    	  JButton save = new JButton();
	    	  save.setText("保存");
	    	  save.setBounds(120,230, 60, 20);
	    	  save.addActionListener(this);
	    	  this.add(save);
	    	  
	    	  JButton cancel = new JButton();
	    	  cancel.setText("取消");
	    	  cancel.setBounds(190,230, 60, 20);
	    	  cancel.addActionListener(this);
	    	  this.add(cancel);
	    	  //按钮结束
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
	
		if(command.equals("保存")){
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
		    		JOptionPane.showMessageDialog(null,"添加成功"); 
		    	 }else{
		    		 JOptionPane.showMessageDialog(null,"添加失败"); 
		    	 }
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		}else{
				JOptionPane.showMessageDialog(null, "编号不能为空");
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
