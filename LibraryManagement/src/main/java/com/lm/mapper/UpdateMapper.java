package com.lm.mapper;

import com.lm.pojo.Book;
import com.lm.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateMapper {

    public int updateBook(int status, String name){
        Connection conn= null;
        Statement sta= null;
        ResultSet res= null;
        try {
            conn = JdbcUtils.getConnection();//获取连接
            sta =  conn.createStatement();//获得sql的执行对象
            String sql = "update book set status="+status+" where name='"+name+"'";
            int i = sta.executeUpdate(sql);
            if (i>0){
                System.out.println("修改状态成功");
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
