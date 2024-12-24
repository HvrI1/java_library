package com.sx.type;




import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import javax.swing.JTextField;

public class AddType extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//JPanel p = new JPanel();
    // JButton bAdd = new JButton();
	 JTextField nr;
	 JTextArea area;
     public AddType(){
    	 
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
        
    	 save.addActionListener(new  ActionListener()
    			 {

					public void actionPerformed(ActionEvent arg0) {
						getInfo();
						
					}

					
					}
    	          );
    	 
    	 cancel.addActionListener(new ActionListener()
    	 {

			public void actionPerformed(ActionEvent arg0) {
				
				setInfo();
			}
    		 
    	 });
    	 this.setVisible(true);
    	 
     }
    public  void setInfo() {
		nr.setText("");
		area.setText("");
		
	}
    public  void getInfo() {
			System.out.println(nr.getText());
            System.out.println(area.getText());			
		}
	public static void main(String[] args) {
	   new AddType();
	}

}
