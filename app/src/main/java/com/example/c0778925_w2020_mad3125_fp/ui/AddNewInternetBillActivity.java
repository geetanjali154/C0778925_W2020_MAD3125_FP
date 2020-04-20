package com.example.c0778925_w2020_mad3125_fp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.c0778925_w2020_mad3125_fp.R;
public class AddNewInternetBillActivity extends AppCompatActivity {
    private EditText edtBillId2;
    private EditText edtProvider;
    private EditText edtGb;
    private EditText edtPrice2;
    private TextView txtDate2;
    private Button btnSave2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_internet_bill);
        edtBillId2=(EditText)findViewById(R.id.edtBillId2);
        edtProvider=(EditText)findViewById(R.id.edtProvider);
        edtGb=(EditText)findViewById(R.id.edtGb);
        edtPrice2=(EditText)findViewById(R.id.edtPrice2);
        
    }
}
