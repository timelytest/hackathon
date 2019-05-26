package com.example.cainiaoxiaozu.ui.activity.login;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cainiaoxiaozu.R;
import com.example.cainiaoxiaozu.util.http.HttpUtil;
import com.example.cainiaoxiaozu.util.http.command.login.LoginCommand;
import com.example.cainiaoxiaozu.util.http.services.LoginService;

public class RegisterActivity extends AppCompatActivity implements
        android.view.View.OnClickListener{

    private EditText mTextEmail;
    private EditText mTextUserName;
    private EditText mTextPassword;
    private EditText mTextSchool;
    private EditText mTextStudentId;
    private EditText mTextGrade;
    private EditText mTextMajor;

    private Button mButtonRegister;
    private Button mButtonPhoto;
    private ImageView mImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mButtonPhoto = (Button) findViewById(R.id.button_picture);
        mButtonRegister = (Button) findViewById(R.id.button_register);
        mTextEmail = (EditText) findViewById(R.id.text_useremail);
        mTextUserName = (EditText) findViewById(R.id.text_username);
        mTextPassword = (EditText) findViewById(R.id.text_userpwd);
        mTextSchool = (EditText) findViewById(R.id.text_userschool);
        mTextStudentId = (EditText) findViewById(R.id.text_userStudentId);
        mTextGrade = (EditText) findViewById(R.id.text_usergarde);
        mTextMajor = (EditText) findViewById(R.id.text_usermajor);
        mButtonPhoto.setOnClickListener(this);
        mButtonRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        //mTextEmail.setText("success");
        switch (v.getId()){
            // 打开本地相册
            case R.id.button_picture:

                Intent i = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

// 设定结果返回

                startActivityForResult(i, 2);
                break;

            case R.id.button_register:
                LoginService loginService = (LoginService) HttpUtil.getService(LoginService.class);
                //HttpUtil.dealCall((loginService.login(mTextViewEmail.getText().toString(), mTextViewPassword.getText().toString())), new LoginCommand(LoginActivity.this));

                break;

            default:
                break;

        }
    }

    @SuppressLint("WrongViewCast")
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (data != null) {

            switch (requestCode) {


                case 2: {

//打开相册并选择照片，这个方式选择单张

// 获取返回的数据，这里是android自定义的Uri地址

                    Uri selectedImage = data.getData();


                    String[] filePathColumn = {MediaStore.Images.Media.DATA};

// 获取选择照片的数据视图

                    Cursor cursor = getContentResolver().query(selectedImage,

                            filePathColumn, null, null, null);

                    cursor.moveToFirst();

// 从数据视图中获取已选择图片的路径

                    int columnIndex = cursor.getColumnIndex(filePathColumn[0]);

                    String picturePath = cursor.getString(columnIndex);

                    cursor.close();

// 将图片显示到界面上

                    mImage = (ImageView) findViewById(R.id.tv_icons);


                    mImage.setImageBitmap(BitmapFactory.decodeFile(picturePath));

                    break;

                }

                default:

                    break;

            }

        }
    }
}
