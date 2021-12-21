package test.java;

import main.Dealer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.internal.util.reflection.Whitebox;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class DealerTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();


    @Before
    public void setUp(){
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void sumofdealerpointtest() {
        Dealer dealer=new Dealer();
        dealer.sumofdealerpoint(1,2);
        int expectedpoint = (int) Whitebox.getInternalState(dealer,"dealerpoint");
        Assert.assertEquals(3,expectedpoint);
    }

    @Test
    public void showdealerpointtest() {
        Dealer dealer= new Dealer();
        dealer.sumofdealerpoint(10,10);
        dealer.showdealerpoint();
        Assert.assertEquals("20",outputStreamCaptor.toString().trim());

    }

    @Test
    public void getDealerpointtest() {
        Dealer dealer=new Dealer();
        int expectedpoint = (int) Whitebox.getInternalState(dealer,"dealerpoint");
        Assert.assertEquals(dealer.getDealerpoint(),expectedpoint);
    }
}