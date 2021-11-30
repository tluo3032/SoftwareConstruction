package com.assignment;

public class bomblegalmove implements Piecelegalmove {
    public boolean legalmove(board newboard, int x,int y,int z, int t){
        boolean bomblegalmove;
        bomblegalmove=newboard.ifdiagonal(x,y,z,t)&&newboard.iflegal(x,y,z,t)&&(!newboard.ifnsquares(x,y,z,t));
        return bomblegalmove;
    }
}
