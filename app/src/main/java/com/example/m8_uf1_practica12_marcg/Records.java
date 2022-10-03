package com.example.m8_uf1_practica12_marcg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class Records extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_records);

        TableRow.LayoutParams  params1=new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT,1.0f);
        TableRow.LayoutParams params2=new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT);
        TableLayout table=(TableLayout) findViewById(R.id.logRanking);

        ArrayList<Users> userlogs = new ArrayList<Users>();
        userlogs = (ArrayList<Users>) getIntent().getSerializableExtra("users");

        for (Users user: userlogs) {
            //Creating new tablerows and textviews
            TableRow row=new TableRow(this);
            TextView txt1=new TextView(this);
            TextView txt2=new TextView(this);

            //setting the text
            txt1.setText(user.getUserName());
            txt2.setText(String.valueOf(user.getTries()));

            txt1.setLayoutParams(params1);
            txt2.setLayoutParams(params1);

            //the textviews have to be added to the row created
            row.addView(txt1);
            row.addView(txt2);

            row.setLayoutParams(params2);
            table.addView(row);
        }


    }
}