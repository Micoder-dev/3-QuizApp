package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnWrong,btnTrue;
    private TextView mTxtQuestion;

    private int mQuestionIndex;
    private int mQuizQuestion;


    private QuizModel[] questionCollection = new QuizModel[] {

            new QuizModel(R.string.q1, true),
            new QuizModel(R.string.q2, false),
            new QuizModel(R.string.q3, true),
            new QuizModel(R.string.q4, false),
            new QuizModel(R.string.q5, true),
            new QuizModel(R.string.q6, false),
            new QuizModel(R.string.q7, true),
            new QuizModel(R.string.q8, false),
            new QuizModel(R.string.q9, true),
            new QuizModel(R.string.q10, false)

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTxtQuestion = findViewById(R.id.txtQuestion);

        QuizModel q1 = questionCollection[mQuestionIndex];

        mQuizQuestion = q1.getmQuestion();

        mTxtQuestion.setText(mQuizQuestion);



        btnWrong = findViewById(R.id.btnWrong);
        btnTrue = findViewById(R.id.btnTrue);

        btnTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                evaluateUsersAnswer(true);

                changeQuestionOnButtonClick();

            }
        });

        btnWrong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                evaluateUsersAnswer(false);

                changeQuestionOnButtonClick();

            }
        });

    }

    private void changeQuestionOnButtonClick() {

        // % - 20 % 15 = 5 - 30 % 25 = 5
        // 5 % 10 = 5 - 1 % 4 = 1

        // 0 = 1 % 10 = 1
        // 1 = 2 % 10 = 2
        // 9 = 9 + 1 = 10 - 10 % 10 = 0

        mQuestionIndex = (mQuestionIndex + 1) % 10;

        mQuizQuestion = questionCollection[mQuestionIndex].getmQuestion();

        mTxtQuestion.setText(mQuizQuestion);

    }

    private void evaluateUsersAnswer(boolean userGuess) {

        boolean currentQuestionAnswer = questionCollection[mQuestionIndex].ismAnswer();

        if (currentQuestionAnswer == userGuess) {

            Toast.makeText(getApplicationContext(), R.string.correct_toast_message, Toast.LENGTH_SHORT).show();

        } else {

            Toast.makeText(getApplicationContext(), R.string.incorrect_toast_message, Toast.LENGTH_SHORT).show();

        }


    }

}