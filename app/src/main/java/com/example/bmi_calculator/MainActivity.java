package com.example.bmi_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText editText,editText2Ft,editText3In;
TextView textView2;
Button button;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=findViewById(R.id.editText);
        editText2Ft=findViewById(R.id.editText2Ft);
        editText3In=findViewById(R.id.editText3In);
        textView2=findViewById(R.id.textView2);
        button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //weight should be in kg and height we need m
                int weight= Integer.parseInt(editText.getText().toString());
                int heightft=Integer.parseInt(editText2Ft.getText().toString());
                int heightinch=Integer.parseInt(editText3In.getText().toString());

                int total_inch=heightft*12+heightinch; //inch to cm then cm to meter
                double total_cm=total_inch*2.53;

                //1m=100cm 1cm=1/100
                double totalmet=total_cm/100;


                double bmi=weight/(totalmet*totalmet);

                if(heightft>0  && weight>0) {

                    if(bmi > 30){
                        textView2.setText("You're Obese");
                    }
                    else if(bmi > 25){
                        textView2.setText("You're OverWeight");
                    }
                    else if(bmi > 18.5){
                        textView2.setText("You're Normal Weight");
                    }
                    else if(bmi > 17){
                        textView2.setText("You're UnderWeight");
                    }
                    else{
                        textView2.setText("You're Severely UnderWeight");
                    }
                }
                else{
                    Toast.makeText(MainActivity.this, "Height or weight should not be 0 or less than 0", Toast.LENGTH_SHORT).show();
                }

            }
        });



    }
}