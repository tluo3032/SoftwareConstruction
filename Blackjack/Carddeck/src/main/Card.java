package main;


public class Card {
    private Suit aSuit;
    private Rank aRank;
    public State faceDown;
    public State faceUp;
    public StateTwo numberCard;
    public StateTwo aceOne;


    StateTwo stateTwo = numberCard;
    State state = faceUp;

    public Card(Rank pRank, Suit pSuit) {
        faceUp = new faceUp(this);
        faceDown = new faceDown(this);
        numberCard = new numberCard(this);
        aceOne = new aceOne(this);
        aRank = pRank;
        aSuit = pSuit;
    }

    /*
    public Card(main.java.Test.Rank testRank, main.java.Test.Suit testSuit) {
    }
    */

    public Rank getRank() {return aRank;}
    public Suit getSuit() {return aSuit;}

    public void setState(State state) {
        this.state = state;
    }
    public void setStateTwo(StateTwo stateTwo){
        this.stateTwo = stateTwo;
    }

    public void show(){
        state.show();
    }
    public int value(Card c){
        c.setStateTwo(c.numberCard);
        return stateTwo.value(c);
    }
}

