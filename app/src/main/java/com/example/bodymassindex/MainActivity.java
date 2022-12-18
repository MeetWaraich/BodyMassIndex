package com.example.bodymassindex;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText height, weight;
    private EditText res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        height = findViewById(R.id.heightValue);
        weight = findViewById(R.id.weightValue);
        Button output = findViewById(R.id.btn);
        res = findViewById(R.id.display);

        output.setOnClickListener(view -> {
            height.clearFocus();
            weight.clearFocus();

            if (!height.getText().toString().isEmpty() && !weight.getText().toString().isEmpty()) {
                res.setText("");
                CalculateBMI();
            } else {
                if (height.getText().toString().isEmpty()) {
                    Toast.makeText(this, "Please enter height(in meter)", Toast.LENGTH_SHORT).show();
                } else if (weight.getText().toString().isEmpty()) {
                    Toast.makeText(this, "Please enter weight(in Kg)", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Please enter height and weight", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void CalculateBMI() {
        double result;
        result = Double.parseDouble(weight.getText().toString()) / (Math.pow(Double.parseDouble(height.getText().toString()), 2)) * 10000;
        res.setText(String.format("%.2f", result));
    }


}
