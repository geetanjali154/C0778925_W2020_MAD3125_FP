package com.example.c0778925_w2020_mad3125_fp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.c0778925_w2020_mad3125_fp.R;
import com.example.c0778925_w2020_mad3125_fp.models.Customer;
import com.example.c0778925_w2020_mad3125_fp.models.DataStorage;

public class AddNewCustomerActivity extends AppCompatActivity {
    private EditText txtCustId;
    private EditText txtFirstName;
    private EditText txtLastName;
    private EditText txtId;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
       
                if(txtCustId.getText().toString().isEmpty()){
                    alertBox("Please Enter Customer ID");
                }
                        else if(txtFirstName.getText().toString().isEmpty()){
                    alertBox("Please Enter First Name");
                }
                else if(txtLastName.getText().toString().isEmpty()){
                alertBox("Please Enter Last Name");
                }
                else if(txtId.getText().toString().isEmpty()){
                alertBox("Please Enter Email ID");
                }
                else if(txtId.getText().toString().matches("[A-Z0-9a-z.%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,64}")) {   //https://stackoverflow.com/questions/43747709/how-to-obtain-a-regular-expression-for-validation-email-address-for-one-domain-o

                    Customer customer = new Customer(txtCustId.getText().toString(), txtFirstName.getText().toString(), txtLastName.getText().toString(), txtId.getText().toString());
                    DataStorage.getInstance().addCustomer(customer.getCustomerId(), customer);
                    Intent i = new Intent(AddNewCustomerActivity.this, CustomerListActivity.class);
                    startActivity(i);
                } else {
                    alertBox("Please Enter Valid Email Id");
                }
            }
        });


    }
    public void alertBox(String msg){
        AlertDialog.Builder builder= new AlertDialog.Builder(AddNewCustomerActivity.this);
        builder.setTitle("Error");
        //builder.setIcon(R.drawable.ic_action_plus);
        builder.setMessage(msg);
        builder.setCancelable(false);
        builder.setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(AddNewCustomerActivity.this,"Cancel",Toast.LENGTH_SHORT).show();
            }
        });
        builder.create().show();
    }
}
