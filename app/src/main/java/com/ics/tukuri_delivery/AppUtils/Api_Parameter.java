package com.ics.tukuri_delivery.AppUtils;

import com.ics.tukuri_delivery.Model.Login_Response;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Api_Parameter
{

    @FormUrlEncoded
    @POST("emp_login")
    Call<Login_Response>LOGIN_CALL(
    @Field("username")String usernm,
    @Field("password")String pass
    );



}
