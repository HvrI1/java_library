package com.sx.book;
import com.sx.commom.DBManager;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;


public class FindBookFrame extends JFrame implements MouseListener,ActionListener {
      JTable table;
      JTextField bh;
      JTextField mc;
      JTextField zz;
      JTextField lx;
      JTextField cbs;
      JTextField dj;
      JTextField sl;
      JTextField ms;

	private static final long serialVersionUID = 1L;
	String[][] data =null;
	String[] title = null;
	int count = 0;
	public FindBookFrame(){
    	
    	this.setLayout(null);
         JLabel backImage = new JLabel();
    	 backImage.setBounds(0,0,800,50);
         Icon  img=new  ImageIcon("setup.jpg");
         backImage.setIcon(img);
         this.add(backImage);
       
    	 
    	 this.setTitle("图书信息查询");
    	 title = new String[]{"图书编号","图书名称","图书作者","图书类型","图书出版社","图书单价","图书数量","图书描述"};
    	 try {
			
			ResultSet resCount=DBManager.executeSearch(("select count(*) from book ")); 
			resCount.next();
			count = resCount.getInt(1);
			data = new String [count+1][8];
		
			ResultSet res = DBManager.executeSearch(("select book_id,book_bh,book_name,book_author,book_type,book_publish,book_price,book_count,book_desc from book"));
			int index = 0;
			while(res.next()){
				for(int i = 0; i <8;i++){
					data[index][i] = res.getString(i+2);
				}
				index ++;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 
         table = new JTable(data,title);
         table.addMouseListener(this);
         JScrollPane jsp = new JScrollPane(table);
         jsp.setBounds(100,50,600,250);
       
         this.add(jsp);
         
        
        
         
          //图书信息 1.图书编号 2.图书名称 3.图书类型 4.图书作者
    	 //5.图书出版社6.图书数量 7.图书单价8. 图书描述
         //1.图书编号开始
         JLabel  lBh = new JLabel();
         lBh.setText("图书编号");
         lBh.setBounds(200, 310, 100, 20);
         this.add(lBh);
         
          bh = new JTextField();
         bh.setBounds(300, 310, 200, 20);
         this.add(bh);
         
         //图书编号结束
         
         //2.图书名称开始
         
        JLabel name = new  JLabel();
        name.setText("图书名称");
        name.setBounds(200,340,100,20);
        this.add(name);

        mc = new JTextField();
        mc.setBounds(300,340,200,20);
        this.add(mc);
         //图书名称结束
         
         //3、图书类型开始
        JLabel  tslx = new JLabel();
        tslx.setText("图书类型");
        tslx.setBounds(200,370,100,20);
        this.add(tslx);
        
        lx = new JTextField();
        lx.setBounds(300, 370, 200, 20);
        this.add(lx);
         //图书类型结束
         
         //4.图书作者开始
        JLabel author = new  JLabel();
        author.setText("图书作者");
        author.setBounds(200,400,100,20);
        this.add(author);
        
        zz = new JTextField();
        zz.setBounds(300, 400, 200, 20);
        this.add(zz);
        
         //图书作者结束
         
         //5.图书出版社开始
        JLabel  publish = new JLabel();
        publish.setText("图书出版社");
        publish.setBounds(200, 430, 100, 20);
        this.add(publish);
        
        cbs = new JTextField();
        cbs.setBounds(300, 430, 200, 20);
        this.add(cbs);
         //图书出版社结束
         
         //6.图书数量开始
        JLabel countBook = new JLabel();
        countBook.setText("图书数量");
        countBook.setBounds(200,460,100,20);
        this.add(countBook);
        
        sl = new JTextField();
        sl.setBounds(300, 460, 200, 20);
        this.add(sl);
         //图书数量结束
         
         //7.图书单价开始
        JLabel price = new JLabel();
        price.setText("图书单价");
        price.setBounds(200, 490, 100, 20);
        this.add(price);
        
        dj = new JTextField();
        dj.setBounds(300, 490, 200, 20);
        this.add(dj);
         //图书单价结束
         
         //8.图书描述开始
        JLabel desc =  new JLabel();
        desc.setText("图书描述");
        desc.setBounds(200,520,100,20);
        this.add(desc);
        
         ms = new JTextField();
        ms.setBounds(300,520,200,20);
        this.add(ms);
         //图书描述结束
        
        //添加按钮开始
        JButton add = new JButton();
        add.setText("添加");
        add.setBounds(200, 560, 60, 20);
        add.addActionListener(this);
        this.add(add);
        
        JButton delete = new JButton();
        delete.setText("删除");
        delete.setBounds(270, 560, 60, 20);
        delete.addActionListener(this);
        this.add(delete);
        
        JButton update = new JButton();
        update.setText("修改");
        update.setBounds(340, 560, 60, 20);
        update.addActionListener(this);
        this.add(update);
        
        JButton  cancel = new JButton();
        cancel.setText("取消");
        cancel.setBounds(410, 560, 60, 20);
        cancel.addActionListener(this);
        this.add(cancel);
        //添加按钮结束
    	 this.setSize(800,630);
    	 this.setLocation(100,50);
    	 this.setVisible(true);
    	 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     }

	public static void main(String[] args) {
		
     new FindBookFrame();
     
	}

	public void mouseClicked(MouseEvent arg0) {
     //	图书信息 1.图书编号 2.图书名称 3.图书类型 4.图书作者
   	 //5.图书出版社6.图书数量 7.图书单价8. 图书描述
		if(table.getSelectedRow() != -1){
		   bh.setText((String)table.getValueAt(table.getSelectedRow(), 0));
		   mc.setText((String)table.getValueAt(table.getSelectedRow(), 1));
		   zz.setText((String)table.getValueAt(table.getSelectedRow(), 2));
		   lx.setText((String)table.getValueAt(table.getSelectedRow(), 3));
		   cbs.setText((String)table.getValueAt(table.getSelectedRow(), 4));
		   dj.setText((String)table.getValueAt(table.getSelectedRow(), 5));
		   sl.setText((String)table.getValueAt(table.getSelectedRow(), 6));
		   ms.setText((String)table.getValueAt(table.getSelectedRow(), 7));
		  
		}
	}

	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void actionPerformed(ActionEvent e) {
		 //	图书信息 1.图书编号 2.图书名称 3.图书类型 4.图书作者
	   	 //5.图书出版社6.图书数量 7.图书单价8. 图书描述
		String command = e.getActionCommand();
		if(command.equals("添加")){
			String sql = "insert into book(book_bh,book_name,book_price,book_desc,book_count,book_author,book_publish,book_type)" +
					"values('"+bh.getText()+"','"+mc.getText()+"','"+dj.getText()+"','"+ms.getText()+"','"+sl.getText()+"','"+zz.getText()+"','"+cbs.getText()+"','"+lx.getText()+"')";
		   int count = DBManager.executeUpdate(sql);
		   if(count == 1){
			   JOptionPane.showMessageDialog(null, "添加成功") ;
		   }else{
			   JOptionPane.showMessageDialog(null,"添加失败");
		   }
		}else if(command.equals("删除")){
			String 	sql = "delete from book where book_bh ='"+bh.getText()+"'";
			int count = DBManager.executeUpdate(sql);
			if(count == 1){
				   JOptionPane.showMessageDialog(null, "删除成功") ;
			   }else{
				   JOptionPane.showMessageDialog(null,"删除失败");
			   }
			
		}else if(command.equals("修改")){
			String 	sql = "update  book set book_name='"+mc.getText()+"',book_price='"+dj.getText()+"',book_desc='"+ms.getText()+"',book_count='"+sl.getText()+"',book_author='"+zz.getText()+"',book_publish='"+cbs.getText()+"',book_type='"+lx.getText()+"' where book_bh ='"+bh.getText()+"'";
			int count = DBManager.executeUpdate(sql);
			if(count == 1){
				   JOptionPane.showMessageDialog(null, "修改成功") ;
			   }else{
				   JOptionPane.showMessageDialog(null,"修改失败");
			   }
		}else {
			bh.setText("");
			mc.setText("");
			lx.setText("");
			zz.setText("");
			cbs.setText("");
			sl.setText("");
			dj.setText("");
			ms.setText("");
			
		}
		
	}

}
