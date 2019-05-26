package com.example.cainiaoxiaozu.util.http.command.question;

import android.content.Context;
import android.content.Intent;

import com.example.cainiaoxiaozu.ui.activity.home.HomeActivity;
import com.example.cainiaoxiaozu.util.http.command.BaseCommand;

import retrofit2.http.Body;

public class PublishQuestionCommand extends BaseCommand {

    private Context context;


    public PublishQuestionCommand(Object... objects){


        super(objects);
        //需要操作的组件
        context = (Context) objects[0];

    }

    @Override
    public void success(String body) {
        //具体操作
        Intent intent = new Intent(context, HomeActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void failure(Throwable t) {

    }
}
