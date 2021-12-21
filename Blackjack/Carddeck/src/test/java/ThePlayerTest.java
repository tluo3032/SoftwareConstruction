package test.java;

import main.Dealer;
import main.ThePlayer;
import org.junit.Before;
import org.junit.Test;
import org.mockito.internal.util.reflection.Whitebox;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class ThePlayerTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Test
    public void sumofplayerpoint() {
        ThePlayer player=new ThePlayer();
        player.sumofplayerpoint(1,2);
        int expectedpoint = (int) Whitebox.getInternalState(player,"playerpoint");
        assertEquals(3,expectedpoint);
    }

    @Test
    public void getplayerpointtest() {
        ThePlayer player = new ThePlayer();
        int expectedpoint = (int) Whitebox.getInternalState(player,"playerpoint");
        assertEquals(player.getPlayerpoint(),expectedpoint);
    }
    @Before
    public void setUp(){
        System.setOut(new PrintStream(outputStreamCaptor));
    }
    @Test
    public void showofplayerpointtest(){
        ThePlayer player = new ThePlayer();
        player.sumofplayerpoint(10,10);
        player.showplayerpoint();
        assertEquals("20",outputStreamCaptor.toString().trim());
    }

    @Test
    public void sumofmoney() {
        ThePlayer player = new ThePlayer();
        int beforemoney=(int)Whitebox.getInternalState(player,"amountmoney");
        player.sumofmoney(1);
        int aftermoney=(int)Whitebox.getInternalState(player,"amountmoney");
        assertEquals(beforemoney+1,aftermoney);

    }

    @Test
    public void inputValid() {
        ThePlayer player=new ThePlayer();
        assertTrue(player.InputValid("notnumber")==false);
        assertTrue(player.InputValid("0")==true);
        assertTrue(player.InputValid("1")==true);
    }

    @Test
    public void inputmoneyValid() {
        ThePlayer player = new ThePlayer();
        assertTrue(player.InputmoneyValid("notnumber")==false);
        assertTrue(player.InputmoneyValid("100")==true);
    }
}