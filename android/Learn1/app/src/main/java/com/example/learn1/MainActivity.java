package com.example.learn1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.learn1.model.Question;

public class MainActivity extends AppCompatActivity {

    private Button mTrueButton;
    private Button mFalseButton;
    private ImageButton mNextButton;
    private ImageButton mPrevButton;
    private TextView mQuestionTextView;

    private Question[] mQuestionBank = new Question[] {
            new Question(R.string.question_text1, true),
            new Question(R.string.question_text2, false),
            new Question(R.string.question_text3, true),
            new Question(R.string.question_text4, false),
            new Question(R.string.question_text5, true),
    };

    private int mCurrentIndex = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTrueButton = findViewById(R.id.true_button);
        mTrueButton.setOnClickListener(v -> checkAnswer(true));
        mFalseButton = findViewById(R.id.false_button);
        mFalseButton.setOnClickListener(v -> checkAnswer(false));

        mQuestionTextView = findViewById(R.id.question_text_view);
        mQuestionTextView.setOnClickListener(v -> updateQuestion(true));
        updateQuestion(true);

        mNextButton = findViewById(R.id.next_button);
        mNextButton.setOnClickListener(v -> updateQuestion(true));
        mPrevButton = findViewById(R.id.prev_button);
        mPrevButton.setOnClickListener(v -> updateQuestion(false));
    }

    private void updateQuestion(boolean isNext) {
        if (isNext) mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
        else mCurrentIndex = mCurrentIndex - 1 < 0 ? mQuestionBank.length - 1 : mCurrentIndex - 1;
        int question = mQuestionBank[mCurrentIndex].getmTextResId();
        mQuestionTextView.setText(question);
    }

    private void checkAnswer(boolean userPressedTrue) {
        boolean answerIsTrue = mQuestionBank[mCurrentIndex].ismAnswerTrue();
        int messageResId;
        if (userPressedTrue == answerIsTrue) {
            messageResId = R.string.correct_toast;
        } else {
            messageResId = R.string.incorrect_toast;
        }
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show();
    }
}
