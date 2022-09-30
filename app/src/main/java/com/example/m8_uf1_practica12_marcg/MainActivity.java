package com.example.m8_uf1_practica12_marcg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private int userTry = 0;
    private int number = (int) Math.floor(Math.random() * (100 - 1 + 1) + 1);
    private TextView log;
    private ArrayList<Users> userList = new ArrayList<Users>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView input = (TextView) findViewById(R.id.numberU);
        log = (TextView) findViewById(R.id.Registry);

        Button button = (Button) findViewById(R.id.verify);
        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                CharSequence text = "";
                userTry++;
                log.setMovementMethod(new ScrollingMovementMethod());
                int duration = Toast.LENGTH_SHORT;
                int valueUser = Integer.valueOf(input.getText().toString());

                // Do something in response to button click
                Context context = getApplicationContext();
                if (valueUser == number){
                    text = "Nice!! " + valueUser + " is the correct number!!";
                    log.append("Nice!! " + valueUser + " is the correct number!! Tries = " + userTry + "\n");
                    Dialog();

                }
                else if (valueUser < number){
                    text = "Wrong!! " + valueUser + " is smaller than the number!!";
                    log.append("Wrong!! " + valueUser + " is smaller than the number!! Tries = " + userTry + "\n");
                }
                else{
                    text = "Wrong!! " + valueUser + " is biger than the number!!";
                    log.append("Wrong!! " + valueUser + " is biger than the number!!\nTries = " + userTry + "\n");
                }

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });

        Button recordB = (Button) findViewById(R.id.records);
        recordB.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent rankIntent = new Intent(MainActivity.this, Records.class);
                rankIntent.putExtra("users", userList);
                startActivity(rankIntent);

            }
        });

    }
    //Metode de dialeg
    public void Dialog(){
        String Congrats = "Congratulations!!";
        String buttonAccept = "Accept";
        String cancel = "Cancel";
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        final EditText input = new EditText(this);
        builder.setView(input);

        builder.setMessage(Congrats)
                .setPositiveButton(buttonAccept, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //ReStart GAME!!
                        playAgain(String.valueOf(input.getText()));

                    }

                }).setNegativeButton(cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                    }
                });

        // Create the AlertDialog object and return it
        builder.create().show();
    }

    public void playAgain(String text){
        Random rand = new Random();
        userList.add(new Users(text,userTry));
        userTry = 0;
        number = rand.nextInt(100);
        log.setText("");
    }
}