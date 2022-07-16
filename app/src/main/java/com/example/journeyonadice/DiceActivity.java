package com.example.journeyonadice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

public class DiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice);
        Intent intent = getIntent();

        //System.out.println(intent.getStringExtra("start"));
        //System.out.println(intent.getStringExtra("destination"));

        Destination d = new Destination();
        d.setDestination();
        String s[] = d.selectDestination();


        List<String> selected_pip = Arrays.asList(s);

        ArrayAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,selected_pip);

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
    }
}