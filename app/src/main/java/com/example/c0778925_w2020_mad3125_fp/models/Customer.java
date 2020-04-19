package com.example.c0778925_w2020_mad3125_fp.models;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Customer implements Serializable {
    private String customerId;
    private String firstName;
    private String lastName;
    private String fullName;
    private String email;
    private HashMap<String, Bill> bills = new HashMap<>();
    private Double totalAmountToPay = 0.0;

    public Customer(String customerId, String firstName, String lastName, String email) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = calculateFullName();
        this.email = email;
//        this.bills = bills;
//        this.totalAmountToPay = totalAmountToPay;
    }

    public void addBill(String billId, Bill bill){
        this.bills.put(billId,bill);
        totalAmountToPay = totalAmountToPay + bill.getTotalBillAmount();
    }

    public ArrayList<Bill> getAllBills(){       //http://mandarshinde.com/convert-hashmap-arraylist/
        Collection<Bill> collection = bills.values();
        ArrayList<Bill> billArrayList = new ArrayList<Bill>(collection);
        return billArrayList;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public HashMap<String, Bill> getBills() {
        return bills;
    }

    public void setBills(HashMap<String, Bill> bills) {
        this.bills = bills;
    }

    public Double getTotalAmountToPay() {
        return totalAmountToPay;
    }

    public void setTotalAmountToPay(Double totalAmountToPay) {
        this.totalAmountToPay = totalAmountToPay;
    }

    private String calculateFullName(){
        String fullName;
        fullName = firstName + " " + lastName;
        return fullName;
    }


}

