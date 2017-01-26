package com.example.sanket.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import static android.R.attr.name;

public class QuizActivity extends AppCompatActivity {

    RadioGroup questionOne;
    RadioGroup questionTwo;
    RadioGroup questionThree;
    RadioGroup questionFour;
    RadioGroup questionFive;
    RadioGroup questionSix;
    RadioGroup questionSeven;
    RadioGroup questionEight;

    RadioButton rb1;
    RadioButton rb2;
    RadioButton rb3;
    RadioButton rb4;
    RadioButton rb5;
    RadioButton rb6;
    RadioButton rb7;
    RadioButton rb8;

    EditText questionNinePart1;
    EditText questionNinePart2;
    int correct = 0;
    int incorrect = 0;

    CheckBox questionTenPart1;
    CheckBox questionTenPart2;
    CheckBox questionTenPart3;

    String userName;

    boolean check = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        Intent intent = getIntent();
        userName = intent.getStringExtra("username");

        questionOne = (RadioGroup) findViewById(R.id.radioGroup_1);
        questionTwo = (RadioGroup) findViewById(R.id.radioGroup_2);
        questionThree = (RadioGroup) findViewById(R.id.radioGroup_3);
        questionFour = (RadioGroup) findViewById(R.id.radioGroup_4);
        questionFive = (RadioGroup) findViewById(R.id.radioGroup_5);
        questionSix = (RadioGroup) findViewById(R.id.radioGroup_6);
        questionSeven = (RadioGroup) findViewById(R.id.radioGroup_7);
        questionEight = (RadioGroup) findViewById(R.id.radioGroup_8);

        rb1 = (RadioButton) findViewById(R.id.radioButton_1);
        rb2 = (RadioButton) findViewById(R.id.radioButton_8);
        rb3 = (RadioButton) findViewById(R.id.radioButton_12);
        rb4 = (RadioButton) findViewById(R.id.radioButton_15);
        rb5 = (RadioButton) findViewById(R.id.radioButton_22);
        rb6 = (RadioButton) findViewById(R.id.radioButton_25);
        rb7 = (RadioButton) findViewById(R.id.radioButton_27);
        rb8 = (RadioButton) findViewById(R.id.radioButton_31);

        questionNinePart1 = (EditText) findViewById(R.id.question_nine_answer_one);
        questionNinePart2 = (EditText) findViewById(R.id.question_nine_answer_two);

        questionTenPart1 = (CheckBox) findViewById(R.id.checkbox_two);
        questionTenPart2 = (CheckBox) findViewById(R.id.checkbox_four);
        questionTenPart3 = (CheckBox) findViewById(R.id.checkbox_six);
    }

    @Override
    public void onResume()
    {
        super.onResume();
        if(check == false)
        {
            finish();
            startActivity(getIntent());
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);
        outState.putString("blank1answer" , questionNinePart1.getText().toString());
        outState.putString("blank2answer" , questionNinePart2.getText().toString());
        outState.putInt("correct" , correct);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState)
    {
        super.onRestoreInstanceState(savedInstanceState);
        questionNinePart1.setText(savedInstanceState.getString("blank1answer"));
        questionNinePart2.setText(savedInstanceState.getString("blank2answer"));

        correct = savedInstanceState.getInt("correct");
    }


    public void checkAnswers(View view) {


        if (questionOne.getCheckedRadioButtonId() == rb1.getId())
        {
            correct = correct + 1;
        }
        else
        {
            incorrect = incorrect + 1;
        }

        if (questionTwo.getCheckedRadioButtonId() == rb2.getId())
        {
            correct = correct + 1;
        }
        else
        {
            incorrect = incorrect + 1;
        }

        if (questionThree.getCheckedRadioButtonId() == rb3.getId())
        {
            correct = correct + 1;
        }
        else
        {
            incorrect = incorrect + 1;
        }

        if (questionFour.getCheckedRadioButtonId() == rb4.getId())
        {
            correct = correct + 1;
        }
        else
        {
            incorrect = incorrect + 1;
        }

        if (questionFive.getCheckedRadioButtonId() == rb5.getId())
        {
            correct = correct + 1;
        }
        else
        {
            incorrect = incorrect + 1;
        }

        if (questionSix.getCheckedRadioButtonId() == rb6.getId())
        {
            correct = correct + 1;
        }
        else
        {
            incorrect = incorrect + 1;
        }

        if (questionSeven.getCheckedRadioButtonId() == rb7.getId())
        {
            correct = correct + 1;
        }
        else
        {
            incorrect = incorrect + 1;
        }

        if (questionEight.getCheckedRadioButtonId() == rb8.getId())
        {
            correct = correct + 1;
        }
        else
        {
            incorrect = incorrect + 1;
        }



        if (questionNinePart1.getText().toString().equals("Front-End") || questionNinePart1.getText().toString().equals("Front-end")
                &&
                questionNinePart2.getText().toString().equals("Back-End") || questionNinePart2.getText().toString().equals("Back-end"))

        {
            correct = correct + 1;
        }
        else
        {
            incorrect = incorrect + 1;
        }

        if(questionTenPart1.isChecked()
                && questionTenPart2.isChecked()
                && questionTenPart3.isChecked())
        {
            correct = correct + 1;
        }
        else
        {
            incorrect = incorrect + 1;
        }

        Intent intent2 = new Intent(QuizActivity.this, DisplayResult.class);
        intent2.putExtra("username" , userName);
        intent2.putExtra("correct" , correct);
        intent2.putExtra("incorrect" , incorrect);

        if(check == true)
        {
            startActivity(intent2);
            check=false;
        }


    }

}
