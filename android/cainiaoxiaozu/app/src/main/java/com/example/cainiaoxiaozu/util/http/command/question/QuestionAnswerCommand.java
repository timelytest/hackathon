package com.example.cainiaoxiaozu.util.http.command.question;

import android.widget.TextView;

import com.example.cainiaoxiaozu.util.http.command.BaseCommand;

public class QuestionAnswerCommand extends BaseCommand {

    private TextView mTextEmail;

    public QuestionAnswerCommand(Object... objects){
        super(objects);
        //需要操作的组件
        //mTextEmail = (TextView) objects[1];


    }

    @Override
    public void success(String body) {
        //具体操作
        //mTextEmail.setText(body);
    }

    @Override
    public void failure(Throwable t) {

    }
}
