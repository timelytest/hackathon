package com.example.cainiaoxiaozu.util.http.services;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RecommendService {

    // 返回标签数组
    @POST("/recommend/type")
    Call<ResponseBody> getTypeList();

    // 返回全局累积获得积分最高的十个人
    @POST("/topRewardUser/overall")
    Call<ResponseBody> getTopRewordUserListOverall();

    // 返回本地累积获得积分最高的十个人
    @POST("/topRewardUser/locally")
    Call<ResponseBody> getTopRewardUserListLocally();

    // 返回最近得到回复解决的十个问题
    @POST("/topResolvedQuestion")
    Call<ResponseBody>getLatestResolvedQuestionList();
}
