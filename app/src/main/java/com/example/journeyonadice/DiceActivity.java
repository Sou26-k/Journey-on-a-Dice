package com.example.journeyonadice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

public class DiceActivity extends AppCompatActivity {

    List<String> selected_pip;
    String s[];

    String destination,start,now;

    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice);
        Intent intent = getIntent();
        destination = intent.getStringExtra("destination");
        start = intent.getStringExtra("start");
        now = intent.getStringExtra("now");

        //System.out.println(intent.getStringExtra("start"));
        //System.out.println(intent.getStringExtra("destination"));

        Destination d = new Destination();
        d.setDestination();
        s = d.selectDestination();


        this.selected_pip = Arrays.asList(s);

        ArrayAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,this.selected_pip);

        ListView listView = (ListView) findViewById(R.id.dice_selected);
        listView.setAdapter(adapter);

        for(int i = 0;i <6;i++) {
            System.out.println(s[i]);
        }

    }

    public void roll_dice(View view){
        TextView tv = (TextView) findViewById(R.id.dice_pip);
        Dice d = new Dice();
        d.DiceRoller();
        tv.setText(String.valueOf(d.getDiceCount()));
        view.setEnabled(false);

        if(this.destination.equals(s[d.getDiceCount()+1])){
            System.out.println("ゴール");
        }else{
            System.out.println("次もがんばってね");
        }
    }

    public void next_page(View v){
        Destination d = new Destination();
        d.setDestination();
        s = d.selectDestination();


        this.selected_pip = Arrays.asList(s);

        ArrayAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,this.selected_pip);

        ListView listView = (ListView) findViewById(R.id.dice_selected);
        listView.setAdapter(adapter);

        for(int i = 0;i <6;i++) {
            System.out.println(s[i]);
        }

        Button bt = (Button) findViewById(R.id.roll_bt);
        bt.setEnabled(true);

        this.count++;
        if(count > 3){
            System.out.println("長すぎ");
        }

    }
}