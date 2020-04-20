package com.example.c0778925_w2020_mad3125_fp.adapters;

import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.c0778925_w2020_mad3125_fp.R;
import com.example.c0778925_w2020_mad3125_fp.models.Bill;
import com.example.c0778925_w2020_mad3125_fp.models.Hydro;
import com.example.c0778925_w2020_mad3125_fp.models.Internet;
import com.example.c0778925_w2020_mad3125_fp.models.Mobile;

import java.util.ArrayList;

public class BillAdapter extends RecyclerView.Adapter<BillAdapter.BillViewHolder> {
    private ArrayList<Bill> billsArrayList;
    public BillAdapter(ArrayList<Bill> billsArrayList) {
        this.billsArrayList = billsArrayList;
    }
    @NonNull
    @Override
    public BillViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView1 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bill_info, parent, false);
        BillViewHolder mBillViewHolder = new BillViewHolder(mView1);
        return mBillViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final BillViewHolder holder, final int position) {
        Bill mBill = this.billsArrayList.get(position);
        holder.txtBillType.setText("Bill Type : " + mBill.getBillType());
        //holder.txtBillDate.setText("Bill Date : " + mBill.getBillDate());
        holder.txtBillAmount.setText("Bill Amount : " + mBill.getTotalBillAmount().toString());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bill bill = billsArrayList.get(position);

                if(bill.getBillType().equals("Hydro")) {
                    Hydro h=(Hydro)bill;
                   // Toast.makeText(holder.itemView.getContext(),"Bill Date: "+bill.getBillDate()+"\nAgency Name: "+h.getAgencyName()+"\nUnits Consumed: "+h.getUnitConsumed()+"units",Toast.LENGTH_LONG).show();
                    AlertDialog.Builder builder= new AlertDialog.Builder(holder.itemView.getContext());
                    builder.setTitle("Details");
                    //builder.setIcon(R.drawable.ic_action_plus);
                    builder.setMessage("Bill Date: "+bill.getBillDate()+"\nAgency Name: "+h.getAgencyName()+"\nUnits Consumed: "+h.getUnitConsumed()+"units");
                   // builder.setCancelable(false);
                   // builder.setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
                    //    @Override
                      //  public void onClick(DialogInterface dialog, int which) {
                   //         Toast.makeText(LoginActivity.this,"Cancel",Toast.LENGTH_SHORT).show();
                      //  }
                  //  });
                    builder.create().show();
                }
                //Intent sint1 = new Intent(holder.itemView.getContext(), BillInfoActivity.class);
                //sint1.putExtra("bills", bill);
               // holder.itemView.getContext().startActivity(sint1);
                else if(bill.getBillType().equals("Mobile")) {
                Mobile mobile=(Mobile)bill;
                    AlertDialog.Builder builder= new AlertDialog.Builder(holder.itemView.getContext());
                    builder.setTitle("Details");
                    builder.setMessage("Bill Date: "+bill.getBillDate()+"\nManufacturer Name"+mobile.getMobileManufacturer()+"\nMobile Number: "+mobile.getMobileNumber()+"\nPlan Name: "+mobile.getPlanName()+"\nMinutes Usage: "+mobile.getMinuteUsed()+"minutes"+"\nData Used: "+mobile.getInternetGBUsed()+"Gb");
                    builder.create().show();
                    // Toast.makeText(holder.itemView.getContext(),"Bill Date: "+bill.getBillDate()+"\nManufacturer Name"+mobile.getMobileManufacturer()+"\nMobile Number: "+mobile.getMobileNumber()+"\nPlan Name: "+mobile.getPlanName()+"\nMinutes Usage: "+mobile.getMinuteUsed()+"minutes"+"\nData Used"+mobile.getInternetGBUsed()+"Gb",Toast.LENGTH_LONG).show();
                }
               else{
                    Internet in=(Internet)bill;
                    AlertDialog.Builder builder= new AlertDialog.Builder(holder.itemView.getContext());
                    builder.setTitle("Details");
                    builder.setMessage("Bill Date: "+bill.getBillDate()+"\nProvider Name: "+in.getProviderName()+"\nData Used: "+in.getInternetGBUsed()+"Gb");
                    builder.create().show();
                    //Toast.makeText(holder.itemView.getContext(),"Bill Date: "+bill.getBillDate()+"\nProvider Name: "+in.getProviderName()+"\nData Used: "+in.getInternetGBUsed()+"Gb",Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return this.billsArrayList.size();
    }

    public class BillViewHolder extends RecyclerView.ViewHolder {

        TextView txtBillType;
       // TextView txtBillDate;
        TextView txtBillAmount;

        public BillViewHolder(@NonNull View itemView) {
            super(itemView);
            txtBillType = itemView.findViewById(R.id.txtBillType);
           // txtBillDate = itemView.findViewById(R.id.txtBillDate);
            txtBillAmount = itemView.findViewById(R.id.txtPay);
            }
        }
    }

