package edu.up.cs301.pig;

import edu.up.cs301.game.GameFramework.infoMessage.GameState;

public class PigGameState extends GameState {
    private int playerID;
    private int p0Score;
    private int p1Score;
    private int runningTotal;
    private int currentVal;

    public PigGameState(){
        playerID = 0;
        p0Score = 0;
        p1Score = 0;
        runningTotal = 0;
        currentVal = 0;
    }

    PigGameState(PigGameState p){
        int currentVal1 = p.currentVal;
        int playerID1 = p.playerID;
        int p0Score1 = p.p0Score;
        int p1Score1 = p.p1Score;
        int runningTotal1 = p.runningTotal;
    }

    public int getPlayerID(){
        return playerID;
    }

    public int getP0Score(){
        return p0Score;
    }

    public int getP1Score(){
        return p1Score;
    }

    public int getRunningTotal(){
        return runningTotal;
    }

    public int getCurrentVal(){
        return currentVal;
    }

    public void setPlayerID(int playerID){
        this.playerID = playerID;
    }

    public void setP0Score(int p0Score){
        this.p0Score = p0Score;
    }

    public void setP1Score(int p1Score){
        this.p1Score = p1Score;
    }

    public void setRunningTotal(int runningTotal){
        this.runningTotal = runningTotal;
    }

    public void setCurrentVal(int currentVal){
        this.currentVal = currentVal;
    }
}
