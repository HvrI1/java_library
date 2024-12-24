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
		
		 JMenu mn =new  JMenu("ϵͳ");
		 
		 JMenuItem mi= new JMenuItem("�˳�ϵͳ");
		 mi.addActionListener(this);
		 mn.add(mi);
		 mi = new JMenuItem("�޸�����"); 
		 mi.addActionListener(this);
		 mn.add(mi);
		 
		 mb.add(mn);
		 this.setJMenuBar(mb);
		 
		 JToolBar tb = new JToolBar();
		 JButton bt = new JButton();
		    bt.setText("�˳�");
		    tb.add(bt);
		    tb.setBounds(10, 10, 100, 20);
		    this.add(tb);
		 
    	  this.setLayout(null);
    	  this.setTitle("ͼ�����");
    	  //��������  ��������  ���������  ͼ������  ����ģʽ
    	  //�������ƿ�ʼ
    	  JLabel bookName = new JLabel();
    	  bookName.setText("��������:");
    	  bookName.setBounds(100, 50, 100, 20);
    	  this.add(bookName);
    	  
    	   name = new JTextField();
    	  name.setBounds(200, 50, 200, 20);
    	  this.add(name);
    	  //�������ƽ���
    	  
    	  //�������߿�ʼ
    	  JLabel bookAuthor = new JLabel();
    	   bookAuthor.setText("��������:");
    	   bookAuthor.setBounds(450,50, 100, 20);
    	   this.add(bookAuthor);
    	   
    	   author = new JTextField();
    	   author.setBounds(550, 50, 200, 20);
    	   this.add(author);
    	   
    	  //�������߽���
    	  
    	  //��������翪ʼ
    	   JLabel bookPublish = new JLabel();
    	     bookPublish.setText("��������磺");
    	     bookPublish.setBounds(100, 80, 100, 20);
    	     this.add(bookPublish);
    	     
    	     publish = new JTextField();
    	     publish.setBounds(200, 80, 200, 20);
    	     this.add(publish);
    	   //������������
    	  
    	  //�������Ϳ�ʼ
    	     JLabel bookType = new JLabel();
    	     bookType.setText("�������ͣ�");
    	     bookType.setBounds(450, 80, 100, 20);
    	     this.add(bookType);
    	     
    	       type = new JComboBox();
    	     type.addItem("��ѡ��");
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
    	  //�������ͽ���
    	  
    	  //����ģʽ��ʼ
    	     JLabel findMode = new JLabel();
    	     findMode.setText("����ģʽ��");
    	     findMode.setBounds(100, 110, 100, 20);
    	     this.add(findMode);
    	     
    	      mode = new JComboBox();
    	     mode.setBounds(200, 110, 200, 20);
    	     mode.addItem("��ѡ��");
    	     mode.addItem("��ȷ��ѯ");
    	     mode.addItem("ģ����ѯ");
    	     this.add(mode);
    	     
    	    //����ģʽ����
    	     
    	     //��ť��ʼ
    	     JButton  find = new JButton();
    	     find.setText("��ѯ");
    	     find.setBounds(550, 110, 80, 20);
    	     find.addActionListener(this);
    	     this.add(find);
    	     
    	     
    	     //��ť����
    	     
    	     //JTable��ʼ
    	     title = new String[]{"��������",  "��������",  "���������",  "ͼ������",
    	    		 "��������", "����ݲ�", "��������", "��������"};
    	     data = new String[10][8] ;
    	       table = new JTable(data,title);
    	       table.addMouseListener(this);
    	      jsp = new JScrollPane(table);
    	      jsp.setBounds(100, 140,600, 300);
    	      this.add(jsp);
    	     //JTable����
    	      
    	      lend = new JButton();
    	      lend.setText("����");
    	      lend.setBounds(200, 480, 80, 20);
    	      lend.setEnabled(false);
    	      this.add(lend);
    	      
    	      back = new JButton();
    	      back.setText("����");
    	      back.setBounds(300, 480, 80, 20);
    	      back.setEnabled(false);
    	      this.add(back);
    	      
    	  this.setBounds(100, 50, 800, 600);
    	  this.setResizable(false);
    	  this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    	  
    	  this.addWindowListener(new WindowAdapter(){
    		 public void windowClosing(WindowEvent e){
    		 if(JOptionPane.showConfirmDialog(null,"��ȷ�Ϲرմ���","��ܰ��ʾ��",JOptionPane.OK_CANCEL_OPTION) ==0){
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
		if(command.equals("��ѯ")){
        //"��������",  "��������",  "���������",  "ͼ������","��������", "����ݲ�", "��������", "��������"
	    if(!name.getText().equals("")||!author.getText().equals("")||!publish.getText().equals("")||!type.getSelectedItem().equals("��ѡ��")&&!type.getSelectedItem().equals("��ȷ��ѯ")){
		String sql =" select book_name,book_author,book_publish,book_type,book_count,book_count -(select count(*) from borrowbook where borrowbook_tsbh =book.book_bh) as ͼ��ݲ�,getDate()   as ��������,getDate()+20  as ��������  from book where 1=1";
		if(!type.getSelectedItem().equals("��ȷ��ѯ")){
			if(!name.getText().equals("")){
			   sql =sql+ "  and  book_name  like   '%"+name.getText()+"%'";
			}
			if(!author.getText().equals("")){
				sql = sql + " and book_author like '%"+author.getText()+"%'";
			}
			if(!publish.getText().equals("")){
				sql = sql + " and book_publish   like '%"+publish.getText()+"%'";
			
			}
			if(!type.getSelectedItem().equals("��ѡ��")){
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
			if(!type.getSelectedItem().equals("��ѡ��")){
				sql = sql +" and  book_type  ='"+type.getSelectedItem()+"'";
			}
			
		}
	     //System.out.println(sql);
		 ResultSet res =  DBManager.executeSearch(sql);
		 try {
			int index = 0;
			if(res.next()){
				JOptionPane.showMessageDialog(null, "��ϲ������ѯ�ɹ���");
			}else{
				JOptionPane.showMessageDialog(null, "�Բ��𣡲�ѯʧ�ܣ�");
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
		JOptionPane.showMessageDialog(null, "������������Ϣ");
	   }	  
	}else if(command.equals("�˳�ϵͳ")){
	int result=	JOptionPane.showConfirmDialog(null, "ȷ���˳�ϵͳ","��ܰ��ʾ",JOptionPane.OK_CANCEL_OPTION);
	if(result == 0){
		System.exit(0);
	}
	}	  
	else if(command.equals("�޸�����")){
		
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
