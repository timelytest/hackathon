package com.example.cainiaoxiaozu.util.http.command;

import android.widget.TextView;

public class LoginCommand extends BaseCommand {

    private TextView textView;

    public LoginCommand(Object... objects){
        super(objects);
        textView = (TextView) objects[0];
    }

    @Override
    public void success(String body) {
        textView.setText(body);
    }

    @Override
    public void failure(Throwable t) {
        textView.setText(t.getLocalizedMessage());
    }
}
