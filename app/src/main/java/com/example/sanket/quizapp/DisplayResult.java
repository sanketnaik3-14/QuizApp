package com.example.sanket.quizapp;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

public class DisplayResult extends AppCompatActivity {

    int correct;
    int incorrect;
    String name;

    TextView userName;
    TextView correctAnswers;
    TextView incorrectAnswers;
    TextView finalScore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_result);

        Intent receive = getIntent();
        name = receive.getStringExtra("username");
        correct = receive.getIntExtra("correct" , 0);
        incorrect = receive.getIntExtra("incorrect" , 0);

        userName = (TextView)findViewById(R.id.textView1);
        correctAnswers = (TextView)findViewById(R.id.textView2);
        incorrectAnswers = (TextView)findViewById(R.id.textView3);
        finalScore = (TextView)findViewById(R.id.textView4);

        userName.setText("Congratulations "+name+" on completing the quiz");

        ValueAnimator value = new ValueAnimator();
        value.setObjectValues(0 , correct);
        value.setDuration(3000);
        value.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                correctAnswers.setText(""+(int)animation.getAnimatedValue());
            }
        });
        value.start();

        ValueAnimator value1 = new ValueAnimator();
        value1.setObjectValues(0 , incorrect);
        value1.setDuration(3000);
        value1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                incorrectAnswers.setText(""+(int)animation.getAnimatedValue());
            }
        });
        value1.start();

        finalScore.setText("You have answered "+correct+" correct answers & "+incorrect+" incorrect answers");
        finalScore.postDelayed(new Runnable() {
            @Override
            public void run() {
                finalScore.setVisibility(View.VISIBLE);
            }
        },3050);

    }

    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
    }

    public void exitApplication(View view)
    {
        Intent startMain = new Intent(Intent.ACTION_MAIN);
        startMain.addCategory(Intent.CATEGORY_HOME);
        startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(startMain);
    }

    public void tryAgain(View view)
    {
        finish();
    }

}
