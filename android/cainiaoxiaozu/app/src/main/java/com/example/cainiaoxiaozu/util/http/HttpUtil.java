package com.example.cainiaoxiaozu.util.http;

import com.example.cainiaoxiaozu.util.http.command.BaseCommand;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class HttpUtil {

    public static Object getService(String baseUrl, Class clazz){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .build();
        return retrofit.create(clazz);
    }

    public static void dealCall(Call<ResponseBody> call, BaseCommand command){
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String result = response.body().string();
                    command.success(result);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                command.failure(t);
            }
        });
    }
}
