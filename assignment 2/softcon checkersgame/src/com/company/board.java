package com.company;
import java.util.Scanner;

public class board{
    private String[][] board;
    private int redpieces=12;
    private int whitepieces=12;
    private pieces[][] piece;

    public board(){
        board=new String[8][9];
        initial();
        redpieces=12;
        whitepieces=12;
        for(int i=0; i<8;i++){
            board[i][8]=" |";
            //System.out.println("%s  %d",board[i][8], i);
        }

    }
//use board and pieces to store the coordinates of pieces at the same time
    public void initial(){
        piece=new pieces[8][8];
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                board[i][j]="[   ]";piece[i][j]=new pieces(0);
            }
        }
        for(int i=0;i<8;i++) {
            for (int j = 0; j < 8; j++){
                if(j%2!=0){
                    board[0][j]="[R_P]";piece[0][j]=new pieces(1);
                    board[2][j]="[R_P]";piece[2][j]=new pieces(1);
                    board[6][j]="[W_P]";piece[6][j]=new pieces(2);
                }
                if(j%2==0){
                    board[1][j]="[R_P]";piece[1][j]=new pieces(1);
                    board[5][j]="[W_P]";piece[5][j]=new pieces(2);
                    board[7][j]="[W_P]";piece[7][j]=new pieces(2);
                }
            }
        }
    }

    //public pieces piecelocation(int x,int y){
    //    return piece[x][y];
    //}

    public void show(){
        String []letter={"  a  ","  b  ","  c  ","  d  ","  e  ","  f  ","  g  ","  h"};
        System.out.print("    ");
        for(int j=0;j<8;j++){
            System.out.print(letter[j]);
        }
        System.out.print("\n  +------------------------------------------+");
        for(int i=0;i<8;i++){
            System.out.print("\n");
            System.out.printf("%d | ",8-i);
            for(int j=0;j<9;j++){
                System.out.print(board[i][j]);
            }
            System.out.printf(" %d ",8-i);
        }
        System.out.print("\n  +------------------------------------------+\n      a    b    c    d    e    f    g    h");

    }
//determine if the future location is occupied
    public boolean iflegal(int currentx,int currenty,int futurex,int futurey){
        boolean islegal=true;
        if(board[futurex][futurey]=="[R_P]"||board[futurex][futurey]=="[W_P]"){
            islegal=false;
            System.out.printf("Move is illegal!\n");
        }
        return islegal;
    };
    //check if the movement if diagonally
    public boolean ifdiagonal(int currentx,int currenty,int futurex,int futurey){
        int xchange;
        int ychange;
        xchange=Math.abs(currentx-futurex);
        ychange=Math.abs(currenty-futurey);
        if(xchange==ychange){
            return true;
        }else{
            System.out.printf("The movement is not diagonal\n");
            return false;
        }
    }

    //restriction for the simple move
    //avoid a path that jumps through multiple squares without opponents pieces
    public boolean ifnsquares(int currentx,int currenty,int futurex,int futurey){
        boolean nsquares=false;
        int emptysquares=0;
        int step=Math.abs(currentx-futurex);
        if(board[currentx][currenty]=="[R_P]"||board[currentx][currenty]=="[W_P]") {
            if(step>=2) {
                emptysquares = 1;
                if (futurex > currentx && futurey > currenty) {
                    for (int i = 1; i < step; i++) {
                        if (board[currentx + i][currenty + i] != "[   ]") {
                            emptysquares = 0;
                        }
                    }
                }
                if (futurex > currentx && futurey < currenty) {
                    for (int i = 1; i < step; i++) {
                        if (board[currentx + i][currenty - i]!= "[   ]") {
                            emptysquares = 0;
                        }
                    }
                }
                if (futurex < currentx && futurey > currenty) {
                    for (int i = 1; i < step; i++) {
                        if (board[currentx - i][currenty + i]!= "[   ]") {
                            emptysquares = 0;
                        }
                    }
                }
                if (futurex < currentx && futurey < currenty) {
                    for (int i = 1; i < step; i++) {
                        if (board[currentx - i][currenty - i] != "[   ]") {
                            emptysquares = 0;
                        }
                    }
                }
            }
        }
        if(emptysquares==1){
            nsquares=true;
        }
        if(nsquares){
           System.out.printf("The movement is illegal\n");
        }
        return nsquares;
    }

//check if the piece is moved diagonally foward away the player
    public boolean ifmoveaway(int currentx,int currenty,int futurex,int futurey){
        int moveaway=0;
        boolean canmoveaway=true;
        moveaway=currentx-futurex;
        if(board[currentx][currenty]== "[R_P]"){
            if(moveaway<0){
                canmoveaway=true;
            }
            if(moveaway>0){
                canmoveaway=false;
            }
        }
        if(board[currentx][currenty] == "[W_P]" ){
            if(moveaway>0){
                canmoveaway=true;
            }
            if(moveaway<0){
                canmoveaway=false;
            }
        }
        if(canmoveaway==false){
            System.out.printf("Move is illegal!\n");
        }
        return canmoveaway;
    }
    //check if there are pieces have to jump
    //look through all the pieces to determine if a jump is possible
    public boolean singlejump(int currentx,int currenty){
        boolean isjump=false;
        if(board[currentx][currenty]=="[R_P]"){
            //char y='y';
            //char z='z';
            if(currentx<=5&&currenty<=5){
                if(board[currentx+1][currenty+1]=="[W_P]"&&board[currentx+2][currenty+2]=="[   ]"){
                    isjump=true;
                    System.out.printf("a jump of red pieces is possible\n"/*,currentx,currenty,currentx+2,currenty+2*/);
                }
            }
            if(currentx<=5&&currenty>=2) {
                if (board[currentx + 1][currenty - 1] == "[W_P]" && board[currentx + 2][currenty - 2] == "[   ]") {
                    isjump = true;
                    //System.out.printf("For the second number of coordinate,0 to 7 correspond to a to h\n");
                    System.out.printf("a jump of red pieces is possible\n"/*, currentx, currenty, currentx + 2, currenty - 2*/);
                }
            }
        }

        if(board[currentx][currenty]=="[W_P]"){
            if(currentx>=2&&currenty>=2){
                if(board[currentx-1][currenty-1]=="[R_P]"&&board[currentx-2][currenty-2]=="[   ]"){
                    isjump=true;
                    //System.out.printf("For the second number of coordinate,0 to 7 correspond to a to h\n");
                    System.out.printf("a jump of white pieces is possible\n"/*,currentx,currenty,currentx-2,currenty-2*/);
                }
            }
            if(currentx>=2&&currenty<=5) {
                if (board[currentx - 1][currenty + 1] == "[R_P]"&& board[currentx - 2][currenty + 2] == "[   ]") {
                    isjump = true;
                    //System.out.printf("For the second number of coordinate,0 to 7 correspond to a to h\n");
                    System.out.printf("a jump of white pieces is possible\n"/*, currentx, currenty, currentx - 2, currenty + 2*/);
                }
            }
        }
        return isjump;
    }
    //Pawn's conversion
    //playmove first, let pieces be moved to the future location, then if it reached the king-row,change its type
    public void kingconversion(int futurex,int futurey){
        if(board[futurex][futurey]== "[R_P]"&&futurex==7){
            board[futurex][futurey]="[R_K]";
            piece[futurex][futurey]=new pieces(3);
        }
        if(board[futurex][futurey]== "[W_P]"&&futurex==0){
            board[futurex][futurey]="[W_K]";
            piece[futurex][futurey]=new pieces(4);
        }
    }

    //rules of King pieces
    public boolean ifking(int currentx,int currenty){
        boolean isking=false;
        if(board[currentx][currenty]=="R_K"||board[currentx][currenty]=="W_K"){
            isking=true;
        }
        return isking;
    }
//change the status of board and the location of pieces
//change the type of pieces if possible
    public void playermove(int currentx,int currenty,int futurex,int futurey){
        if(board[currentx][currenty]=="[R_P]"){
            board[currentx][currenty]="[   ]";
            board[futurex][futurey]="[R_P]";
            piece[currentx][currenty]=new pieces(0);
            piece[futurex][futurey]=new pieces(1);
        }
        if(board[currentx][currenty]=="[R_K]"){
            board[currentx][currenty]="[   ]";
            board[futurex][futurey]="[R_K]";
            piece[currentx][currenty]=new pieces(0);
            piece[futurex][futurey]=new pieces(3);
        }
        if(board[currentx][currenty]=="[W_P]"){
            board[currentx][currenty]="[   ]";
            board[futurex][futurey]="[W_P]";
            piece[currentx][currenty]=new pieces(0);
            piece[futurex][futurey]=new pieces(2);
        }
        if(board[currentx][currenty]=="[W_K]"){
            board[currentx][currenty]="[   ]";
            board[futurex][futurey]="[W_K]";
            piece[currentx][currenty]=new pieces(0);
            piece[futurex][futurey]=new pieces(4);
        }
        if(futurex==0&&board[futurex][futurey]=="[W_P]"){
            piece[futurex][futurey]=new pieces(4);
        }
        if(futurex==7&&board[futurex][futurey]=="[R_P]"){
            piece[futurex][futurey]=new pieces(3);
        }
    }

    public void capturepiece(int currentx,int currenty,int futurex,int futurey){
        if(Math.abs(currentx-futurex)>1){
            if((futurex<currentx)&&(futurey<currenty)){
                for(int i=1;i<Math.abs(currentx-futurex);i++){
                    board[currentx-i][currenty-i]="[   ]";
                    piece[currentx-i][currenty-i]=new pieces(0);
                }
            }
            if((futurex<currentx)&&(futurey>currenty)){
                for(int i=1;i<Math.abs(currentx-futurex);i++){
                    board[currentx-i][currenty+i]="[   ]";
                    piece[currentx-i][currenty+i]=new pieces(0);
                }
            }
            if((futurex>currentx)&&(futurey<currenty)){
                for(int i=1;i<Math.abs(currentx-futurex);i++){
                    board[currentx+i][currenty-i]="[   ]";
                    piece[currentx+i][currenty-i]=new pieces(0);
                }
            }
            if((futurex>currentx)&&(futurey>currenty)){
                for(int i=1;i<Math.abs(currentx-futurex);i++){
                    board[currentx+i][currenty+i]="[   ]";
                    piece[currentx+i][currenty+i]=new pieces(0);
                }
            }
        }
    }

    /*public int testplayer(int x,int y){
        int i=piece[x][y].getplayer();
        System.out.printf("player:%d",i);
        return i;
    }*/

    //check if the game is end
    public boolean ifend(){
        boolean isend=false;
        redpieces=0;
        whitepieces=0;
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(board[i][j]=="[R_P]"||board[i][j]=="[R_K]"){
                    redpieces++;
                }
                if(board[i][j]=="[W_P]"||board[i][j]=="W_K"){
                    whitepieces++;
                }
            }
        }
        if(redpieces==0||whitepieces==0){
            isend=true;
        }
        if(redpieces==0){
            System.out.printf("The winner is white pieces player!");
        }
        if(whitepieces==0){
            System.out.printf("The winner is red pieces player!");
        }
        return isend;
    }
    public int piececolor(int currentx,int currenty){
        int colorofpiece=0;
        if(board[currentx][currenty]=="[R_P]"||board[currentx][currenty]=="[R_K]"){
            colorofpiece=1;
        }
        if(board[currentx][currenty]=="[W_P]"||board[currentx][currenty]=="[W_K]"){
            colorofpiece=2;
        }
        return colorofpiece;
    }

}