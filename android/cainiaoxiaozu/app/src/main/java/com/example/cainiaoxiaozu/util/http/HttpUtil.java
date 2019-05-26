package com.example.cainiaoxiaozu.util.http;

import com.example.cainiaoxiaozu.util.http.command.BaseCommand;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class HttpUtil {

    private static String baseUrl = "http://106.15.177.146:8081/";
    //private static String baseUrl = "http://localhost:8081/";

    /**
     * 得到需要的服务接口
     * @param clazz 接口.class
     * @return 接口，需要强制转换
     */
    public static Object getService(Class clazz){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .build();
        return retrofit.create(clazz);
    }

    /**
     * 接口的返回类型只能Call<ResponseBody>,然后将该返回值交到这里处理
     * @param call 接口的返回类型
     * @param command 得到返回值后需要做的事情，{@link BaseCommand}
     */
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
