package com.sx.type;




import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import javax.swing.JTextField;

public class AddTypeInfo  extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//JPanel p = new JPanel();
    // JButton bAdd = new JButton();
	 JTextField nr;
	 JTextArea area;
     public AddTypeInfo(){
    	 
    	 this.setTitle("图书类型添加");
    	 //this.setBackground(Color.black);
    	 this.setLocation(200,200);
    	 this.setSize(400,300);
    	 this.setLayout(null);
    	 JLabel name= new JLabel(); 
    	 name.setBounds(10, 20, 100, 20);
    	 name.setText("图书类型");
    	 nr = new JTextField();
    	 nr.setBounds(110, 20, 200, 20);
    	 this.add(name);
    	 this.add(nr);
    	 JLabel desc = new JLabel();
    	 desc.setBounds(10, 50,100, 20);
    	 desc.setText("图书描述");
    	 this.add(desc);
    	  area = new JTextArea();
    	 area.setBounds(110, 50, 200,150);
    	 this.add(area);
    	 JButton save = new  JButton();
    	 save.setBounds(100,240,80,20);
    	 save.setText("添加");
    	 this.add(save);
    	 JButton cancel = new  JButton();
    	 cancel.setBounds(200,240,80,20);
    	 cancel.setText("取消");
    	 this.add(cancel);
    	// p.add(bAdd);
    	// this.add(p);
    	 this.setBackground(Color.red);
        
    	/* save.addActionListener(new  ActionListener()
    			 {

					public void actionPerformed(ActionEvent arg0) {
						getInfo();
						
					}

					
					}
    	          );*/
    	 
    	/* cancel.addActionListener(new ActionListener()
    	 {

			public void actionPerformed(ActionEvent arg0) {
				
				setInfo();
			}
    		 
    	 });*/
    	 save.addActionListener(this);
    	 cancel.addActionListener(this);
    	 this.setResizable(false);
    	 this.setVisible(true);
    	 
     }
    /*public  void setInfo() {
		nr.setText("");
		area.setText("");
		
	}*/
    /*public  void getInfo() {
			System.out.println(nr.getText());
            System.out.println(area.getText());			
		}*/
	public static void main(String[] args) {
	   new AddTypeInfo();
	}
	
	public void actionPerformed(ActionEvent e) {
		Connection conn = null;
		Statement stat = null;
	  String name = nr.getText();
	  String desc = area.getText();
		/*System.out.println(area.getText());
		System.out.println(e.getActionCommand()+":"+e.paramString());*/
	    String info = e.getActionCommand();
	    if(info.equals("添加")){
	    	if(nr.getText().equals("")||area.getText().equals("")){
	    		JOptionPane.showMessageDialog(null, "图书类型或描述不能为空！");
	    	}else{
	    		try {
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				 conn = DriverManager.getConnection("jdbc:odbc:book","sa","");
				stat = conn.createStatement();
					String sql = "insert into types(types_name,types_desc) values('"+name+"','"+desc+"')";
				  int count = stat.executeUpdate(sql);
				  if(count == 1 ){JOptionPane.showMessageDialog(null, "成功");}
				  else{JOptionPane.showMessageDialog(null, "失败");}
				} catch (ClassNotFoundException e1) {
					
					e1.printStackTrace();
				} catch (SQLException e2) {
					
					e2.printStackTrace();
				}finally{
					if(stat != null){
						try {
							stat.close();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						stat = null;
					}
					if(conn != null){
						try {
							conn.close();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						conn = null;
					}
				}
	    	}
	    	
	    }else{
	    	nr.setText("");
	    	area.setText("");
	    }
	}

}
