package com.example.journeyonadice;

import java.util.Random;

public class Dice {

    private int DiceCount;

    public void DiceRoller(){

        this.DiceCount = new Random().nextInt(6) + 1;
    }

    public int getDiceCount(){
        return this.DiceCount;
    }
    public void initDiceCount(){ this.DiceCount = 0;}
}
