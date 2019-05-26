package com.example.cainiaoxiaozu.util.http.command.login;

import com.example.cainiaoxiaozu.util.http.command.BaseCommand;

public class RegisterCommand extends BaseCommand {
    public RegisterCommand(Object... objects){
        super(objects);
        //需要操作的组件

    }

    @Override
    public void success(String body) {
        //具体操作
    }

    @Override
    public void failure(Throwable t) {

    }
}
