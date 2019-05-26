package com.example.cainiaoxiaozu.util.http.services;

import com.example.cainiaoxiaozu.model.QuestionPublishBean;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface QuestionService {

    /**
     * 按分类获取问题列表
     * @param type 分类
     * @return
     */
    @POST("/question/list/type")
    Call<ResponseBody> listQuestionByCategory(@Query("type") String type);

    /**
     * 按关键字获取问题列表
     * @param keyword 关键字
     * @return Call<ResponseBody>
     */
    @POST("/question/list/keyword")
    Call<ResponseBody> listQuestionByRecommendation(@Query("keyword") String keyword);

    /**
     * 回答问题
     * @param questionId 问题Id
     * @param content 回答详情
     * @return Call<ResponseBody>
     */
    @POST("/question/answer")
    Call<ResponseBody> answerQuestion(@Query("questionId") String questionId, @Query("content") String content);

    /**
     * 修改问题
     * @param questionId 问题Id
     * @param content 问题详情
     * @return Call<ResponseBody>
     */
    @POST("/question/modify")
    Call<ResponseBody> modifyQuestion(@Query("questionId") String questionId, @Query("content") String content);

    /**
     * 发布任务
     * @param questionPublishBean 问题详情
     * @param file 图片
     * @return Call<ResponseBody>
     */
    @POST("/question/publish")
    Call<ResponseBody> publishQuestion(@Body QuestionPublishBean questionPublishBean, @Part("file") MultipartBody.Part file);

    /**
     * 采纳回答
     * @param questionId 问题Id
     * @param answerId 回答Id
     * @return Call<ResponseBody>
     */
    @POST("/question/adopt")
    Call<ResponseBody> adoptQuestion(@Query("questionId") int questionId, @Query("answerId") int answerId);
}
