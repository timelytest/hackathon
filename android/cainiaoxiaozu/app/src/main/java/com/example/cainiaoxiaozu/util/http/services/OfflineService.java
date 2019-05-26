package com.example.cainiaoxiaozu.util.http.services;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface OfflineService {

    /**
     * 填写问卷
     * @param type 类型
     * @param question 具体问题
     * @param score 赏金
     * @param file 有关文件
     * @return
     */
    @POST("/question/ask")
    Call<ResponseBody> fullInQuestionnaire(@Query("type") String type, @Query("question") String question, @Query("score") double score, @Part MultipartBody.Part file);

    /**
     * 修改赏金
     * @param questionId 问题id
     * @param score 赏金
     * @return
     */
    @POST("/question/reviseScore")
    Call<ResponseBody> modifyScore(@Query("questionId") int questionId, @Query("score") double score);

    /**
     * 接单
     * @param questionId 线下问题id
     * @return
     */
    @POST("/answer/takeOrder")
    Call<ResponseBody> takeOrder(@Query("questionId") int questionId);

    /**
     * 显示线下问题列表
     * @param type 线下问题类型
     * @return
     */
    @POST("/question/typeList")
    Call<ResponseBody> listByType(@Query("type") String type);

    /**
     * 完成时提问方处理
     * @param requestionId 完成的线下问题id
     * @param score 赏金
     * @return
     */
    @POST("/questioner/achieve")
    Call<ResponseBody> achieveForQuestioner(@Query("requestionId") int requestionId, @Query("score") double score);

    /**
     * 完成时接单方处理
     * @param requestionId 完成的线下问题id
     * @param score 赏金
     * @return
     */
    @POST("/answer/achieve")
    Call<ResponseBody> achieveForAnswer(@Query("requestionId") int requestionId, @Query("score") double score);

}
