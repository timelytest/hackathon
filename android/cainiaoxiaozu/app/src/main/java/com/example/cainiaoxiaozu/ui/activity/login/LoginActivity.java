package com.example.cainiaoxiaozu.ui.activity.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.cainiaoxiaozu.R;
import com.example.cainiaoxiaozu.model.Question;
import com.example.cainiaoxiaozu.util.http.HttpUtil;
import com.example.cainiaoxiaozu.util.http.command.login.LoginCommand;
import com.example.cainiaoxiaozu.util.http.command.question.QuestionAnswerCommand;
import com.example.cainiaoxiaozu.util.http.services.LoginService;
import com.example.cainiaoxiaozu.util.http.services.QuestionService;
import com.example.cainiaoxiaozu.util.http.services.RecommendService;

public class LoginActivity extends AppCompatActivity {

    private TextView mTextViewEmail;
    private TextView mTextViewPassword;
    private Button mButtonLogin;
    private Button mButtonRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mTextViewEmail = (TextView) findViewById(R.id.text_useremail);
        mTextViewPassword = (TextView) findViewById(R.id.text_userpwd);
        mButtonLogin = (Button)findViewById(R.id.button_login);
        mButtonRegister = (Button) findViewById(R.id.button_register);



        mButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //RecommendService recommendService = (RecommendService) HttpUtil.getService(RecommendService.class);
                //HttpUtil.dealCall(recommendService.getTopRewordUserListOverall(), new QuestionAnswerCommand(LoginActivity.class, mTextViewEmail));

                LoginService loginService = (LoginService) HttpUtil.getService(LoginService.class);
                HttpUtil.dealCall((loginService.login(mTextViewEmail.getText().toString(), mTextViewPassword.getText().toString())), new LoginCommand(LoginActivity.this));
            }
        });

        mButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

    }
}
