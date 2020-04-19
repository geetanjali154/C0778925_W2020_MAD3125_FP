package com.example.c0778925_w2020_mad3125_fp.ui;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import com.example.c0778925_w2020_mad3125_fp.CustomersAdapter;
import com.example.c0778925_w2020_mad3125_fp.R;
import com.example.c0778925_w2020_mad3125_fp.models.Customer;
import com.example.c0778925_w2020_mad3125_fp.models.DataStorage;

import java.util.ArrayList;

public class CustomerListActivity extends AppCompatActivity {
    //private RecyclerView rvCustomer;
    private RecyclerView rvCustomersList;
    private ArrayList<Customer> customers;
    private CustomersAdapter customersAdapter;
    private Button btnLogout;
    private Button btnAddCust;
    private AutoCompleteTextView at;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_list);
        btnAddCust=(Button)findViewById(R.id.btnAddCust);
        btnLogout=(Button)findViewById(R.id.btnLogout);
       // at=(AutoCompleteTextView)findViewById(R.id.at);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mi=new Intent(CustomerListActivity.this,LoginActivity.class);
                startActivity(mi);
            }
        });
        btnAddCust.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mii=new Intent(CustomerListActivity.this,AddNewCustomerActivity.class);
                startActivity(mii);
            }
        });
       // ActionBar actBar = getSupportActionBar();
     //   actBar.setTitle("Customer List");
      //  actBar.setDisplayHomeAsUpEnabled(true);
        //actBar.setIcon(images);

        rvCustomersList = findViewById(R.id.rvCustomer);

        customersInfo();

        customersAdapter = new CustomersAdapter(customers);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        //GridLayoutManager mGridLayoutManager = new GridLayoutManager(this, 2);
        rvCustomersList.setLayoutManager(mLayoutManager);

        rvCustomersList.setAdapter(customersAdapter);

    }
    private void customersInfo(){
        DataStorage.getInstance().loadDetails();

        customers = new ArrayList<>(DataStorage.getInstance().getCustomer());


    }


}
