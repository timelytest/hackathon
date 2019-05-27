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
     * @return Call<ResponseBody>
     */
    @POST("/question/list/type")
    Call<ResponseBody> listQuestionByType(@Query("type") String type);

    /**
     * 按关键字获取问题列表
     * @param keyword 关键字
     * @return Call<ResponseBody>
     */
    @POST("/question/list/keyword")
    Call<ResponseBody> listQuestionListByKeyword(@Query("keyword") String keyword);

    /**
     * 回答问题
     * @param questionId 问题Id
     * @param content 回答详情
     * @return Call<ResponseBody>
     */
    @POST("/question/answer")
    Call<ResponseBody> answerQuestion(@Query("questionId") String questionId, @Query("content") String content);

    @POST("/answer/list")
    // 查看所有回答过的问题
    Call<ResponseBody> getAnswerList();

    /**
     * 发布任务
     * @return Call<ResponseBody>
     */
    @POST("/question/publish")
    Call<ResponseBody> publishQuestion(@Query("type") String type,@Query("title") String title, @Query("content") String content, @Query("reward") double reward, @Part("file") MultipartBody.Part file);

    /**
     * 采纳回答
     * @param questionId 问题Id
     * @param answerId 回答Id
     * @return Call<ResponseBody>
     */
    @POST("/question/adopt")
    Call<ResponseBody> adoptQuestion(@Query("questionId") int questionId, @Query("answerId") int answerId);

    @POST("/list/publish")
    // 查看发布过的问题
    Call<ResponseBody> getQuestionList();
}
