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
       
    	 
    	 this.setTitle("ͼ����Ϣ��ѯ");
    	 title = new String[]{"ͼ����","ͼ������","ͼ������","ͼ������","ͼ�������","ͼ�鵥��","ͼ������","ͼ������"};
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
         
        
        
         
          //ͼ����Ϣ 1.ͼ���� 2.ͼ������ 3.ͼ������ 4.ͼ������
    	 //5.ͼ�������6.ͼ������ 7.ͼ�鵥��8. ͼ������
         //1.ͼ���ſ�ʼ
         JLabel  lBh = new JLabel();
         lBh.setText("ͼ����");
         lBh.setBounds(200, 310, 100, 20);
         this.add(lBh);
         
          bh = new JTextField();
         bh.setBounds(300, 310, 200, 20);
         this.add(bh);
         
         //ͼ���Ž���
         
         //2.ͼ�����ƿ�ʼ
         
        JLabel name = new  JLabel();
        name.setText("ͼ������");
        name.setBounds(200,340,100,20);
        this.add(name);

        mc = new JTextField();
        mc.setBounds(300,340,200,20);
        this.add(mc);
         //ͼ�����ƽ���
         
         //3��ͼ�����Ϳ�ʼ
        JLabel  tslx = new JLabel();
        tslx.setText("ͼ������");
        tslx.setBounds(200,370,100,20);
        this.add(tslx);
        
        lx = new JTextField();
        lx.setBounds(300, 370, 200, 20);
        this.add(lx);
         //ͼ�����ͽ���
         
         //4.ͼ�����߿�ʼ
        JLabel author = new  JLabel();
        author.setText("ͼ������");
        author.setBounds(200,400,100,20);
        this.add(author);
        
        zz = new JTextField();
        zz.setBounds(300, 400, 200, 20);
        this.add(zz);
        
         //ͼ�����߽���
         
         //5.ͼ������翪ʼ
        JLabel  publish = new JLabel();
        publish.setText("ͼ�������");
        publish.setBounds(200, 430, 100, 20);
        this.add(publish);
        
        cbs = new JTextField();
        cbs.setBounds(300, 430, 200, 20);
        this.add(cbs);
         //ͼ����������
         
         //6.ͼ��������ʼ
        JLabel countBook = new JLabel();
        countBook.setText("ͼ������");
        countBook.setBounds(200,460,100,20);
        this.add(countBook);
        
        sl = new JTextField();
        sl.setBounds(300, 460, 200, 20);
        this.add(sl);
         //ͼ����������
         
         //7.ͼ�鵥�ۿ�ʼ
        JLabel price = new JLabel();
        price.setText("ͼ�鵥��");
        price.setBounds(200, 490, 100, 20);
        this.add(price);
        
        dj = new JTextField();
        dj.setBounds(300, 490, 200, 20);
        this.add(dj);
         //ͼ�鵥�۽���
         
         //8.ͼ��������ʼ
        JLabel desc =  new JLabel();
        desc.setText("ͼ������");
        desc.setBounds(200,520,100,20);
        this.add(desc);
        
         ms = new JTextField();
        ms.setBounds(300,520,200,20);
        this.add(ms);
         //ͼ����������
        
        //��Ӱ�ť��ʼ
        JButton add = new JButton();
        add.setText("���");
        add.setBounds(200, 560, 60, 20);
        add.addActionListener(this);
        this.add(add);
        
        JButton delete = new JButton();
        delete.setText("ɾ��");
        delete.setBounds(270, 560, 60, 20);
        delete.addActionListener(this);
        this.add(delete);
        
        JButton update = new JButton();
        update.setText("�޸�");
        update.setBounds(340, 560, 60, 20);
        update.addActionListener(this);
        this.add(update);
        
        JButton  cancel = new JButton();
        cancel.setText("ȡ��");
        cancel.setBounds(410, 560, 60, 20);
        cancel.addActionListener(this);
        this.add(cancel);
        //��Ӱ�ť����
    	 this.setSize(800,630);
    	 this.setLocation(100,50);
    	 this.setVisible(true);
    	 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     }

	public static void main(String[] args) {
		
     new FindBookFrame();
     
	}

	public void mouseClicked(MouseEvent arg0) {
     //	ͼ����Ϣ 1.ͼ���� 2.ͼ������ 3.ͼ������ 4.ͼ������
   	 //5.ͼ�������6.ͼ������ 7.ͼ�鵥��8. ͼ������
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
		 //	ͼ����Ϣ 1.ͼ���� 2.ͼ������ 3.ͼ������ 4.ͼ������
	   	 //5.ͼ�������6.ͼ������ 7.ͼ�鵥��8. ͼ������
		String command = e.getActionCommand();
		if(command.equals("���")){
			String sql = "insert into book(book_bh,book_name,book_price,book_desc,book_count,book_author,book_publish,book_type)" +
					"values('"+bh.getText()+"','"+mc.getText()+"','"+dj.getText()+"','"+ms.getText()+"','"+sl.getText()+"','"+zz.getText()+"','"+cbs.getText()+"','"+lx.getText()+"')";
		   int count = DBManager.executeUpdate(sql);
		   if(count == 1){
			   JOptionPane.showMessageDialog(null, "��ӳɹ�") ;
		   }else{
			   JOptionPane.showMessageDialog(null,"���ʧ��");
		   }
		}else if(command.equals("ɾ��")){
			String 	sql = "delete from book where book_bh ='"+bh.getText()+"'";
			int count = DBManager.executeUpdate(sql);
			if(count == 1){
				   JOptionPane.showMessageDialog(null, "ɾ���ɹ�") ;
			   }else{
				   JOptionPane.showMessageDialog(null,"ɾ��ʧ��");
			   }
			
		}else if(command.equals("�޸�")){
			String 	sql = "update  book set book_name='"+mc.getText()+"',book_price='"+dj.getText()+"',book_desc='"+ms.getText()+"',book_count='"+sl.getText()+"',book_author='"+zz.getText()+"',book_publish='"+cbs.getText()+"',book_type='"+lx.getText()+"' where book_bh ='"+bh.getText()+"'";
			int count = DBManager.executeUpdate(sql);
			if(count == 1){
				   JOptionPane.showMessageDialog(null, "�޸ĳɹ�") ;
			   }else{
				   JOptionPane.showMessageDialog(null,"�޸�ʧ��");
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
