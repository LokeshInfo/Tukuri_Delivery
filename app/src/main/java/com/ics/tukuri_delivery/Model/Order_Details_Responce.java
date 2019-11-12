package com.ics.tukuri_delivery.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Order_Details_Responce
{

    @SerializedName("data")
    @Expose
    private List<Order_Details_Data> data = null;

    public List<Order_Details_Data> getData() {
        return data;
    }

    public void setData(List<Order_Details_Data> data) {
        this.data = data;
    }
}
