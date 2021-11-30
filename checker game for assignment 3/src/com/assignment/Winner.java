package com.assignment;

public class Winner {
    private volatile static Winner winner;
    private Winner(){}
    public static Winner getWinner(){
        if(winner==null){
            synchronized(Winner.class){
                if(winner==null){
                    winner=new Winner();
                }
            }
        }
        return winner;
    }
}