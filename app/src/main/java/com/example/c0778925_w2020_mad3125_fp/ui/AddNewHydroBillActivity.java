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

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AddNewHydroBillActivity extends AppCompatActivity {
    private EditText edtBillId1;
    private EditText edtAgencyName;
    private EditText edtUnit;
    private EditText edtPrice;
    private TextView txtDate1;
    private Button btnSave1;
    public static Customer c;
    public static int selectItem = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_hydro_bill);
        edtBillId1=(EditText)findViewById(R.id.edtBillId1);
        edtAgencyName=(EditText) findViewById(R.id.edtAgencyName);
        edtUnit=(EditText)findViewById(R.id.edtUnits);
        edtPrice=(EditText)findViewById(R.id.edtPrice);
        txtDate1=(TextView)findViewById(R.id.txtDate1);
        btnSave1=(Button)findViewById(R.id.btnSave1);
        c = DataStorage.getInstance().getCustomer().get(getIntent().getIntExtra("customerSelected",selectItem));
       // Intent mIntent = getIntent();
      //  c = mIntent.getParcelableExtra("custBillsAddNew");
        txtDate1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog dialog = new DatePickerDialog(AddNewHydroBillActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                        Calendar calendar = Calendar.getInstance();
                        calendar.set(year, month, dayOfMonth);
                        Date date = calendar.getTime();
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
                        String s = dateFormat.format(date);
                        txtDate1.setText(s);
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
