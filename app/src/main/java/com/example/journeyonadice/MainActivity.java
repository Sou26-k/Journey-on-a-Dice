package com.example.journeyonadice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        String[] sp_array = {"札幌","青森","盛岡","仙台","秋田","山形","福島","水戸",
                "宇都宮","前橋","さいたま","千葉","東京","横浜","新潟","富山","金沢",
                "福井","甲府","長野","岐阜","静岡","名古屋","津","大津","京都","大阪",
                "神戸","奈良","和歌山","鳥取","松江","岡山","広島","山口","徳島","高松",
                "松山","高知","福岡","佐賀","長崎","熊本","大分","宮崎","鹿児島","那覇"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,sp_array);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner start_point = findViewById(R.id.start_point);
        start_point.setAdapter(adapter);
    }
}