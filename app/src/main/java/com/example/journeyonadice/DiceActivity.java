package com.example.journeyonadice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DiceActivity extends AppCompatActivity {

    List<String> selected_pip;
    String s[];

    String destination,start,now;
    boolean button_click = false,goal_check = false;

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
        //this.selected_pip = new ArrayList<String>(Arrays.asList("札幌","札幌","青森","盛岡","仙台","千葉"));

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
        System.out.println(s[d.getDiceCount()-1]);
        d.initDiceCount();
        if(this.destination.equals(this.selected_pip.get(d.getDiceCount()))){
            System.out.println("ゴール");
            goal_check = true;
        }else{
            System.out.println("次もがんばってね");
        }
        button_click = true;
    }

    public void next_page(View v){
        if(button_click == true){
            if(goal_check == true){
                Intent intent = new Intent(this, result.class);
                intent.putExtra("start", start);
                intent.putExtra("destination", destination);
                intent.putExtra("count", count);
                intent.putExtra("flag","goal");
                if(intent.resolveActivity(getPackageManager()) != null){
                    startActivity(intent);
                }

            }else{
                if(count > 9){
                    Intent intent = new Intent(this, result.class);
                    intent.putExtra("start", start);
                    intent.putExtra("destination", destination);
                    intent.putExtra("count", count);
                    intent.putExtra("flag","count");
                    if(intent.resolveActivity(getPackageManager()) != null){
                        startActivity(intent);
                    }
                }
                Destination d = new Destination();
                d.setDestination();
                s = d.selectDestination();

                TextView tv = (TextView) findViewById(R.id.dice_pip);
                tv.setText("---");


                this.selected_pip = Arrays.asList(s);
                //this.selected_pip = new ArrayList<String>(Arrays.asList("札幌","札幌","青森","盛岡","仙台","千葉"));

                ArrayAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,this.selected_pip);

                ListView listView = (ListView) findViewById(R.id.dice_selected);
                listView.setAdapter(adapter);

                for(int i = 0;i <6;i++) {
                    System.out.println(s[i]);
                }

                Button bt = (Button) findViewById(R.id.roll_bt);
                bt.setEnabled(true);

                this.count += 1;
                button_click = false;
            }
        }else{
            System.out.println("サイコロを振ってください");
        }
    }
}