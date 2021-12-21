package main;

import main.StateTwo;

public class aceOne implements StateTwo {
    Card card;

    public aceOne(Card c){
        this.card = c;
    }

    public int value(Card card) {
        int val = 1;
        return val;
    }
}
