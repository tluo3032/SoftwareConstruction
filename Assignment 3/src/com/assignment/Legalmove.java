package com.assignment;

public class Legalmove {
    private Piecelegalmove piecelegalmove;
    public void setPiecetype(Piecelegalmove thepiecelegalmove){
        piecelegalmove=thepiecelegalmove;
    }
    public boolean iflegalmove(board newboard,int x,int y,int z,int t){

        return piecelegalmove.legalmove(newboard,x,y,z,t);
    }
}
