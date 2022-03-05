package com.example.save.bean;

public class Property {
    private String name;
    private String schoolNum;
    private int rice;
    private int lastRice;
    private int myRank;
    private int onceLimit;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRice() {
        return rice;
    }

    public void setRice(int rice) {
        this.rice = rice;
    }

    public int getLastRice() {
        return lastRice;
    }

    public void setLastRice(int lastRice) {
        this.lastRice = lastRice;
    }

    public int getMyRank() {
        return myRank;
    }

    public void setMyRank(int myRank) {
        this.myRank = myRank;
    }

    public String getSchoolNum() {
        return schoolNum;
    }

    public void setSchoolNum(String schoolNum) {
        this.schoolNum = schoolNum;
    }

    public int getOnceLimit() {
        return onceLimit;
    }

    public void setOnceLimit(int onceLimit) {
        this.onceLimit = onceLimit;
    }
}
