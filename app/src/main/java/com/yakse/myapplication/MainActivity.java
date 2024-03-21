package com.yakse.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    TextView tvInfo;
    EditText etInput;
    Button bControl;
    boolean gameFinished = false;
    int guess = (int) (Math.random() * 100);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvInfo = (TextView) findViewById(R.id.textView);
        etInput = (EditText) findViewById(R.id.editText);
        bControl = (Button) findViewById(R.id.button);


    }
        public void onClick(View v){
        Integer.parseInt(etInput.getText().toString());
        tvInfo.setText(getResources().getString(R.string.ahead));
        if (!gameFinished) {
            int inp=Integer.parseInt(etInput.getText().toString());
            if (inp > guess)
                tvInfo.setText("Перелет!");
            if (inp < guess)
                tvInfo.setText("Недолет!");
            if (inp == guess) {
                tvInfo.setText("В точку!");
                bControl.setText("Сыграть еще");
                gameFinished = true;
            }
        }
        else
        {
            etInput.getText().clear();
            guess = (int)(Math.random()*100);
            bControl.setText("Ввести значние:");
            tvInfo.setText("Попробуйте угадать число (1 - 100)");
            gameFinished = false;

        }
    }




}