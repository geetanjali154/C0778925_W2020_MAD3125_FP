package com.example.c0778925_w2020_mad3125_fp.models;

import com.example.c0778925_w2020_mad3125_fp.models.Bill;

public class Hydro extends Bill {
    private String agencyName;
    private int unitConsumed;

    public Hydro(String billId, String billDate,Double unitPrice, String agencyName, int unitConsumed) {
        super(billId, billDate, "Hydro", unitPrice*unitConsumed);
        this.agencyName = agencyName;
        this.unitConsumed = unitConsumed;

    }

    public String getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    public int getUnitConsumed() {
        return unitConsumed;
    }

    public void setUnitConsumed(int unitConsumed) {
        this.unitConsumed = unitConsumed;
    }
}