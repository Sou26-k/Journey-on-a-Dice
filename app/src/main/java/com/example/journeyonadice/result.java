package com.example.journeyonadice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class result extends AppCompatActivity {

    String destination,start,flag;
    String host = "10.0.2.2";
    int port = 50000;

    public NetSample net;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();
        destination = intent.getStringExtra("destination");
        start = intent.getStringExtra("start");
        flag = intent.getStringExtra("flag");

        System.out.println(start);
        System.out.println(destination);
        if(flag.equals("goal")){
            System.out.println("ゴールしました");
        }
        if(flag.equals("count")){
            System.out.println("回数オーバーです");
        }

       net = new NetSample();


    }

    protected void onResume() {
        super.onResume();
        net.connect(host, port);

    }
    protected void onPause() {
        super.onPause();

        net.close();
    }

    public void again(View view){
        net.send("出発地:"+ this.start + "\n目的地:"+ this.destination);
        Intent intent = new Intent(this, MainActivity.class);
        if(intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }
    }
}