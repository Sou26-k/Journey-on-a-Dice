package com.example.journeyonadice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Destination {
    private ArrayList<String> Destination;

    public void setDestination() {
        this.Destination = new ArrayList<>(Arrays.asList(
                "札幌","青森","盛岡","仙台","秋田","山形","福島","水戸",
                "宇都宮","前橋","さいたま","千葉","東京","横浜","新潟","富山","金沢",
                "福井","甲府","長野","岐阜","静岡","名古屋","津","大津","京都","大阪",
                "神戸","奈良","和歌山","鳥取","松江","岡山","広島","山口","徳島","高松",
                "松山","高知","福岡","佐賀","長崎","熊本","大分","宮崎","鹿児島","那覇"
        ));
    }

    public ArrayList<String> getDestination() {
        return this.Destination;
    }

    public String[] selectDestination(){//6つの行き先を決定し返す
        String[] pip = new String[6];
        ArrayList<String> data = this.getDestination();

        ArrayList<Integer> l = new ArrayList<>();

        for(int i = 0;i < 47;i++){//行き先の重複を回避する為
            l.add(i);
        }

        Collections.shuffle(l);

        for(int i = 0; i < 6; i++){
            pip[i] = data.get(l.get(i));
        }
        return pip;
    }

}
