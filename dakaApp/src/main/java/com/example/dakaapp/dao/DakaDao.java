package com.example.dakaapp.dao;

import com.example.dakaapp.database.MySqlHelp;
import com.example.dakaapp.entity.DakaInfo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DakaDao extends MySqlHelp {

    public List<DakaInfo> getAllDakaInfo() {

        List<DakaInfo> list = new ArrayList<>();
        getConnection();
        try {
            String sql = "select * from dakainfo order by shijian;";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()){
                DakaInfo dakaInfo = new DakaInfo();
                dakaInfo.setId(rs.getInt(1));
                dakaInfo.setKeyword(rs.getString(2));
                dakaInfo.setContent(rs.getString(3));
                dakaInfo.setShijian(rs.getInt(4));
                list.add(dakaInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            closeAll();
        }
        return list;
    }

    public void add(DakaInfo dakaInfo) {
        getConnection();
        try {
            String sql = "insert into dakainfo(keyword, content, shijian) values (?, ?, ?);";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, dakaInfo.keyword);
            pstmt.setString(2, dakaInfo.content);
            pstmt.setInt(3, dakaInfo.shijian);
            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll();
        }
    }
    public List<DakaInfo> selAll(){
        getConnection();
        List<DakaInfo> list = new ArrayList<>();
        try {
            String sql = "select * from dakainfo;";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()){
                DakaInfo dakaInfo = new DakaInfo();
                dakaInfo.setId(rs.getInt(1));
                dakaInfo.setKeyword(rs.getString(2));
                dakaInfo.setContent(rs.getString(3));
                dakaInfo.setShijian(rs.getInt(4));
                list.add(dakaInfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll();
        }
        return list;
    }

    public List<DakaInfo> selByKey(String key){
        getConnection();
        List<DakaInfo> list = new ArrayList<>();
        try {
            String sql = "select * from dakainfo where keyword = '" + key + "';";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()){
                DakaInfo dakaInfo = new DakaInfo();
                dakaInfo.setId(rs.getInt(1));
                dakaInfo.setKeyword(rs.getString(2));
                dakaInfo.setContent(rs.getString(3));
                dakaInfo.setShijian(rs.getInt(4));
                list.add(dakaInfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll();
        }
        return list;
    }
    public List<DakaInfo> selByContent(String cont){
        getConnection();
        List<DakaInfo> list = new ArrayList<>();
        try {
            String sql = "select * from dakainfo where content = '" + cont + "';";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()){
                DakaInfo dakaInfo = new DakaInfo();
                dakaInfo.setId(rs.getInt(1));
                dakaInfo.setKeyword(rs.getString(2));
                dakaInfo.setContent(rs.getString(3));
                dakaInfo.setShijian(rs.getInt(4));
                list.add(dakaInfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll();
        }
        return list;
    }

}
