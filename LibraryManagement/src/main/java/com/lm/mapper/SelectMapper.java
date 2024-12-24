package com.lm.mapper;

import com.lm.pojo.Book;
import com.lm.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SelectMapper {


    public ArrayList<Book> selectAllBook(){
        Connection conn= null;
        Statement sta= null;
        ResultSet res= null;
        ArrayList<Book> books = new ArrayList<>();
        try {
            conn = JdbcUtils.getConnection();//获取连接
            sta =  conn.createStatement();//获得sql的执行对象
            String sql = "select `name`,price,type,status from book ";
            res = sta.executeQuery(sql);
            while (res.next()){
                books.add(new Book(res.getString("name"),res.getInt("price"),res.getString("type"),res.getInt("status")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcUtils.release(conn,sta,res);
        }
        return books;
    }

    public Book selectByNameBook(String name){
        Connection conn= null;
        Statement sta= null;
        ResultSet res= null;
        Book book = new Book();
        try {
            conn = JdbcUtils.getConnection();//获取连接
            sta =  conn.createStatement();//获得sql的执行对象
            String sql = "select * from book where `name` ='"+name+"'";
            res= sta.executeQuery(sql);
            while (res.next()){
                book.setName(res.getString("name"));
                book.setPrice(res.getInt("price"));
                book.setType(res.getString("type"));
                book.setStatus(res.getInt("status"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcUtils.release(conn,sta,res);
        }
        return book;
    }


}
