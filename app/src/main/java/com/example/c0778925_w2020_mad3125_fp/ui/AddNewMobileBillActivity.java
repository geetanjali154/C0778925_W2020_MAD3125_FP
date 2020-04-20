package com.example.c0778925_w2020_mad3125_fp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.c0778925_w2020_mad3125_fp.R;
import com.example.c0778925_w2020_mad3125_fp.models.Hydro;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
        txtDate3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog dialog = new DatePickerDialog(AddNewMobileBillActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                        Calendar calendar = Calendar.getInstance();
                        calendar.set(year, month, dayOfMonth);
                        Date date = calendar.getTime();
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
                        String s = dateFormat.format(date);
                        txtDate3.setText(s);
                    }
                }, Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
                dialog.show();
            }
        });


        btnSave1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtBillId1.getText().toString().isEmpty()){
                    alertBox("Please enter Bill ID");
                } else if(txtDate1.getText().toString().isEmpty()){
                    alertBox("Please enter Bill Date");
                } else if(edtPrice.getText().toString().isEmpty()){
                    alertBox("Please enter Unit Price");
                } else if(edtAgencyName.getText().toString().isEmpty()){
                    alertBox("Please enter Agency Name");
                } else if(edtUnit.getText().toString().isEmpty()){
                    alertBox("Please enter Unit Consumed");
                }
                else

                {
                    //Hydro hydroo1 = new Hydro("HYDB0009", "16-Nov-2019", 9.00, "Planet Earth", 600);
                    Hydro hydroo1 = new Hydro(edtBillId1.getText().toString(), txtDate1.getText().toString(), Double.parseDouble(edtPrice.getText().toString()), edtAgencyName.getText().toString(), Integer.parseInt(edtUnit.getText().toString()));
                    c.addBill(hydroo1.getBillId(), hydroo1);
                    Intent h = new Intent(AddNewHydroBillActivity.this, ShowBillDetailsActivity.class);
                    startActivity(h);
                }

            }
        });

    }
    public void alertBox(String msg){
        AlertDialog.Builder builder= new AlertDialog.Builder(AddNewHydroBillActivity.this);
        builder.setTitle("Error");
        //builder.setIcon(R.drawable.ic_action_plus);
        builder.setMessage(msg);
        builder.setCancelable(false);
        builder.setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(AddNewHydroBillActivity.this,"Cancel",Toast.LENGTH_SHORT).show();
            }
        });
        builder.create().show();
    }

}
