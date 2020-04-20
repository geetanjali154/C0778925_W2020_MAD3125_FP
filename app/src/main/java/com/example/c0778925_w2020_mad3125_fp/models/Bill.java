package com.example.c0778925_w2020_mad3125_fp.models;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Bill implements Serializable {
    private String billId;
    private String billDate;
    private String billType;
    private Double totalBillAmount;

    public Bill(String billId, String billDate, String billType, Double totalBillAmount) {
        this.billId = billId;
        this.billDate = billDate;
        this.billType = billType;
        this.totalBillAmount = totalBillAmount;
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public String getBillDate() {
        return billDate;
    }

    public void setBillDate(String billDate) {
        this.billDate = billDate;
    }

    public String getBillType() {
        return billType;
    }

   
}
