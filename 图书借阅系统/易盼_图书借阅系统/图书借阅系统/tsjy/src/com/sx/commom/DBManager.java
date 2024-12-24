package com.sx.commom;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBManager{
   public  static  final String DRIVER = "sun.jdbc.odbc.JdbcOdbcDriver";
   public static  final  String CONNECTION ="jdbc:odbc:book";
   static Connection conn = null;
   static Statement stat = null;
   static ResultSet  res  = null; 
   
    public static void getConnnection(){
    	   
    	try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(CONNECTION,"sa","");
			stat = conn.createStatement();
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
    }
    public  static ResultSet  executeSearch(String sql){
    	try {
    		DBManager.getConnnection();
		  res = stat.executeQuery(sql);
			
		} catch (SQLException e) {
		    
			e.printStackTrace();
		}
		
		return res;
    }
    public static  int executeUpdate(String sql){
    	int count = 0;
    	try{
    		DBManager.getConnnection();
    	count=	stat.executeUpdate(sql);
    	}catch(SQLException e){
    		e.printStackTrace();
    	}
    	return  count;
    }
    public static void ConnClose(){
    	if(res != null){
    		try {
				res.close();
				res = null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
    	}
			if(stat !=  null){
				try {
					stat.close();
					stat = null;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			if(conn != null){
				try {
					conn.close();
					conn = null;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
    	
    	}
    }
  
