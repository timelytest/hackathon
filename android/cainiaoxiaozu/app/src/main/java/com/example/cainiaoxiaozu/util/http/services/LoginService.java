package com.example.cainiaoxiaozu.util.http.services;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface LoginService {
    /**
     * 接口必须定义其返回值为Call<ResponseBody>
     * @return Call<ResponseBody>
     */
    @POST("/user/login")
    Call<ResponseBody> login();

    /**
     * 接口必须定义其返回值为Call<ResponseBody>
     * @return Call<ResponseBody>
     */
    @POST("/user/register")
    Call<ResponseBody> register();
}
