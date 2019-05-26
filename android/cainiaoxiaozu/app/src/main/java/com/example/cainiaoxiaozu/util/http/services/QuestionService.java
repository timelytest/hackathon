package com.example.cainiaoxiaozu.util.http.services;

import com.example.cainiaoxiaozu.model.User;

import java.net.ResponseCache;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface QuestionService {

    /**
     * 按分类获取分类列表
     * @param category 分类
     * @return
     */
    @POST("/question/category")
    Call<ResponseBody> listQuestionByCategory(@Query("category") String category);

    /**
     * 按推荐获取分类列表
     * @param userId 用户id
     * @return
     */
    @POST("/question/recommendation")
    Call<ResponseBody> listQuestionByRecommendation(@Query("userId") int userId);

    /**
     * 回答问题
     * @param user
     * @return
     */
    @POST("/question/answer")
    Call<ResponseBody> answerQuestion(@Body User user);

    /**
     * 修改回答
     * @param user
     * @return
     */
    @POST("/question/modify")
    Call<ResponseBody> modifyQuestion(@Body User user);

    /**
     * 发布任务
     * @param user
     * @return
     */
    @POST("/question/publish")
    Call<ResponseBody> publishQuestion(@Body User user);
}
