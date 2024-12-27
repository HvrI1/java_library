package com.lm.mapper;

import com.lm.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteMapper {
    public int deleteBook(String name){
        Connection conn= null;
        Statement sta= null;
        ResultSet res= null;
        try {
            conn = JdbcUtils.getConnection();//获取连接
            sta =  conn.createStatement();//获得sql的执行对象
            String sql = "delete from book where name = '"+name+"'";
            int i = sta.executeUpdate(sql);
            if (i>0){
                System.out.println("删除成功");
                return 1;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcUtils.release(conn,sta,null);
        }
        return 0;
    }
}
