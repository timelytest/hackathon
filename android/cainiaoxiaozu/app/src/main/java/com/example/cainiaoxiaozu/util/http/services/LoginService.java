package com.example.cainiaoxiaozu.util.http.services;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface LoginService {
    @GET("/user/login")
    Call<ResponseBody> sayHello();
}
