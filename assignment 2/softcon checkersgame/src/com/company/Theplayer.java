package com.company;

public class Theplayer {
    private int playercolor;//red player=1,white player=2
    Theplayer(int i){
        playercolor=i;
    }

    //change player
    public void changeplayer(){
        if(playercolor==1){
            playercolor=2;
            //System.out.print("\nNow the white player plays.\n");
        }else
        {
            playercolor=1;
            //System.out.print("\nNow the red player plays.\n");
        }
    }
    public void hintcolor(){
        if(playercolor==1){
            System.out.print("\nNow the red player plays.\n");
        }
        if(playercolor==2){
            System.out.print("\nNow the white player plays.\n");
        }
    }
    //check if a multiple jump move is going on
    public boolean isthisjump(board theboard,int currentx,int currenty,int futurex,int futurey){
        boolean thisjump = false;
        if(Math.abs(currentx-futurex)!=1){
            if(theboard.singlejump(futurex,futurey)==true){
                thisjump=true;
                System.out.println("The multiple jump is not end.");
            }
        }
        return thisjump;
    }

    public boolean rightturn(board theboard,int currentx,int currenty){
        boolean color=false;
        if(theboard.piececolor(currentx,currenty)==playercolor){
            color=true;
        }else{
            System.out.println("Please switch player.");
        }
        return color;
    }
}
