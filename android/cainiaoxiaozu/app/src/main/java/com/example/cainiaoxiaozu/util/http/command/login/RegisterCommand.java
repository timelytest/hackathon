package com.example.cainiaoxiaozu.util.http.command.login;

import android.content.Context;
import android.content.Intent;

import com.example.cainiaoxiaozu.ui.activity.login.LoginActivity;
import com.example.cainiaoxiaozu.util.http.command.BaseCommand;

public class RegisterCommand extends BaseCommand {

    private Context context;

    public RegisterCommand(Object... objects){
        super(objects);
        //需要操作的组件
        context = (Context) objects[0];

    }

    @Override
    public void success(String body) {
        //具体操作

        Intent intent = new Intent(context, LoginActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void failure(Throwable t) {

    }
}
