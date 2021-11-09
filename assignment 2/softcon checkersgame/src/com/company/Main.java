package com.company;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Theplayer theplayer = new Theplayer(1);
        board test = new board();
        boolean legal;
        boolean kinglegal;
        //initialize the board and pieces
        test.initial();
        test.show();
        System.out.print("\nRed player plays first.");
        System.out.println("\nEnter the position as [current piece position]X[future piece position]:(for example [b6]X[a5])");
        while (!test.ifend()) {

            Scanner input = new Scanner(System.in);
            String theinput;
            theinput = input.nextLine();
            char[] newArray = new char[theinput.length()];
            for (int i = 0; theinput.length() >i; i++){
                newArray[i] = theinput.charAt(i);
            }
            boolean correctInput = true;
            System.out.println(newArray);

            /*if (newArray[0] != '[' ||!(newArray[1] == ('a'|'b'|'c'|'d'|'e'|'f'|'g'|'h'))/*||newArray[6] != ('a'|'b'|'c'|'d'|'e'|'f'|'g'|'h')|| newArray[2] != ('1'|'2'|'3'|'4'|'5'|'6'|'7'|'8')|| newArray[7]!= ('1'|'2'|'3'|'4'|'5'|'6'|'7'|'8')|| newArray[3] != ']' || newArray[4] != 'X' || newArray[5] != '[' || newArray[8] != ']'){
                correctInput = false;
            }
            System.out.println(correctInput);*/


            String m = String.valueOf(newArray[1]);
            String n = String.valueOf(newArray[6]);

            int x = Character.getNumericValue(newArray[2]);
            int z = Character.getNumericValue(newArray[7]);
            int y, t;
            int i = 1;
            switch (m) {
                case "a":
                    i = 0;
                    break;
                case "b":
                    i = 1;
                    break;
                case "c":
                    i = 2;
                    break;
                case "d":
                    i = 3;
                    break;
                case "e":
                    i = 4;
                    break;
                case "f":
                    i = 5;
                    break;
                case "g":
                    i = 6;
                    break;
                case "h":
                    i = 7;
                    break;
            }
            y = i;

            switch (n) {
                case "a":
                    i = 0;
                    break;
                case "b":
                    i = 1;
                    break;
                case "c":
                    i = 2;
                    break;
                case "d":
                    i = 3;
                    break;
                case "e":
                    i = 4;
                    break;
                case "f":
                    i = 5;
                    break;
                case "g":
                    i = 6;
                    break;
                case "h":
                    i = 7;
                    break;
            }
            t = i;
            x=8-x;
            z=8-z;
            legal = test.iflegal(x, y, z, t)&&test.ifdiagonal(x,y,z,t)&&(!test.ifnsquares(x,y,z,t))&&test.ifmoveaway(x,y,z,t);
            kinglegal=test.ifdiagonal(x,y,z,t)&&test.iflegal(x,y,z,t)&&(!test.ifnsquares(x,y,z,t));
            if(test.ifking(x,y)){
                if(kinglegal){
                    if(theplayer.rightturn(test,x,y)){
                        test.playermove(x, y, z, t);
                        test.capturepiece(x, y, z, t);
                        if(!theplayer.isthisjump(test,x,y,z,t)){
                            theplayer.changeplayer();
                        }
                    }
                }
            }
            if(!test.ifking(x,y)) {
                if (legal) {
                    if(theplayer.rightturn(test,x,y)){
                        test.playermove(x, y, z, t);
                        test.capturepiece(x, y, z, t);
                        test.kingconversion(z,t);
                        if(!theplayer.isthisjump(test,x,y,z,t)){
                            theplayer.changeplayer();
                        }
                    }
                }
            }
            test.show();
            theplayer.isthisjump(test,x,y,z,t);
            if(theplayer.isthisjump(test,x,y,z,t)){
                test.singlejump(z,t);
            }
            theplayer.hintcolor();
            System.out.println("\nEnter the position as [current piece position]X[future piece position]:(for example [b6]X[a5])");
            if(!theplayer.isthisjump(test,x,y,z,t)){
                for (int w = 0; w < 8; w++) {
                    for (int j = 0; j < 8; j++) {
                        test.singlejump(w, j);
                    }
                }
            }
        }
        if(test.ifend()){
            Winner W1=Winner.getWinner();
        }
    }
}
