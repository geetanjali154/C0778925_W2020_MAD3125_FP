package com.example.c0778925_w2020_mad3125_fp.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.c0778925_w2020_mad3125_fp.R;
import com.example.c0778925_w2020_mad3125_fp.models.Customer;
import com.example.c0778925_w2020_mad3125_fp.ui.ShowBillDetailsActivity;

import java.util.ArrayList;

public class CustomersAdapter extends RecyclerView.Adapter<CustomersAdapter.CustomerViewHolder> {
    private ArrayList<Customer> customersArrayList;
    public CustomersAdapter(ArrayList<Customer> customersArrayList) {
        this.customersArrayList = customersArrayList;
    }
    @NonNull
    @Override
    public CustomerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_customerlist, parent, false);
        CustomerViewHolder mCustomerViewHolder = new CustomerViewHolder(mView);
        return mCustomerViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final CustomerViewHolder holder, final int position) {
        final Customer mCustomer = this.customersArrayList.get(position);
        holder.txtCustomerName.setText(mCustomer.getFullName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Customer cust = customersArrayList.get(position);
                Intent sint = new Intent(holder.itemView.getContext(), ShowBillDetailsActivity.class);
                sint.putExtra("customerSelected", position);
               holder.itemView.getContext().startActivity(sint);
            }
        });

    }

    @Override
    public int getItemCount() {
        return this.customersArrayList.size();
    }

    public class CustomerViewHolder extends RecyclerView.ViewHolder {
        TextView txtCustomerName;
        public CustomerViewHolder(@NonNull View itemView) {
            super(itemView);
            txtCustomerName = itemView.findViewById(R.id.txtCustomerName);
        }
    }
}
