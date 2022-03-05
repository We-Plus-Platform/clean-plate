package com.example.save.bean;

public class MyInfoResult extends Result {
    private Property property;

    @Override
    public int getStatus() {
        return super.getStatus();
    }

    @Override
    public void setStatus(int status) {
        super.setStatus(status);
    }

    @Override
    public String getInfor() {
        return super.getInfor();
    }

    @Override
    public void setInfor(String infor) {
        super.setInfor(infor);
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }
}
