package com.example.android.quiz2;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import com.example.android.quiz2.R;

public class MainActivity extends AppCompatActivity {

    EditText digitAnswer ;
    int score = 0;
    int answerInt = 1;
    String answerString = "0";
    String answer = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        digitAnswer=(EditText) findViewById(R.id.answer6);

    }

    private int calculateScore() {
        answerString = (digitAnswer.getText().toString());
        answerInt=Integer.parseInt(answerString);
        if (answerInt == 7) {
            score  =  score  + 1;
        }
        RadioButton a1 = (RadioButton) findViewById(R.id.answer1True);
        if (a1.isChecked()) {
            score = score + 1;
        }
        RadioButton a2 = (RadioButton) findViewById(R.id.answer2True);
        if (a2.isChecked()) {
            score = score + 1;
        }
        RadioButton a3 = (RadioButton) findViewById(R.id.answer3RadioButton2);
        if (a3.isChecked()) {
            score = score + 1;
        }
        RadioButton a4 = (RadioButton) findViewById(R.id.answer4RadioButton2);
        if (a4.isChecked()) {
            score = score + 1;
        }
        CheckBox CB1 = (CheckBox) findViewById(R.id.answer5CheckBox1);
        CheckBox CB2 = (CheckBox) findViewById(R.id.answer5CheckBox2);
        CheckBox CB3 = (CheckBox) findViewById(R.id.answer5CheckBox3);
        if (CB1.isChecked()&&CB2.isChecked()) {
            score = score + 1;
            if (CB3.isChecked()) {
                score = score - 1;
            }
        }
        return score;
    }
    public void submit(View view) {
        calculateScore();
        answer = (digitAnswer.getText().toString());
        int answerint=Integer.parseInt(answer);
        RadioButton radioA1Value = (RadioButton) findViewById(R.id.answer1True);
        RadioButton radioA2Value = (RadioButton) findViewById(R.id.answer1False);
        RadioButton radioB1Value = (RadioButton) findViewById(R.id.answer2True);
        RadioButton radioB2Value = (RadioButton) findViewById(R.id.answer2False);
        RadioButton radioC1Value = (RadioButton) findViewById(R.id.answer3RadioButton1);
        RadioButton radioC2Value = (RadioButton) findViewById(R.id.answer3RadioButton2);
        RadioButton radioC3Value = (RadioButton) findViewById(R.id.answer3RadioButton3);
        RadioButton radioD1Value = (RadioButton) findViewById(R.id.answer4RadioButton1);
        RadioButton radioD2Value = (RadioButton) findViewById(R.id.answer4RadioButton2);
        RadioButton radioD3Value = (RadioButton) findViewById(R.id.answer4RadioButton3);
        CheckBox CBC1ischecked = (CheckBox) findViewById(R.id.answer5CheckBox1);
        CheckBox CBC2ischecked = (CheckBox) findViewById(R.id.answer5CheckBox2);
        CheckBox CBC3ischecked = (CheckBox) findViewById(R.id.answer5CheckBox3);
        if (CBC3ischecked.isChecked()) {
            Context context = getApplicationContext();
            CharSequence text = "Not quite! You got " + score + " out of 6";
            int duration = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
        else if (radioA1Value.isChecked()&&radioB1Value.isChecked()&&radioC2Value.isChecked()&&radioD2Value.isChecked()&&CBC1ischecked.isChecked()&&CBC2ischecked.isChecked()&&(answerint == 7)){
            Context context = getApplicationContext();
            CharSequence text = "That is correct! You got "+score+" out of 6";
            int duration = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
        else {
            Context context = getApplicationContext();
            CharSequence text = "Not quite! You got "+score+" out of 6";
            int duration = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
        score=0;
    }
}
