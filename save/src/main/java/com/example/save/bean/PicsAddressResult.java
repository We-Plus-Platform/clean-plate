package com.example.save.bean;

public class PicsAddressResult extends Result {
    private PicsAddress[] picsAddress;

    @Override
    public int getStatus() {
        return super.getStatus();
    }

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

    public PicsAddress[] getPicsAddress() {
        return picsAddress;
    }

    public void setPicsAddress(PicsAddress[] picsAddress) {
        this.picsAddress = picsAddress;
    }
}
