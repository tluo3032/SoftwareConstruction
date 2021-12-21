package main;

import main.State;
public class faceUp implements State {
    Card card;

    public faceUp(Card c) {
        this.card = c;
    }

    public void show() {
        String s;
        if (this.card.getSuit() == Suit.HEARTS) {
            s = "♥";
        } else if (this.card.getSuit() == Suit.CLUBS) {
            s = "♣";
        } else if (this.card.getSuit() == Suit.SPADES) {
            s = "♠";
        } else {
            s = "♦";
        }

        String r;
        if (this.card.getRank() == Rank.ACE) {
            r = "A";
        } else if (this.card.getRank() == Rank.TWO) {
            r = "2";
        } else if (this.card.getRank() == Rank.THREE) {
            r = "3";
        } else if (this.card.getRank() == Rank.FOUR) {
            r = "4";
        } else if (this.card.getRank() == Rank.FIVE) {
            r = "5";
        } else if (this.card.getRank() == Rank.SIX) {
            r = "6";
        } else if (this.card.getRank() == Rank.SEVEN) {
            r = "7";
        } else if (this.card.getRank() == Rank.EIGHT) {
            r = "8";
        } else if (this.card.getRank() == Rank.NINE) {
            r = "9";
        } else if (this.card.getRank() == Rank.TEN) {
            r = "10";
        } else if (this.card.getRank() == Rank.JACK) {
            r = "J";
        } else if (this.card.getRank() == Rank.QUEEN) {
            r = "Q";
        } else {
            r = "K";
        }

        System.out.println("[" + r + "_" + s + "]");
    }
}
