package com.example.c0778925_w2020_mad3125_fp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.c0778925_w2020_mad3125_fp.R;

public class AddNewMobileBillActivity extends AppCompatActivity {
    private EditText edtBillId3;
    private EditText edtManufacturer;
    private EditText edtMobile;
    private EditText edtPlanName;
    private EditText edtMinutes;
    private EditText edtPrice3;
    private EditText edtGbUsed;
    private TextView txtDate3;
    private Button btnSave3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_mobile_bill);
        edtBillId3=(EditText)findViewById(R.id.edtBillID3);
        edtManufacturer=(EditText)findViewById(R.id.edtManufacturer);
        edtMobile=(EditText)findViewById(R.id.edtMobile);
        edtPlanName=(EditText)findViewById(R.id.edtPlanName);
        edtMinutes=(EditText)findViewById(R.id.edtMinutes);
        edtPrice3=(EditText)findViewById(R.id.edtPrice3);
        edtGbUsed=(EditText)findViewById(R.id.edtGbUsed);
        txtDate3=(TextView)findViewById(R.id.txtDate3);
        btnSave3=(Button)findViewById(R.id.btnSave3);
    }
}
