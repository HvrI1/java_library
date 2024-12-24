package com.sx.users;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.sx.commom.DBManager;

public class SignUsers extends JFrame implements ActionListener{
	  JTextField  bh;
     public SignUsers(){
    	 this.setLayout(null);
    	 
    	  JLabel  zjhm = new JLabel();
          zjhm.setText("证件编号");
          zjhm.setBounds(10,10,100	, 20);
          this.add(zjhm);
          
           bh = new JTextField();
          bh.setBounds(110,10, 200, 20);
          this.add(bh);
          
          JButton jc = new JButton();
          jc.setText("办理借阅证");
          jc.setBounds(310,10,100,20);
          this.add(jc);
          jc.addActionListener(this);
                        
          
          
                
    	 this.setBounds(300,200,500,350 );
    	 this.setResizable(false);
    	 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	 this.setVisible(true);
     }
	public static void main(String[] args) {
		     new SignUsers();

	}
	public void actionPerformed(ActionEvent arg0) {
		if(bh.getText().length() == 18){
		   String sql = "select * from  users where users_zjhm ='"+bh.getText()+"'";
		     ResultSet  res =  DBManager.executeSearch(sql);
		     try {
		    	 
				if(res.next()){
					  JOptionPane.showMessageDialog(null, "该办理借阅证！");
				}else{
					String sqlCount = "select count(*) from users ";
				    ResultSet re =	DBManager.executeSearch(sqlCount);
				    re.next();
			        int	count = re.getInt(1)+1;
			        String card = "0000"+count;
					String sqlUser = "insert into users(users_jyzh,users_zjhm,users_mm,users_yj,users_rq)" +
							" values('"+card+"','"+bh.getText()+"','"+"000000"+"',100,'"+"2011-7-5"+"')";
				   int    result=	DBManager.executeUpdate(sqlUser);
				   if(result == 1 )
				   {
					 JOptionPane.showMessageDialog(null, "办理成功!您的借书证号为0000"+count+"初始密码为："+"000000");
				   }
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		}else{
			JOptionPane.showMessageDialog(null,"对不起！请输入有效证件");
		}
		    
	}

}
