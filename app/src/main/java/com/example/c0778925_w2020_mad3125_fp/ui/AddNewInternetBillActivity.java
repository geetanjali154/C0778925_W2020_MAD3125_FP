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
import com.example.c0778925_w2020_mad3125_fp.models.Customer;
import com.example.c0778925_w2020_mad3125_fp.models.DataStorage;
import com.example.c0778925_w2020_mad3125_fp.models.Hydro;
import com.example.c0778925_w2020_mad3125_fp.models.Internet;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AddNewInternetBillActivity extends AppCompatActivity {
    private EditText edtBillId2;
    private EditText edtProvider;
    private EditText edtGb;
    private EditText edtPrice2;
    private TextView txtDate2;
    private Button btnSave2;
    public static Customer c;
    public static int selectItem = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_internet_bill);
        edtBillId2=(EditText)findViewById(R.id.edtBillId2);
        edtProvider=(EditText)findViewById(R.id.edtProvider);
        edtGb=(EditText)findViewById(R.id.edtGb);
        edtPrice2=(EditText)findViewById(R.id.edtPrice2);
        btnSave2=(Button)findViewById(R.id.btnSave2);
        txtDate2=(TextView)findViewById(R.id.txtDate2);
        c = DataStorage.getInstance().getCustomer().get(getIntent().getIntExtra("customerSelected",selectItem));
        txtDate2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog dialog = new DatePickerDialog(AddNewInternetBillActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                        Calendar calendar = Calendar.getInstance();
                        calendar.set(year, month, dayOfMonth);
                        Date date = calendar.getTime();
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
                        String s = dateFormat.format(date);
                        txtDate2.setText(s);
                    }
                }, Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
                dialog.show();
            }
        });


        btnSave2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtBillId2.getText().toString().isEmpty()){
                    alertBox("Please enter Bill ID");
                } else if(txtDate2.getText().toString().isEmpty()){
                    alertBox("Please enter Bill Date");
                }  else if(edtProvider.getText().toString().isEmpty()){
                    alertBox("Please enter Provider Name");
                } else if(edtGb.getText().toString().isEmpty()){
                    alertBox("Please enter Gb Used");
                }
                else if(edtPrice2.getText().toString().isEmpty()){
                    alertBox("Please enter Rate per Gb");
                }
                else

                {
                    //Hydro hydroo1 = new Hydro("HYDB0009", "16-Nov-2019", 9.00, "Planet Earth", 600);
                    Internet intt1 = new Internet(edtBillId2.getText().toString(), txtDate2.getText().toString(), Double.parseDouble(edtPrice2.getText().toString()), edtProvider.getText().toString(), Integer.parseInt(edtGb.getText().toString()));
                    c.addBill(intt1.getBillId(), intt1);
                    Intent hi = new Intent(AddNewInternetBillActivity.this, ShowBillDetailsActivity.class);
                    startActivity(hi);
                }

            }
        });

    }
    public void alertBox(String msg){
       // AlertDialog.Builder builder= new AlertDialog.Builder(AddNewInternetBillActivity.this);
        builder.setTitle("Error");
        //builder.setIcon(R.drawable.ic_action_plus);
        builder.setMessage(msg);
        builder.setCancelable(false);
        builder.setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(AddNewInternetBillActivity.this,"Cancel",Toast.LENGTH_SHORT).show();
            }
        });
        builder.create().show();
    }

}
