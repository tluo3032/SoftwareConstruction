package test.java;

import main.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


//enum Suit { CLUBS, DIAMONDS, SPADES, HEARTS }
//enum Rank { ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING }

public class CardTest {

    private Card testCard;
    private Suit testSuit;
    private Rank testRank;
    State   testState;
    StateTwo testStateTwo;
    private StateTwo numberCard;
    private StateTwo aceOne;

    @Before
    public void setUp() {

        testRank = Rank.ACE;
        testSuit = Suit.CLUBS;
        testCard = new Card(testRank, testSuit);
        testCard.setState(testCard.faceUp);
        testCard.setStateTwo(testCard.numberCard);
    }

    /*@Test
    public void getRankTest() {
        Rank testR = testCard.getRank();
        Assert.assertEquals(testSuit, testR);
    }*/

    @Test
    public void getSuitTest() {
        Suit testS = testCard.getSuit();
        Assert.assertEquals(testSuit, testS);
    }

    /*@Test
    public void setStateTest() {
        testCard.setState(testCard.faceUp);
        Assert.assertEquals(testCard.);
    }

    @Test
    public void setStateTwo() {
    }*/

    /*@Test
    public void show() {
        Suit testS = testCard.getSuit();
        Rank testR = testCard.getRank();
        testCard.show();
    }*/

    @Test
    public void valueTest() {
        Rank testR = testCard.getRank();
        int val = 0;
        if(this.testStateTwo == testCard.aceOne) {
            if (testR == Rank.TWO) {
                val = 2;
            } else if (testR == Rank.THREE) {
                val = 3;
            } else if (testR == Rank.FOUR) {
                val = 4;
            } else if (testR == Rank.FIVE) {
                val = 5;
            } else if (testR == Rank.SIX) {
                val = 6;
            } else if (testR == Rank.SEVEN) {
                val = 7;
            } else if (testR == Rank.EIGHT) {
                val = 8;
            } else if (testR == Rank.NINE) {
                val = 9;
            } else if (testR == Rank.TEN || testR == Rank.JACK || testR == Rank.QUEEN || testR == Rank.KING) {
                val = 10;
            } else if (testR == Rank.ACE) {
                val = 1;
            }
        }
        else {
            if (testR == Rank.TWO) {
                val = 2;
            } else if (testR == Rank.THREE) {
                val = 3;
            } else if (testR == Rank.FOUR) {
                val = 4;
            } else if (testR == Rank.FIVE) {
                val = 5;
            } else if (testR == Rank.SIX) {
                val = 6;
            } else if (testR == Rank.SEVEN) {
                val = 7;
            } else if (testR == Rank.EIGHT) {
                val = 8;
            } else if (testR == Rank.NINE) {
                val = 9;
            } else if (testR == Rank.TEN || testR == Rank.JACK || testR == Rank.QUEEN || testR == Rank.KING) {
                val = 10;
            } else if (testR == Rank.ACE) {
                val = 11;
            }
        }
        Assert.assertEquals(val, testCard.value(testCard));
    }
}