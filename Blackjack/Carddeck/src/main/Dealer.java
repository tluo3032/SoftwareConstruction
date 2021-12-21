package main;

import org.junit.Before;

public class Dealer {
    private int dealerpoint;
    public Dealer(){
        this.dealerpoint=0;
    }
    public void sumofdealerpoint(int x,int y){
        this.dealerpoint=x+y;
    }

    public void showdealerpoint(){
        System.out.println(this.dealerpoint);
    }
    public int getDealerpoint(){
        return this.dealerpoint;
    }
}
