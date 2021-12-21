package main;

public class ThePlayer {
    private int amountmoney;
    private int playerpoint;
    public ThePlayer(){
        this.amountmoney=100;
        this.playerpoint=0;
    }
    public void sumofplayerpoint(int x, int y){
        this.playerpoint=x+y;
    }

    public void showplayerpoint(){
        System.out.println(this.playerpoint);
    }
    public int getPlayerpoint(){
        return this.playerpoint;
    }
    public int sumofmoney(int x){
        int money=this.amountmoney+x;
        this.amountmoney=money;
        return money;
    }

    public static boolean InputValid(String input1){
        String regularinput="[0-1]";
        if(input1.matches(regularinput)){
            return true;
        }else{
            return false;
        }
    }
    public static boolean InputmoneyValid(String input1){
        String regularinput="^[0-9]*[1-9][0-9]*$";
        if(input1.matches(regularinput)){
            return true;
        }else{
            return false;
        }
    }
}
