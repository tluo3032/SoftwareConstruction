package main;

import main.State;

public class faceDown implements State {
    Card card;

    public faceDown(Card c) {
        this.card = c;
    }
    public void show(){
        System.out.println("[   ]");
    }

}
