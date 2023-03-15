package com.example.mysqldb;


import android.util.Log;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySqlHelp {

    public static int getUserSize() {
        final String CLS = "com.mysql.jdbc.Driver";
        final String URL = "jdbc:mysql://192.168.30.60/jinli01";
        final String user = "lmy";
        final String password = "lmy20030222";
        int count = 0;

        try {
            Class.forName(CLS);

            Connection conn = DriverManager.getConnection(URL, user, password);
            String sql = "select count(*) from user";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                count = rs.getInt("count(*)");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

}
