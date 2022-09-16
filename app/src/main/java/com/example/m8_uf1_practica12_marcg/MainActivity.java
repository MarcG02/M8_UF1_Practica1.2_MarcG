package com.example.m8_uf1_practica12_marcg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int number = 22;
        TextView input = (TextView) findViewById(R.id.numberU);

        Button button = (Button) findViewById(R.id.verify);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                CharSequence text = "";
                int duration = Toast.LENGTH_SHORT;
                int valueUser = Integer.valueOf(input.getText().toString());
                // Do something in response to button click
                Context context = getApplicationContext();
                if (valueUser == number){
                    text = "Nice!! " + valueUser + " is the correct number!!";
                }
                else if (valueUser < number){
                    text = "Wrong!! " + valueUser + " is smaller than the number!!";
                }
                else{
                    text = "Wrong!! " + valueUser + " is biger than the number!!";
                }

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });


    }
}