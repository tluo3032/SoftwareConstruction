package com.assignment;

public class Statecontext {
    private State state;
    public void setState(State thestate){
        state=thestate;
    }
    public void samplestate(int rp,int wp){
        state.samplestate(rp,wp);
    }
}
