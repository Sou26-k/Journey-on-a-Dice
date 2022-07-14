package com.example.journeyonadice;

public class Dice {

    private int DiceCount;

    public void DiceRoller(){
        this.DiceCount = (int)(Math.random() * 6) + 1;
    }

    public int getDiceCount(){
        return this.DiceCount;
    }
}
