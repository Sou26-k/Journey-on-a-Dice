package com.example.journeyonadice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public Spinner spinner_start,spinner_destination;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        String[] sp_array = {"札幌","青森","盛岡","仙台","秋田","山形","福島","水戸",
                "宇都宮","前橋","さいたま","千葉","東京","横浜","新潟","富山","金沢",
                "福井","甲府","長野","岐阜","静岡","名古屋","津","大津","京都","大阪",
                "神戸","奈良","和歌山","鳥取","松江","岡山","広島","山口","徳島","高松",
                "松山","高知","福岡","佐賀","長崎","熊本","大分","宮崎","鹿児島","那覇"};

        ArrayAdapter<String> adapter_start = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,sp_array);
        adapter_start.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        this.spinner_start = findViewById(R.id.start_point);
        this.spinner_start.setAdapter(adapter_start);

        ArrayAdapter<String> adapter_destination = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,sp_array);
        adapter_destination.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        this.spinner_destination = findViewById(R.id.destination);
        this.spinner_destination.setAdapter(adapter_destination);


    }

    public void next_page(View v){
        Intent intent = new Intent(this, DiceActivity.class);

        intent.putExtra("start",(String) spinner_start.getSelectedItem());
        intent.putExtra("destination",(String) spinner_destination.getSelectedItem());
        intent.putExtra("now",(String) spinner_start.getSelectedItem());
        if(intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }
    }
}