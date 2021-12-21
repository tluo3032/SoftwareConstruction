package main;

import main.StateTwo;

public class numberCard implements StateTwo {
    Card card;

    public numberCard(Card c){
        this.card = c;
    }
    public int value(Card c){
        int val = 0;
        Rank r = c.getRank();
        if (r == Rank.TWO){val = 2;}
        else if (r == Rank.THREE){val = 3;}
        else if (r == Rank.FOUR){val = 4;}
        else if (r == Rank.FIVE){val = 5;}
        else if (r == Rank.SIX){val = 6;}
        else if (r == Rank.SEVEN){val = 7;}
        else if (r == Rank.EIGHT){val = 8;}
        else if (r == Rank.NINE){val = 9;}
        else if (r == Rank.TEN || r == Rank.JACK || r == Rank.QUEEN || r == Rank.KING){val = 10;}
        else if (r == Rank.ACE){val = 11;}

        return val;
    }
}
