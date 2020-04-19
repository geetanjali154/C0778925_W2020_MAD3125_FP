package com.example.c0778925_w2020_mad3125_fp.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class DataStorage {
    private static DataStorage dataStorage = new DataStorage();
    //private ArrayList<Customer> customer = new ArrayList<>();
    private HashMap<String, Customer> customers = new HashMap<>();

    public DataStorage() {
    }

    public static DataStorage getInstance(){
        return dataStorage;
    }

    public void addCustomer(String customerId, Customer customer1){
        this.customers.put(customerId,customer1);
    }

    public ArrayList<Customer> getCustomer(){       // //http://mandarshinde.com/convert-hashmap-arraylist/
        Collection<Customer> collection = customers.values();
        ArrayList<Customer> customerArrayList = new ArrayList<Customer>(collection);
        return customerArrayList;
    }

    public void loadDetails(){
        Customer customer1 = new Customer("C0001","Geetanjali","Gupta","geet@gmail.com");
        Customer customer2 = new Customer("C0002","Manbeer","Kaur","mnbeer@yahoo.com");
        Customer customer3 = new Customer("C0003","Komal","Kaur","kkaur@yahoo.com");
        Customer customer4 = new Customer("C0004","Gagan","Deep","gagan154@yahoo.com");
        Customer customer5 = new Customer("C0005","Manmeet","Kaur","manmmet@yahoo.com");
        Customer customer6 = new Customer("C0006","Simran","Bhangu","simran24@yahoo.com");
        Customer customer7 = new Customer("C0007","Eman","Kaur","eman546@yahoo.com");



        Internet internet1 = new Internet("INTB0001", "29-Sep-2019", 25.00, "Rogers", 500);
        Internet internet2 = new Internet("INTB0002", "20-Aug-2019", 36.00, "Bell", 400);
        Internet internet3 = new Internet("INTB0003", "25-Dec-2019", 24.00, "Fido", 350);

        Hydro hydro1 = new Hydro("HYDB0001", "16-Nov-2019", 9.00, "Planet Earth", 600);
        Hydro hydro2 = new Hydro("HYDB0002", "15-Sep-2019", 12.00, "Bruce Power", 500);

        Mobile mobile = new Mobile("MOBB0001","11-Jun-2019", 7.60,"Samsung", "LTE+3G 9.5GB Promo", "9753186420", 4, 230);

        customer1.addBill(internet1.getBillId(), internet1);
        customer1.addBill(hydro1.getBillId(), hydro1);
        customer1.addBill(mobile.getBillId(), mobile);
        customer4.addBill(mobile.getBillId(), mobile);
        customer5.addBill(mobile.getBillId(), mobile);
        customer2.addBill(internet2.getBillId(), internet2);
        customer2.addBill(hydro2.getBillId(), hydro2);
        customer4.addBill(hydro2.getBillId(), hydro2);
        customer5.addBill(hydro2.getBillId(), hydro2);
        customer6.addBill(hydro2.getBillId(), hydro2);
        customer3.addBill(internet3.getBillId(), internet3);
        customer7.addBill(internet3.getBillId(), internet3);


        addCustomer(customer1.getCustomerId(), customer1);
        addCustomer(customer2.getCustomerId(), customer2);
        addCustomer(customer3.getCustomerId(), customer3);
        addCustomer(customer4.getCustomerId(), customer4);
        addCustomer(customer5.getCustomerId(), customer5);
        addCustomer(customer6.getCustomerId(), customer6);
        addCustomer(customer7.getCustomerId(), customer7);

//        customer.add(customer1);
//        customer.add(customer2);
//        customer.add(customer3);
    }
}
