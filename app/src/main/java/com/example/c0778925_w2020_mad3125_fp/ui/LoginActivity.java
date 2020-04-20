package com.example.c0778925_w2020_mad3125_fp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.example.c0778925_w2020_mad3125_fp.R;

public class LoginActivity extends AppCompatActivity {

    private EditText loginEmail;
    private EditText loginPwd;
    private Button loginBtn;
    private Switch switch1;
    private SharedPreferences preferences ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginEmail=(EditText)findViewById(R.id.loginEmail);
        loginPwd=(EditText)findViewById(R.id.loginPwd);
        loginBtn=(Button)findViewById(R.id.loginBtn);
        switch1=(Switch)findViewById(R.id.switch1);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(loginEmail.getText().toString().isEmpty()){
                    alertBox("Please Enter Login Email");
                }
                else if(loginPwd.getText().toString().isEmpty())
                {
                    alertBox("Please Enter Password");
                }
                else if((loginEmail.getText().toString().equals("geet@123")) && (loginPwd.getText().toString().equals("gupta"))){
                    SharedPreferences.Editor editor = null;
                    if(switch1.isChecked()){
                        final SharedPreferences preferences = getSharedPreferences("Switch", MODE_PRIVATE);
                       
                        editor.apply();
                        Intent mintent=new Intent(LoginActivity.this,CustomerListActivity.class);
                        startActivity(mintent);}
                    else{
                        Intent mintent=new Intent(LoginActivity.this,CustomerListActivity.class);
                        startActivity(mintent);
                    }
                }
                else{
                    alertBox("Invalid Login Information!");
                }
            }
        });
    }
    public void alertBox(String msg){
        AlertDialog.Builder builder= new AlertDialog.Builder(LoginActivity.this);
        builder.setTitle("Error");
        //builder.setIcon(R.drawable.ic_action_plus);
        builder.setMessage(msg);
        builder.setCancelable(false);
        builder.setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(LoginActivity.this,"Cancel",Toast.LENGTH_SHORT).show();
            }
        });
        builder.create().show();
    }
}
