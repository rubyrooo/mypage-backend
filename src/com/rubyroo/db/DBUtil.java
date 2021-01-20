package com.rubyroo.db;

import java.sql.*;

public class DBUtil {
    static{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConn(){
        //kkblwj.rwlb.rds.aliyuncs.com
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://mydb-rubyroo.rwlb.rds.aliyuncs.com/mypage", "rubyroo", "rubyrooDB+");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return conn;
    }
    public static void close(Connection conn, Statement state, ResultSet resultSet){
        if(conn!=null) {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(state!=null) {
            try {
                state.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(resultSet!=null) {
            try {
                resultSet.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
