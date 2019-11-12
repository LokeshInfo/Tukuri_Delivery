package com.ics.tukuri_delivery.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ics.tukuri_delivery.Adapter.Delivery_List_Adapter;
import com.ics.tukuri_delivery.AppUtils.Api_Parameter;
import com.ics.tukuri_delivery.R;
import com.ics.tukuri_delivery.View.Main_Activity;

public class Order_Details_fragment extends Fragment
{
    RecyclerView recyclerView;
    Api_Parameter ApiService;
    LinearLayoutManager linearLayoutManager;
    ImageView imgnot, imgback;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

       View view = inflater.inflate(R.layout.fragment_order_details,container,false);

       recyclerView = (RecyclerView) view.findViewById(R.id.order_recycler);
       imgback = view.findViewById(R.id.imgToolbar);

       imgback.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               ((Main_Activity)getActivity()).onBackPressed();
           }
       });

       return  view;
    }
}
