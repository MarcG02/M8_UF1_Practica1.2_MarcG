package com.example.m8_uf1_practica12_marcg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class Records extends AppCompatActivity {
    TextView log;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_records);
        log = (TextView) findViewById(R.id.logRanking);
        ArrayList<Users> userList = (ArrayList<Users>) getIntent().getSerializableExtra("users");
        String text = "";
        for (Users user: userList) {
            text += user.toString() + "\n";
        }

        log.setText(text);

    }
}