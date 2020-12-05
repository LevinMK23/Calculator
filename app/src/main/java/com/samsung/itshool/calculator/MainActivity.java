package com.samsung.itshool.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText txt;
    private String operation;
    private long left;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = findViewById(R.id.txt);
        Button one = findViewById(R.id.one);
        one.setOnClickListener(view -> {

        });

        Toast.makeText(getApplicationContext(), "TEXT", Toast.LENGTH_LONG).show();

    }

    @SuppressLint("SetTextI18n")
    public void input(View view) {
        Button btn = (Button) view;
        String btnText = btn.getText().toString();
        txt.setText(txt.getText() + btnText);
    }

    public void clear(View view) {
        txt.setText("");
    }

    public void operate(View view) {
        Button btn = (Button) view;
        operation = btn.getText().toString();
        left = getLong();
        clear(view);
    }

    private long getLong() {
        return Long.parseLong(txt.getText().toString());
    }

    public void calculate(View view) {
        long result = 0;
        switch (operation) {
            case "+" -> {
                result = left + getLong();
                txt.setText(String.valueOf(result));
            }
            case "-" -> {
                result = left - getLong();
                txt.setText(String.valueOf(result));
            }
            case "*" -> {
                result = left * getLong();
                txt.setText(String.valueOf(result));
            }
            case "/" -> {
                result = left / getLong();
                txt.setText(String.valueOf(result));
            }
        }
    }
}