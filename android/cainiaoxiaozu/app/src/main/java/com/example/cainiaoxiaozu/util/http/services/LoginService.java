package com.example.cainiaoxiaozu.util.http.services;

import com.example.cainiaoxiaozu.model.RegisterBean;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface LoginService {
    /**
     * 接口必须定义其返回值为Call<ResponseBody>
     * @return Call<ResponseBody>
     */

    @POST("/user/login")
    Call<ResponseBody> login(@Query("email") String email, @Query("password") String password);

    /**
     * 接口必须定义其返回值为Call<ResponseBody>
     * @return Call<ResponseBody>W
     */
    @Multipart
    @POST("/user/register")
    Call<ResponseBody> register(@Query("registerBean") RegisterBean registerBean, @Part MultipartBody.Part file);

    @POST("/user/infornation")
    Call<ResponseBody> getUserInformation(@Query("email") String email);
}
