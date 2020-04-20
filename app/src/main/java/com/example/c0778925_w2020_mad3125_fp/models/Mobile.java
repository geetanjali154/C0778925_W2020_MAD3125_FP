package com.example.c0778925_w2020_mad3125_fp.models;

public class Mobile extends Bill  {
    private String mobileManufacturer;
    private String planName;
    private String mobileNumber;
    private int internetGBUsed;
    private int minuteUsed;

    public Mobile(String billId, String billDate, Double ratePerMinute, String mobileManufacturer, String planName, String mobileNumber, int internetGBUsed, int minuteUsed) {
        super(billId, billDate, "Mobile",(ratePerMinute*minuteUsed)+(15*internetGBUsed));
        this.mobileManufacturer = mobileManufacturer;
        this.planName = planName;
        this.mobileNumber = mobileNumber;
        this.internetGBUsed = internetGBUsed;
        this.minuteUsed = minuteUsed;
    }

    public String getMobileManufacturer() {
        return mobileManufacturer;
    }

    public void setMobileManufacturer(String mobileManufacturer) {
        this.mobileManufacturer = mobileManufacturer;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public int getInternetGBUsed() {
        return internetGBUsed;
    }

    public void setInternetGBUsed(int internetGBUsed) {
        this.internetGBUsed = internetGBUsed;
    }

    public int getMinuteUsed() {
        return minuteUsed;
    }

    public void setMinuteUsed(int minuteUsed) {
        this.minuteUsed = minuteUsed;
    }
}
