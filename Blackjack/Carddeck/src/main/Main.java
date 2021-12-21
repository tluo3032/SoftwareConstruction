package main;

import main.ThePlayer;

import java.util.Scanner;
public class Main {
    public Main() {
    }

    public static void main(String[] args) {

        ThePlayer player1 = new ThePlayer();

        while(player1.sumofmoney(0) >= 0) {
            Deck deck = new Deck();
            deck.shuffle();
            System.out.printf("The player has money: %d CHF\n", player1.sumofmoney(0));
            System.out.println("Do you want to bet or go away with the money?");

            System.out.println("Please enter 1 if you want to bet, otherwise enter 0.");
            boolean correctinput1=false;
            String input0 = null;
            while(!correctinput1) {
                Scanner sc = new Scanner(System.in);
                input0 = sc.nextLine();
                if (ThePlayer.InputValid(input0)) {
                    correctinput1 = true;
                } else {
                    correctinput1 = false;
                }

                if (!correctinput1) {
                    System.out.println("Please enter 1 or 0.");
                }
            }

            int betorgoaway = Integer.valueOf(input0);
            if(betorgoaway==0){
                break;
            }

            System.out.println("How much money you want to bet?");
            String input1 = null;
            boolean correctmoney = false;

            int betmoney;
            while(!correctmoney) {
                Scanner sc1 = new Scanner(System.in);
                System.out.println("Please enter a number.");
                input1 = sc1.nextLine();
                if (ThePlayer.InputmoneyValid(input1)) {
                    correctmoney = true;
                } else {
                    correctmoney = false;
                }

                if (!correctmoney) {
                    System.out.println("Please enter a number.");
                } else {
                    betmoney = Integer.valueOf(input1);
                    if (betmoney > player1.sumofmoney(0)) {
                        correctmoney = false;
                        System.out.println("Please enter a number less than the amount of money you have.");
                    }
                }
            }
            betmoney = Integer.valueOf(input1);

            //player is dealt cards
            int acesnumber1=0;
            int acesnumber2=0;
            Card playercard1 = deck.draw();
            Card playercard2 = deck.draw();
            if (playercard1.getRank() == Rank.ACE){
                acesnumber1+=1;
            }
            if (playercard2.getRank() == Rank.ACE){
                acesnumber1+=1;
            }
            System.out.println("The players' two cards:");
            playercard1.show();
            playercard2.show();
            player1.sumofplayerpoint(playercard1.value(playercard1), playercard2.value(playercard2));

            System.out.println("Now the player has points:");
            player1.showplayerpoint();
            int points1 = player1.getPlayerpoint();
            Dealer dealer1 = new Dealer();
            Card dealercard1 = deck.draw();
            Card dealercard2 = deck.draw();
            if (dealercard1.getRank() == Rank.ACE){
                acesnumber2+=1;
            }
            if (dealercard2.getRank() == Rank.ACE){
                acesnumber2+=1;
            }
            System.out.println("The dealer's two cards:");
            dealercard1.show();
            dealercard2.setState(dealercard2.faceDown);
            dealercard2.show();
            dealer1.sumofdealerpoint(dealercard1.value(dealercard1), dealercard2.value(dealercard2));
            System.out.println("Now the points of the dealer's first card is:");
            System.out.println(dealercard1.value(dealercard1));
            int points2 = dealer1.getDealerpoint();


            while(points1 <= 21) {
                String input = null;
                boolean correctinput = false;
                System.out.println("Hit or Stay?");
                System.out.println("Please enter 1 if you want to hit, otherwise enter 0.");

                while(!correctinput) {
                    Scanner sc = new Scanner(System.in);
                    input = sc.nextLine();
                    if (ThePlayer.InputValid(input)) {
                        correctinput = true;
                    } else {
                        correctinput = false;
                    }

                    if (!correctinput) {
                        System.out.println("Please enter 1 or 0.");
                    }
                }

                int hitorstay = Integer.valueOf(input);
                if (hitorstay == 1) {
                    Card playercard3 = deck.draw();
                    if (playercard3.getRank() == Rank.ACE){
                        acesnumber1+=1;
                    }
                    player1.sumofplayerpoint(player1.getPlayerpoint(), playercard3.value(playercard3));
                    System.out.println("The player get card:");
                    playercard3.show();
                    System.out.println("Now the player has points:");
                    player1.showplayerpoint();
                    points1 = player1.getPlayerpoint();

                    while(points1>21){
                        if(acesnumber1>0){
                            points1=points1-10;
                            acesnumber1-=1;
                            System.out.println("Aces is worth 1.");
                            player1.sumofplayerpoint(0,points1);
                            System.out.println("Now the player has points:");
                            player1.showplayerpoint();
                        }else{
                            break;
                        }
                    }

                    if(points1>21){
                        System.out.println("The player busts and lost this bet.");
                        player1.sumofmoney(-betmoney);
                        System.out.println("\n");
                    }
                }


                if (hitorstay == 0) {
                    break;
                }
            }

            System.out.println("The second card of the dealer:");
            dealercard2.setState(dealercard2.faceUp);
            dealercard2.show();
            int newpoints2=0;
            System.out.println("The dealer has points:");
            dealer1.showdealerpoint();


            if (points1 <= 21) {
                //The player has a chance to choose if double the money of bet
                System.out.println("Do you want to double the money of bet?");
                System.out.println("Enter 1 if you want to double, otherwise enter 0.");
                boolean correctinput2=false;
                String input2 = null;
                while(!correctinput2) {
                    Scanner sc = new Scanner(System.in);
                    input2 = sc.nextLine();
                    if (ThePlayer.InputValid(input2)) {
                        correctinput2 = true;
                    } else {
                        correctinput2 = false;
                    }

                    if (!correctinput2) {
                        System.out.println("Please enter 1 or 0.");
                    }
                }

                int doubleornot = Integer.valueOf(input2);
                if(2*betmoney>player1.sumofmoney(0)){
                    System.out.println("Your money is not enough.");
                }else{
                    if(doubleornot==1){
                        betmoney=2*betmoney;
                    }
                }
                while(points2<17) {
                    System.out.println("Now the dealer hit:");
                    if (points2 <= 21) {
                        Card dealercard3 = deck.draw();
                        System.out.println("The dealer get card:");
                        dealercard3.show();
                        if(dealercard3.getRank() == Rank.ACE){
                            acesnumber2+=1;
                        }
                        dealer1.sumofdealerpoint(dealer1.getDealerpoint(), dealercard3.value(dealercard3));
                        newpoints2=dealer1.getDealerpoint();
                    } else {
                        System.out.println("The dealer busts.");
                    }
                    while(newpoints2>21){
                        if(acesnumber2>0){
                            newpoints2=newpoints2-10;
                            acesnumber2-=1;
                            System.out.println("Aces is worth 1.");
                            dealer1.sumofdealerpoint(0,newpoints2);
                            System.out.println("Now the dealer has points:");
                            dealer1.showdealerpoint();
                        }else{
                            break;
                        }
                    }
                    points2=newpoints2;
                }

                System.out.println("Now the dealer has points:");
                dealer1.showdealerpoint();
            }

            while(points2>21){
                if(acesnumber2>0){
                    points2=points2-10;
                    acesnumber2-=1;
                    System.out.println("Aces is worth 1.");
                    dealer1.sumofdealerpoint(0,points2);
                    System.out.println("Now the dealer has points:");
                    dealer1.showdealerpoint();
                }else{
                    break;
                }
            }
            if (points2 > 21) {
                System.out.println("The dealer busts and the player wins this bet.");
                player1.sumofmoney(betmoney);
            }

            if (points1 <= 21 && points2 <= 21) {
                if (points1 > points2) {
                    System.out.println("The player wins the bet.");
                    player1.sumofmoney(betmoney);
                }

                if (points1 < points2) {
                    System.out.println("The dealer wins the bet.");
                    player1.sumofmoney(-betmoney);
                }

                if (points1 == points2) {
                    System.out.println("This bet is a tie.");
                }
            }
            System.out.println("♥♣♠♦♥♣♠♦♥♣♠♦♥♣♠♦♥♣♠♦♥♣♠♦♥♣♠♦♥♣♠♦♥♣♠♦♥♣♠♦♥♣♠♦♥♣♠♦");
            System.out.println("\n");
            if (player1.sumofmoney(0) == 0) {
                System.out.println("The player lost all the money,the game is finished.");
                break;
            }
        }

    }
}