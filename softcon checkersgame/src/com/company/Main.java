package com.company;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        board test = new board();
        boolean legal;
        boolean kinglegal;
        //initialize the board and pieces
        test.initial();
        test.show();

        while (!test.ifend()) {
            System.out.println("\nEnter the position:(for example 2 b 3 c )");
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    test.singlejump(i, j);
                }
            }
            Scanner input = new Scanner(System.in);
            Scanner letterinput = new Scanner(System.in);
            String m, n;
            int x, y, z, t;
            int i = 1;
            System.out.print("current x=");
            x = input.nextInt();
            System.out.print("current y=");
            m = letterinput.nextLine();
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
            System.out.print("future x=");
            z = input.nextInt();
            System.out.print("future y=");
            n = letterinput.nextLine();
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

            legal = test.iflegal(x, y, z, t)&&test.ifdiagonal(x,y,z,t)&&(!test.ifnsquares(x,y,z,t))&&test.ifmoveaway(x,y,z,t);
            kinglegal=test.ifdiagonal(x,y,z,t)&&test.iflegal(x,y,z,t)&&(!test.ifnsquares(x,y,z,t));
            if(test.ifking(x,y)){
                if(kinglegal){
                    test.playermove(x, y, z, t);
                    test.capturepiece(x, y, z, t);
                }
            }
            if(!test.ifking(x,y)) {
                if (legal) {
                    test.playermove(x, y, z, t);
                    test.capturepiece(x, y, z, t);
                }
            }
            test.show();
        }
    }
}
