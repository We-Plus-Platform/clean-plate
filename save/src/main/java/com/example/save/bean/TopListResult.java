package com.example.save.bean;

public class TopListResult extends Result{
    private TopList[] properties;


    @Override
    public void setInfor(String infor) {
        super.setInfor(infor);
    }

    @Override
    public String getInfor() {
        return super.getInfor();
    }

    @Override
    public void setStatus(int status) {
        super.setStatus(status);
    }

    @Override
    public int getStatus() {
        return super.getStatus();
    }

    public TopList[] getProperties() {
        return properties;
    }

    public void setProperties(TopList[] properties) {
        this.properties = properties;
    }
}
