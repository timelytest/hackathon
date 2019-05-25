package com.example.cainiaoxiaozu.ui.activity.welcome;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.cainiaoxiaozu.R;
import com.example.cainiaoxiaozu.util.http.HttpUtil;
import com.example.cainiaoxiaozu.util.http.command.LoginCommand;
import com.example.cainiaoxiaozu.util.http.services.LoginService;

public class WelcomeActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        textView = findViewById(R.id.welcome_text);
        LoginService loginService = (LoginService) HttpUtil.getService("http://106.15.177.146:8081/", LoginService.class);
        HttpUtil.dealCall(loginService.sayHello(), new LoginCommand(textView));
    }
}
