package com.example.save.bean;

/**
 * @Author Young
 * @Description 用户信息：姓名、学号、密码、米粒数。
 */
public class User {
    private String name;
    private String schoolNum;
    private String token;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getSchoolNum() {
        return schoolNum;
    }

    public void setSchoolNum(String schoolNum) {
        this.schoolNum = schoolNum;
    }
}
