package com.sx.users;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.sx.commom.DBManager;

public class IndexUsersFrame extends JFrame  implements ActionListener {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private  String [][] data ;
	private String[] title;
	private  int pageCount = 3;
	private  int currentPage = 1;
    private  int pageSize = 2;
	private  int count = 0;
	private  JTable table;
	private  JScrollPane jsp;

	public IndexUsersFrame(){
    	this.setLayout(null);
    	
    	 data = null;
    	 title = new String [] {"����֤��","֤������","����","Ѻ��","��������"}; 
         data = new String[2][5];
         
         currentPage = 1;
         ResultSet re = DBManager.executeSearch("Select count(*) from users");
         try {
			re.next();
			count = re.getInt(1);
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
         
         pageCount = count % pageSize == 0? count/pageSize:count/pageSize +1;
         String sql = "select top " + pageSize + " users_jyzh,users_zjhm,users_mm,users_yj,users_rq from users";
         ResultSet  res =  DBManager.executeSearch(sql);
         try {
    	  
			for(int row = 0;row < 2 ;row++){
		      if(res.next()){
			    for(int col = 0;col < 5;col++){
			    data[row][col] = res.getString(col+1);
			
			    }
		    }
		}
	} catch (SQLException e1) {
		
		e1.printStackTrace();
	}
          
          table = new JTable(data,title);
         jsp = new JScrollPane(table);
         jsp.setBounds(50, 50,500, 120);
         this.add(jsp);
         
         JButton first = new JButton();
            first.setText("��ҳ");
            first.setBounds(100	,175, 80, 20);
            first.addActionListener(this);
            this.add(first);
            
         JButton prev = new JButton();
         prev.setText("��һҳ");
         prev.setBounds(180, 175, 80, 20);
         this.add(prev);
         prev.addActionListener(this);
         
         JButton next = new JButton();
         next.setText("��һҳ");
         next.setBounds(260,175,80,20);
         next.addActionListener(this);
         this.add(next);
         
         JButton last = new JButton();
         last.setText("ĩҳ");
         last.setBounds(340, 175, 80, 20);
         last.addActionListener(this);
         this.add(last);
         
         
    	
    	this.setTitle("������Ϣ����");
    	this.setBounds(100, 50, 600, 450);
    	this.setResizable(false);
    	this.setVisible(true);
    	this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
         this.addWindowListener(new WindowAdapter(){

			public void windowClosing(WindowEvent e) {
			String  message = "��ȷ���Ƿ�رմ���";
			String title = "��ܰ��ʾ!" ;
	int	res = JOptionPane.showConfirmDialog(null, message,title,JOptionPane.OK_CANCEL_OPTION);
				if(res == 0 ){
		               System.exit(0);
				}
			}
        	 
         });
    }
	
	public static void main(String[] args) {
		
       new IndexUsersFrame();
	}

	public void actionPerformed(ActionEvent e) {
		
		//System.out.println(currentPage+"-1-"+pageSize);
		String command = e.getActionCommand();
		if(command.equals("��ҳ")){
			//JOptionPane.showMessageDialog(null, "��ҳ");
			currentPage = 1;
			
		}else if(command.equals("��һҳ")){
			//JOptionPane.showMessageDialog(null, "��һҳ");
			currentPage --;
			if(currentPage < 1){
				currentPage = 1;
			}
		}else if(command.equals("��һҳ")){
			//JOptionPane.showMessageDialog(null, "��һҳ");
			currentPage = currentPage+1;
			if(currentPage > pageCount){
				currentPage = pageCount;
			}
		}else if(command.equals("ĩҳ")){
			//JOptionPane.showMessageDialog(null, "ĩҳ");
			currentPage = pageCount;
			
		}
		//System.out.println(currentPage+"-2-"+pageSize);
		int   current =  (currentPage-1)*pageSize;
		String sql = " select  top   "+ pageSize+ " users_jyzh,users_zjhm,users_yj,users_mm,users_rq  from  users  where  users_id  not  in  ( select top  "+current+"  users_id  from  users )";
		//System.out.println(sql);
		ResultSet res = DBManager.executeSearch(sql);
		for(int row = 0;row < 2;row++){
			try {
				if(res.next()){
				 for(int col = 0;col < 5;col++){
					 data[row][col] = res.getString(col+1);
				 }
				}else{
					for(int col = 0;col < 5;col++){
						data[row][col] = null;
					}
					
				}
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
		 }
		
		table = new JTable(data,title);
		 jsp = new JScrollPane(table);
        jsp.setBounds(50, 50,500, 120);
        this.add(jsp);
		
	 }
		
}
