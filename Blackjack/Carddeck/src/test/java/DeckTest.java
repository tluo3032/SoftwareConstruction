package test.java;

import main.Card;
import main.Deck;
import main.Rank;
import org.junit.Before;
import org.junit.Test;
//import static main.java.Test.CardTest;

import static org.junit.Assert.*;

public class DeckTest {

    private Deck testDeck;
    @Before
    public void setUp(){
        testDeck = new Deck();
    }


    @Test
    public void shuffletest() {
        Deck shuffled = new Deck();
        shuffled.shuffle();
        assertFalse(testDeck.equals(shuffled));
    }

    /*@Test
    public void drawtest() {
        Card testCard;
        testCard = testDeck.draw();
        int i = 0;
        for (Card e: testDeck){
            i++;
        }
        assertEquals(51,i);
        Rank ranktest = testCard.getRank();
    }*/
}