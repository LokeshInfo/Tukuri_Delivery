package com.ics.tukuri_delivery.Adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.ics.tukuri_delivery.AppUtils.BaseUrl;
import com.ics.tukuri_delivery.Fragment.Order_details;
import com.ics.tukuri_delivery.Model.Delivery_Responce;
import com.ics.tukuri_delivery.Model.Delivery_data;
import com.ics.tukuri_delivery.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
            viewHolder.details.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent in = new Intent(mactivity, Order_details.class);
                    mactivity.startActivity(in);

                }
            });

            viewHolder.finishb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });

        }
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView name, mobile, address, paymode, amount, details, finishb;

        public ViewHolder(View itemview) {
            super(itemview);

            name = itemview.findViewById(R.id.tx_name);
            mobile = itemview.findViewById(R.id.tx_phone);
            address = itemview.findViewById(R.id.tx_address);
            paymode = itemview.findViewById(R.id.tx_paymode);
            amount = itemview.findViewById(R.id.tx_amount);
            details = itemview.findViewById(R.id.details_buttn);
            finishb = itemview.findViewById(R.id.finish_buttn);

        }
    }

    private void alert_box(final String value)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(mactivity);
        builder.setTitle("Confirm");
        builder.setMessage("Are you sure?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                    CALL_API(value);
                dialog.dismiss();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog dlg = builder.create();
        //dlg.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(Color.GRAY);
        dlg.show();
        dlg.getButton(AlertDialog.BUTTON_NEGATIVE).setPadding(0,0,10,0);
        dlg.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(mactivity.getResources().getColor(R.color.grey));
    }


    private void CALL_API(String order_id){
        BaseUrl.getAPIService().ORDER_FINISH(order_id).enqueue(new Callback<Delivery_Responce>() {
            @Override
            public void onResponse(Call<Delivery_Responce> call, Response<Delivery_Responce> response) {

            }

            @Override
            public void onFailure(Call<Delivery_Responce> call, Throwable t) {

            }
        });
    }


}
