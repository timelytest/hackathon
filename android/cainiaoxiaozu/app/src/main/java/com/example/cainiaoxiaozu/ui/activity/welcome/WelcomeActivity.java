package com.example.cainiaoxiaozu.ui.activity.welcome;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.example.cainiaoxiaozu.R;
import com.example.cainiaoxiaozu.util.http.HttpUtil;
import com.example.cainiaoxiaozu.util.http.services.LoginService;

public class WelcomeActivity extends AppCompatActivity {

    private TextView textView;
    private LottieAnimationView animationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

//        textView = findViewById(R.id.welcome_text);
        animationView = findViewById(R.id.animation_view);

        LoginService loginService = (LoginService) HttpUtil.getService("http://106.15.177.146:8081/", LoginService.class);
//        HttpUtil.dealCall(loginService.sayHello(), new LoginCommand(textView));

        animationView.setAnimation("72-favourite-app-icon.json");
        animationView.playAnimation();
    }
}
