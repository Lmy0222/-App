package com.example.dakaapp.entity;

import android.content.Intent;

import java.io.Serializable;
import java.sql.Date;


public class DakaInfo  implements Serializable {
    public Integer id;
    public String keyword;
    public String content;
    public int shijian;

    public DakaInfo() {
    }

    public DakaInfo(Integer id, String keyword, String content, int shijian) {
        this.id = id;
        this.keyword = keyword;
        this.content = content;
        this.shijian = shijian;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getShijian() {
        return shijian;
    }

    @Override
    public String toString() {
        return "DakaInfo{" +
                "id=" + id +
                ", keyword='" + keyword + '\'' +
                ", content='" + content + '\'' +
                ", shijian=" + shijian +
                '}';
    }

    public void setShijian(int shijian) {
        this.shijian = shijian;
    }
}
