package com.ics.tukuri_delivery.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.ics.tukuri_delivery.Model.Delivery_data;
import com.ics.tukuri_delivery.R;

import java.util.List;

public class Delivery_List_Adapter  extends RecyclerView.Adapter<Delivery_List_Adapter.ViewHolder>
{
    List<Delivery_data> dataList;
    Activity mactivity;


    public Delivery_List_Adapter(Activity mactivity, List<Delivery_data> dataList)
    {
        this.mactivity=mactivity;
        this.dataList=dataList;
    }


    @Override
    public Delivery_List_Adapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_delivery_list,viewGroup,false);
        return new Delivery_List_Adapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(Delivery_List_Adapter.ViewHolder viewHolder, int i) {

        if (viewHolder != null) {

            Delivery_data dob = dataList.get(i);

            viewHolder.name.setText(""+dob.getUserFullname());
            viewHolder.mobile.setText(""+dob.getUserPhone());
            viewHolder.paymode.setText(""+dob.getPaymentMode());
            viewHolder.amount.setText("Rs. "+dob.getTotalAmount());
            viewHolder.address.setText(""+dob.getDeliveryAddress());

        }
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView name, mobile, address, paymode, amount;

        public ViewHolder(View itemview) {
            super(itemview);

            name = itemview.findViewById(R.id.tx_name);
            mobile = itemview.findViewById(R.id.tx_phone);
            address = itemview.findViewById(R.id.tx_address);
            paymode = itemview.findViewById(R.id.tx_paymode);
            amount = itemview.findViewById(R.id.tx_amount);

        }
    }

}
