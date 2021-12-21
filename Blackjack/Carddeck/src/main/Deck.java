package main;
import java.util.List;
import java.util.ArrayList;
import java.util.*;

public class Deck {
    private final List<Card> aCards = new ArrayList<>();
    public Deck() {
        //CLUBS
        Card c1 = new Card(Rank.ACE, Suit.CLUBS);
        Card c2 = new Card(Rank.TWO, Suit.CLUBS);
        Card c3 = new Card(Rank.THREE, Suit.CLUBS);
        Card c4 = new Card(Rank.FOUR, Suit.CLUBS);
        Card c5 = new Card(Rank.FIVE, Suit.CLUBS);
        Card c6 = new Card(Rank.SIX, Suit.CLUBS);
        Card c7 = new Card(Rank.SEVEN, Suit.CLUBS);
        Card c8 = new Card(Rank.EIGHT, Suit.CLUBS);
        Card c9 = new Card(Rank.NINE, Suit.CLUBS);
        Card c10 = new Card(Rank.TEN, Suit.CLUBS);
        Card c11 = new Card(Rank.JACK, Suit.CLUBS);
        Card c12 = new Card(Rank.QUEEN, Suit.CLUBS);
        Card c13 = new Card(Rank.KING, Suit.CLUBS);
        //HEARTS
        Card c14 = new Card(Rank.ACE, Suit.HEARTS);
        Card c15 = new Card(Rank.TWO, Suit.HEARTS);
        Card c16 = new Card(Rank.THREE, Suit.HEARTS);
        Card c17 = new Card(Rank.FOUR, Suit.HEARTS);
        Card c18 = new Card(Rank.FIVE, Suit.HEARTS);
        Card c19 = new Card(Rank.SIX, Suit.HEARTS);
        Card c20 = new Card(Rank.SEVEN, Suit.HEARTS);
        Card c21 = new Card(Rank.EIGHT, Suit.HEARTS);
        Card c22 = new Card(Rank.NINE, Suit.HEARTS);
        Card c23 = new Card(Rank.TEN, Suit.HEARTS);
        Card c24 = new Card(Rank.JACK, Suit.HEARTS);
        Card c25 = new Card(Rank.QUEEN, Suit.HEARTS);
        Card c26 = new Card(Rank.KING, Suit.HEARTS);
        //SPADES
        Card c27 = new Card(Rank.ACE, Suit.SPADES);
        Card c28 = new Card(Rank.TWO, Suit.SPADES);
        Card c29 = new Card(Rank.THREE, Suit.SPADES);
        Card c30 = new Card(Rank.FOUR, Suit.SPADES);
        Card c31 = new Card(Rank.FIVE, Suit.SPADES);
        Card c32 = new Card(Rank.SIX, Suit.SPADES);
        Card c33 = new Card(Rank.SEVEN, Suit.SPADES);
        Card c34 = new Card(Rank.EIGHT, Suit.SPADES);
        Card c35 = new Card(Rank.NINE, Suit.SPADES);
        Card c36 = new Card(Rank.TEN, Suit.SPADES);
        Card c37 = new Card(Rank.JACK, Suit.SPADES);
        Card c38 = new Card(Rank.QUEEN, Suit.SPADES);
        Card c39 = new Card(Rank.KING, Suit.SPADES);
        //DIAMONDS
        Card c40 = new Card(Rank.ACE, Suit.DIAMONDS);
        Card c41 = new Card(Rank.TWO, Suit.DIAMONDS);
        Card c42 = new Card(Rank.THREE, Suit.DIAMONDS);
        Card c43 = new Card(Rank.FOUR, Suit.DIAMONDS);
        Card c44 = new Card(Rank.FIVE, Suit.DIAMONDS);
        Card c45 = new Card(Rank.SIX, Suit.DIAMONDS);
        Card c46 = new Card(Rank.SEVEN, Suit.DIAMONDS);
        Card c47 = new Card(Rank.EIGHT, Suit.DIAMONDS);
        Card c48 = new Card(Rank.NINE, Suit.DIAMONDS);
        Card c49 = new Card(Rank.TEN, Suit.DIAMONDS);
        Card c50 = new Card(Rank.JACK, Suit.DIAMONDS);
        Card c51 = new Card(Rank.QUEEN, Suit.DIAMONDS);
        Card c52 = new Card(Rank.KING, Suit.DIAMONDS);

        aCards.add(c1);
        aCards.add(c2);
        aCards.add(c3);
        aCards.add(c4);
        aCards.add(c5);
        aCards.add(c6);
        aCards.add(c7);
        aCards.add(c8);
        aCards.add(c9);
        aCards.add(c10);
        aCards.add(c11);
        aCards.add(c12);
        aCards.add(c13);
        aCards.add(c14);
        aCards.add(c15);
        aCards.add(c16);
        aCards.add(c17);
        aCards.add(c18);
        aCards.add(c19);
        aCards.add(c20);
        aCards.add(c21);
        aCards.add(c22);
        aCards.add(c23);
        aCards.add(c24);
        aCards.add(c25);
        aCards.add(c26);
        aCards.add(c27);
        aCards.add(c28);
        aCards.add(c29);
        aCards.add(c30);
        aCards.add(c31);
        aCards.add(c32);
        aCards.add(c33);
        aCards.add(c34);
        aCards.add(c35);
        aCards.add(c36);
        aCards.add(c37);
        aCards.add(c38);
        aCards.add(c39);
        aCards.add(c40);
        aCards.add(c41);
        aCards.add(c42);
        aCards.add(c43);
        aCards.add(c44);
        aCards.add(c45);
        aCards.add(c46);
        aCards.add(c47);
        aCards.add(c48);
        aCards.add(c49);
        aCards.add(c50);
        aCards.add(c51);
        aCards.add(c52);

        for (int i=0; i <= 51; i++){
            Card c = aCards.get(i);
            c.setState(c.faceUp);
        }
        }
        public void shuffle(){
            Collections.shuffle(aCards);
        }
        public Card draw() {
        return aCards.remove(0);
    }

}
