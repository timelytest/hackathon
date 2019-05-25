package com.example.cainiaoxiaozu.util.http.services;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface LoginService {
    /**
     * 接口必须定义其返回值为Call<ResponseBody>
     * @return Call<ResponseBody>
     */
    @GET("/user/login")
    Call<ResponseBody> sayHello();
}
