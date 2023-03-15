package com.example.dakaapp.database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class MySqlHelp {
    private final static String CLS = "com.mysql.jdbc.Driver";
    private final static String URL = "jdbc:mysql://192.168.49.60/jinli01";
    private final static String user = "lmy";
    private final static String password = "lmy20030222";

    public static Connection conn;
    public  static  Statement stmt;
    public  static PreparedStatement pstmt;
    public  static ResultSet rs;

    public static Connection getConnection(){
        try{
            Class.forName(CLS);
            conn = DriverManager.getConnection(URL, user, password);
        }catch (Exception e){
            e.printStackTrace();
        }
        return conn;
    }

    public static void closeAll(){
        try{
            if(rs != null){
                rs.close();
                rs = null;
            }
            if (pstmt != null){
                pstmt.close();
                pstmt = null;
            }
            if (stmt != null){
                stmt.close();
                stmt = null;
            }
            if (conn != null){
                conn.close();
                conn.close();
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }



}
