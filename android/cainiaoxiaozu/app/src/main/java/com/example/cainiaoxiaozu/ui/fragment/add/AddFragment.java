package com.example.cainiaoxiaozu.ui.fragment.add;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;

import com.example.cainiaoxiaozu.R;
import com.example.cainiaoxiaozu.model.Question;
import com.example.cainiaoxiaozu.model.QuestionPublishBean;
import com.example.cainiaoxiaozu.ui.activity.login.LoginActivity;
import com.example.cainiaoxiaozu.util.http.HttpUtil;
import com.example.cainiaoxiaozu.util.http.command.login.LoginCommand;
import com.example.cainiaoxiaozu.util.http.command.question.PublishQuestionCommand;
import com.example.cainiaoxiaozu.util.http.services.LoginService;
import com.example.cainiaoxiaozu.util.http.services.QuestionService;

public class AddFragment extends Fragment {
    private static final String TAG = "fragment_add";
    private LinearLayout linearLayout;
    private RadioButton mRadioButton;
    private RadioButton mRadioButton2;
    private EditText mTextTitle;
    private EditText mTextContent;
    private EditText mTextReward;
    private Button mButtonSubmmit;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add, container, false);
        linearLayout = view.findViewById(R.id.fragment_add);
        mRadioButton = view.findViewById(R.id.radioButton);
        mRadioButton2 = view.findViewById(R.id.radioButton2);
        mTextTitle = view.findViewById(R.id.editText1);
        mTextContent = view.findViewById(R.id.editText);
        mTextReward = view.findViewById(R.id.editText2);
        mButtonSubmmit = view.findViewById(R.id.button);

        //QuestionPublishBean questionPublishBean = new QuestionPublishBean("type", mTextContent.getText().toString(), mTextTitle.getText().toString(), Double.valueOf(mTextReward.getText().toString()));
QuestionPublishBean questionPublishBean = new QuestionPublishBean();

        mButtonSubmmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QuestionService questionService = (QuestionService) HttpUtil.getService(QuestionService.class);
                HttpUtil.dealCall((questionService.publishQuestion(questionPublishBean, null)), new PublishQuestionCommand(AddFragment.this));
            }
        });

        return view;
    }


}
