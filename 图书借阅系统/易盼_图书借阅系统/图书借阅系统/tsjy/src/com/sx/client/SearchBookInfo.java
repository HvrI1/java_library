package com.sx.client;


import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import com.sx.commom.DBManager;

public class SearchBookInfo extends JFrame implements ActionListener,MouseListener {
     
	private static final long serialVersionUID = 1L;
	String [] title = null;
	String [][]data = null;
	JTextField  name ,author,publish;
	JComboBox  type ,mode;
	JTable table;
	JScrollPane  jsp;
	JButton lend,back;
	public SearchBookInfo(){
		
		this.getContentPane().setBackground(new Color(100,200,100));
		Image icon =new ImageIcon("logo.jpg").getImage();
		 this.setIconImage(icon);
		 JMenuBar mb = new JMenuBar();
		
		 JMenu mn =new  JMenu("系统");
		 
		 JMenuItem mi= new JMenuItem("退出系统");
		 mi.addActionListener(this);
		 mn.add(mi);
		 mi = new JMenuItem("修改密码"); 
		 mi.addActionListener(this);
		 mn.add(mi);
		 
		 mb.add(mn);
		 this.setJMenuBar(mb);
		 
		 JToolBar tb = new JToolBar();
		 JButton bt = new JButton();
		    bt.setText("退出");
		    tb.add(bt);
		    tb.setBounds(10, 10, 100, 20);
		    this.add(tb);
		 
    	  this.setLayout(null);
    	  this.setTitle("图书检索");
    	  //读书名称  读书作者  读书出版社  图书类型  搜索模式
    	  //读书名称开始
    	  JLabel bookName = new JLabel();
    	  bookName.setText("读书名称:");
    	  bookName.setBounds(100, 50, 100, 20);
    	  this.add(bookName);
    	  
    	   name = new JTextField();
    	  name.setBounds(200, 50, 200, 20);
    	  this.add(name);
    	  //读书名称结束
    	  
    	  //读书作者开始
    	  JLabel bookAuthor = new JLabel();
    	   bookAuthor.setText("读书作者:");
    	   bookAuthor.setBounds(450,50, 100, 20);
    	   this.add(bookAuthor);
    	   
    	   author = new JTextField();
    	   author.setBounds(550, 50, 200, 20);
    	   this.add(author);
    	   
    	  //读书作者结束
    	  
    	  //读书出版社开始
    	   JLabel bookPublish = new JLabel();
    	     bookPublish.setText("读书出版社：");
    	     bookPublish.setBounds(100, 80, 100, 20);
    	     this.add(bookPublish);
    	     
    	     publish = new JTextField();
    	     publish.setBounds(200, 80, 200, 20);
    	     this.add(publish);
    	   //读书出版社结束
    	  
    	  //读书类型开始
    	     JLabel bookType = new JLabel();
    	     bookType.setText("读书类型：");
    	     bookType.setBounds(450, 80, 100, 20);
    	     this.add(bookType);
    	     
    	       type = new JComboBox();
    	     type.addItem("请选择");
    	     String sql = "select distinct book_type from book";
    	     ResultSet res = DBManager.executeSearch(sql);
    	     try {
				while(res.next()){
					 type.addItem(res.getString(1));
				 }
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
    	     type.setBounds(550, 80, 200, 20);
    	     this.add(type);
    	  //读书类型结束
    	  
    	  //搜索模式开始
    	     JLabel findMode = new JLabel();
    	     findMode.setText("搜索模式：");
    	     findMode.setBounds(100, 110, 100, 20);
    	     this.add(findMode);
    	     
    	      mode = new JComboBox();
    	     mode.setBounds(200, 110, 200, 20);
    	     mode.addItem("请选择");
    	     mode.addItem("精确查询");
    	     mode.addItem("模糊查询");
    	     this.add(mode);
    	     
    	    //搜索模式结束
    	     
    	     //按钮开始
    	     JButton  find = new JButton();
    	     find.setText("查询");
    	     find.setBounds(550, 110, 80, 20);
    	     find.addActionListener(this);
    	     this.add(find);
    	     
    	     
    	     //按钮结束
    	     
    	     //JTable开始
    	     title = new String[]{"读书名称",  "读书作者",  "读书出版社",  "图书类型",
    	    		 "读书数量", "读书馆藏", "借书日期", "还书日期"};
    	     data = new String[10][8] ;
    	       table = new JTable(data,title);
    	       table.addMouseListener(this);
    	      jsp = new JScrollPane(table);
    	      jsp.setBounds(100, 140,600, 300);
    	      this.add(jsp);
    	     //JTable结束
    	      
    	      lend = new JButton();
    	      lend.setText("借书");
    	      lend.setBounds(200, 480, 80, 20);
    	      lend.setEnabled(false);
    	      this.add(lend);
    	      
    	      back = new JButton();
    	      back.setText("还书");
    	      back.setBounds(300, 480, 80, 20);
    	      back.setEnabled(false);
    	      this.add(back);
    	      
    	  this.setBounds(100, 50, 800, 600);
    	  this.setResizable(false);
    	  this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    	  
    	  this.addWindowListener(new WindowAdapter(){
    		 public void windowClosing(WindowEvent e){
    		 if(JOptionPane.showConfirmDialog(null,"请确认关闭窗口","温馨提示！",JOptionPane.OK_CANCEL_OPTION) ==0){
    			  System.exit(0);
    			  }
    		  }
    	  });
    	  
    	  this.setVisible(true);
      }
      public static void main(String []args){
    	  new FindBookInfo();
        }
	  public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if(command.equals("查询")){
        //"读书名称",  "读书作者",  "读书出版社",  "图书类型","读书数量", "读书馆藏", "借书日期", "还书日期"
	    if(!name.getText().equals("")||!author.getText().equals("")||!publish.getText().equals("")||!type.getSelectedItem().equals("请选择")&&!type.getSelectedItem().equals("精确查询")){
		String sql =" select book_name,book_author,book_publish,book_type,book_count,book_count -(select count(*) from borrowbook where borrowbook_tsbh =book.book_bh) as 图书馆藏,getDate()   as 借书日期,getDate()+20  as 还书日期  from book where 1=1";
		if(!type.getSelectedItem().equals("精确查询")){
			if(!name.getText().equals("")){
			   sql =sql+ "  and  book_name  like   '%"+name.getText()+"%'";
			}
			if(!author.getText().equals("")){
				sql = sql + " and book_author like '%"+author.getText()+"%'";
			}
			if(!publish.getText().equals("")){
				sql = sql + " and book_publish   like '%"+publish.getText()+"%'";
			
			}
			if(!type.getSelectedItem().equals("请选择")){
				sql = sql +"  and book_type   like '%"+type.getSelectedItem()+"%'";
			}
		}else{
			if(!name.getText().equals("")){
				sql = sql +" and book_name = '"+name.getText()+"'";
			}
			if(!author.getText().equals("")){
				sql= sql +" and book_author = '"+author.getText()+"' ";
			}
			if(!publish.getText().equals("")){
				sql = sql + " and book_author ='"+publish.getText()+"'";
			}
			if(!type.getSelectedItem().equals("请选择")){
				sql = sql +" and  book_type  ='"+type.getSelectedItem()+"'";
			}
			
		}
	     //System.out.println(sql);
		 ResultSet res =  DBManager.executeSearch(sql);
		 try {
			int index = 0;
			if(res.next()){
				JOptionPane.showMessageDialog(null, "恭喜您！查询成功！");
			}else{
				JOptionPane.showMessageDialog(null, "对不起！查询失败！");
			}
			while(res.next()){
				for(int col = 0;col < 8 ;col++ ){
				data[index][col] = res.getString(col+1);
				}
				index++;
			 }
			//System.out.println(sql);
			table = new JTable(data,title);
			jsp = new JScrollPane(table);
			jsp.setBounds(100, 140,600, 300);
  	        this.add(jsp);
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
	}else{
		JOptionPane.showMessageDialog(null, "请输入搜索信息");
	   }	  
	}else if(command.equals("退出系统")){
	int result=	JOptionPane.showConfirmDialog(null, "确认退出系统","温馨提示",JOptionPane.OK_CANCEL_OPTION);
	if(result == 0){
		System.exit(0);
	}
	}	  
	else if(command.equals("修改密码")){
		
	}
	  }
	public void mouseClicked(MouseEvent arg0) {
		lend.setEnabled(true);
		back.setEnabled(true);
		
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
