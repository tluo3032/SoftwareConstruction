package com.assignment;

public class pawnlegalmove implements Piecelegalmove {
    public boolean legalmove(board newboard,int x,int y,int z,int t){
        boolean pawnlegalmove;
        pawnlegalmove = newboard.iflegal(x, y, z, t)&&newboard.ifdiagonal(x,y,z,t)&&(!newboard.ifnsquares(x,y,z,t))&&newboard.ifmoveaway(x,y,z,t);
        return pawnlegalmove;
    }
}
