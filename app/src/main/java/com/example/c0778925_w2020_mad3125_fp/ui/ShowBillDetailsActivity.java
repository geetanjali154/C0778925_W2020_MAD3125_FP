package com.example.c0778925_w2020_mad3125_fp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


import com.example.c0778925_w2020_mad3125_fp.BillAdapter;
import com.example.c0778925_w2020_mad3125_fp.R;
import com.example.c0778925_w2020_mad3125_fp.models.Bill;
import com.example.c0778925_w2020_mad3125_fp.models.Customer;
import com.example.c0778925_w2020_mad3125_fp.models.DataStorage;

import java.util.ArrayList;

public class ShowBillDetailsActivity extends AppCompatActivity {
    TextView txtName;
    TextView txtEmail;
    TextView txtBill;
    private RecyclerView rvBillsList;
    private ArrayList<Bill> bills;
    private BillAdapter billsAdapter;

    public static int selectItem = 0;

    private Customer cus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_bill_details);
       Toolbar toolbar=findViewById(R.id.toolbar2);
       setSupportActionBar(toolbar);
       toolbar.setTitle("Customer Details");
       txtBill=(TextView)findViewById(R.id.txtBill);
       txtEmail=(TextView)findViewById(R.id.txtEmail);
       txtName=(TextView)findViewById(R.id.txtName);

        cus = DataStorage.getInstance().getCustomer().get(getIntent().getIntExtra("customerSelected",selectItem));

        //txtCustomerId.setText(tempobj.getCustomerId());
        txtName.setText("Name       :"+cus.getFullName());
        txtEmail.setText("Email ID   :"+cus.getEmail());
        txtBill.setText("Total Bill  :"+"$"+cus.getTotalAmountToPay().toString());

        bills = cus.getAllBills();

        rvBillsList = findViewById(R.id.rvBillList);

        //  billsInfo();

        billsAdapter = new BillAdapter(bills);
        RecyclerView.LayoutManager mLayoutManager1 = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
       // GridLayoutManager mLayoutManager1 = new GridLayoutManager(this, 2);
        rvBillsList.setLayoutManager(mLayoutManager1);


        rvBillsList.setAdapter(billsAdapter);


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu3:
                Intent i3 = new Intent(ShowBillDetailsActivity.this, AddNewHydroBillActivity.class);
                startActivity(i3);
                return true;
            case R.id.menu4:
                Intent i4 = new Intent(ShowBillDetailsActivity.this, AddNewMobileBillActivity.class);
                startActivity(i4);
                return true;
            case R.id.menu5:
                Intent i5 = new Intent(ShowBillDetailsActivity.this, AddNewInternetBillActivity.class);
                startActivity(i5);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}
