package com.utils;

import java.sql.*;

public class DBUtils {
    static final String driver = "com.mysql.cj.jdbc.Driver";
    static final String url = "jdbc:mysql://localhost:3306/library_wangming?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";


    // 数据库的用户名与密码，需要根据自己的设置
    static final String user = "root";
    static final String password = "123456";

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(driver);//加载MySQL驱动
        Connection conn = DriverManager.getConnection(url, user, password);
        return conn;
    }

    public static ResultSet query(Connection conn, String sql, Object... args) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(sql);
        if(args!=null && args.length>0){
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1, args[i]);
            }
        }
        ResultSet rs = ps.executeQuery();
        return rs;
    }
    public static int update(Connection conn, String sql, Object... args) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(sql);
        if(args!=null && args.length>0){
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1, args[i]);
            }
        }
        int column = ps.executeUpdate();
        return column;
    }

    public static boolean closeResource(ResultSet resultSet, PreparedStatement ps, Connection conn) {
        boolean flag = true;
        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException throwables) {
            flag = false;
            throwables.printStackTrace();
        }

        try {
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException throwables) {
            flag = false;
            throwables.printStackTrace();
        }

        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException throwables) {
            flag = false;
            throwables.printStackTrace();
        }

        return flag;
    }

}
