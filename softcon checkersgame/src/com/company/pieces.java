package com.company;

public class pieces {
    private int player;
    /*player=0:no piece,
    player=1:red pawn pieces,
    player=2:white pawn pieces,
    player=3:red king pieces,
    player=4:white king pieces
    */

    private int capture;
    private boolean king;
    //public String color;

    public int getplayer(){
        return player;
    }
    public boolean isking(){
        return king;
    }
    public int ifcapture(){
        return capture;
    }

    pieces(int k){
        player=k;
        capture=0;
        king=false;
    }

}
