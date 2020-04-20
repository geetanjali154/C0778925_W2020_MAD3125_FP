package com.example.c0778925_w2020_mad3125_fp.models;

import com.example.c0778925_w2020_mad3125_fp.models.Bill;

public class Internet extends Bill {
    private String providerName;
    private int internetGBUsed;

    public Internet(String billId, String billDate, Double pricePerGb, String providerName, int internetGBUsed) {
        super(billId, billDate, "Internet", (pricePerGb*internetGBUsed));
        this.providerName = providerName;
        this.internetGBUsed = internetGBUsed;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public int getInternetGBUsed() {
        return internetGBUsed;
    }

    public void setInternetGBUsed(int internetGBUsed) {
        this.internetGBUsed = internetGBUsed;
    }
}
