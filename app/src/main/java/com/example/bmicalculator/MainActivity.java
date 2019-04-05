package com.example.bmicalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText weightET;
    private EditText heightET;
    private Button calculateBtn;
    private TextView resultTV;
    private TextView resultTypeTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weightET = findViewById(R.id.weightET);
        heightET = findViewById(R.id.heightET);
        calculateBtn = findViewById(R.id.calculateBtn);
        resultTV = findViewById(R.id.resultTV);
        resultTypeTV = findViewById(R.id.resultTypeTV);

        calculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String weight = weightET.getText().toString();
                String height = heightET.getText().toString();

                if(weight.equals("")){
                    Toast.makeText(MainActivity.this, "Please enter weight", Toast.LENGTH_SHORT).show();
                }
                else if(height.equals("")){
                    Toast.makeText(MainActivity.this, "Please enter height", Toast.LENGTH_SHORT).show();
                }
                else{
                    float w = Float.valueOf(weight);
                    float h = Float.valueOf(height);
                    float i = (float)3.281;
                    h = h/i;
                    float bmi = w /(h*h);
                    display(bmi);
                }
            }
        });
    }

    private void display(float bmi) {
        if(bmi>0 && bmi<15){
            resultTV.setText(String.valueOf(bmi));
            resultTypeTV.setText("Very severely underweight");
        }else if(bmi>15 && bmi<16){
            resultTV.setText(String.valueOf(bmi));
            resultTypeTV.setText("Severely underweight");
        }else if(bmi>16 && bmi<18.5){
            resultTV.setText(String.valueOf(bmi));
        }else if(bmi>18.5 && bmi<25){
            resultTV.setText(String.valueOf(bmi));
            resultTypeTV.setText("Normal (healthy weight)");
        }else if(bmi>25 && bmi<30){
            resultTV.setText(String.valueOf(bmi));
            resultTypeTV.setText("Overweight");
        }
    }
}
