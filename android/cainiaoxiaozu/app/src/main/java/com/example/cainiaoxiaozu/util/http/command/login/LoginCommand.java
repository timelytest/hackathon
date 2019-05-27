package com.example.cainiaoxiaozu.util.http.command.login;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cainiaoxiaozu.ui.activity.home.HomeActivity;
import com.example.cainiaoxiaozu.ui.activity.login.LoginActivity;
import com.example.cainiaoxiaozu.ui.activity.search.SearchActivity;
import com.example.cainiaoxiaozu.ui.fragment.home.HomeFragment;
import com.example.cainiaoxiaozu.util.http.HttpUtil;
import com.example.cainiaoxiaozu.util.http.command.BaseCommand;
import com.example.cainiaoxiaozu.util.http.services.LoginService;

import java.io.File;
import java.time.Instant;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class LoginCommand extends BaseCommand {

    private Context context;

    private TextView mTextEmail;

    public LoginCommand(Object... objects){
        super(objects);
        //需要操作的组件


        context = (Context) objects[0];
        mTextEmail = (TextView) objects[1];

    }

    @Override
    public void success(String body) {
        //具体操作


//        File file = new File("test1");
//        RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
//
//        MultipartBody.Part partBody = MultipartBody.Part.createFormData("image", file.getName(), requestFile);
//
//        // 添加描述
//        String descriptionString = "hello, 这是文件描述";
//        RequestBody description =
//                RequestBody.create(
//                        MediaType.parse("multipart/form-data"), descriptionString);
//
//        LoginService loginService = (LoginService) HttpUtil.getService(LoginService.class);
//        HttpUtil.dealCall((loginService.register(partBody)), new RegisterCommand(context));


        mTextEmail.setText(body);

        Intent intent = new Intent(context, HomeActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void failure(Throwable t) {

    }
}
