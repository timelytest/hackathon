package com.example.cainiaoxiaozu.util.http.services;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface RecommendService {

    /**
     * 首页
     * @return
     */
    @GET("/index/recommmend")
    Call<ResponseBody> getFirstPage();

    /**
     * 问题推荐
     * @return List<Question>
     */
    @GET("/index/recommend/questions")
    Call<ResponseBody> getQuestionCommend();

    /**
     * 辅导推荐
     * @return List<Teach>
     */
    @GET("/index/recommend/teaches")
    Call<ResponseBody> getTeachesCommend();
}
