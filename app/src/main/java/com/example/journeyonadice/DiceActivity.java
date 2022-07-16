package com.example.journeyonadice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class DiceActivity extends AppCompatActivity {

    private Object String;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice);
        Intent intent = getIntent();

        System.out.println(intent.getStringExtra("start"));
        System.out.println(intent.getStringExtra("destination"));
    }
}