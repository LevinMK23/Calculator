package com.samsung.itshool.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText inputField;
    private double left;
    private String operation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputField = findViewById(R.id.inputField);
        Button plus = findViewById(R.id.plus);
        plus.setOnClickListener(view -> {
            left = Double.parseDouble(inputField.getText().toString());
            operation = "+";
            inputField.setText("");
        });
        Button equals = findViewById(R.id.eq);
        equals.setOnClickListener(v -> {
            double result = 0;
            switch (operation) {
                case "+":
                    result = left + Double.parseDouble(inputField.getText().toString());
            }
            inputField.setText(String.valueOf(result));
        });
    }

    public void input(View view) {
        inputField.append(((Button) view).getText());
    }
}