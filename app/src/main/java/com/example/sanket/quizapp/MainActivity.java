package com.example.sanket.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.R.attr.start;

public class MainActivity extends AppCompatActivity {

    Button startButton ;
    EditText name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startButton = (Button)findViewById(R.id.button_begin);
        name = (EditText)findViewById(R.id.editText_name);
    }

    @Override
    public void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);
        outState.putString("editTextName" , name.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState)
    {
        super.onRestoreInstanceState(savedInstanceState);
        name.setText(savedInstanceState.getString("editTextName"));
    }

    public void nextActivity(View view)
    {
        String enteredName = name.getText().toString();

        if (enteredName.length() == 0)
        {
            Toast.makeText(this , "Please enter a Name" ,Toast.LENGTH_SHORT).show();
            return;
        }

        if(enteredName.length() > 50)
        {
            Toast.makeText(this , "Please enter a name below 50 characters" ,Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent(this ,QuizActivity.class);
        intent.putExtra("username" , enteredName);
        startActivity(intent);



    }


}
