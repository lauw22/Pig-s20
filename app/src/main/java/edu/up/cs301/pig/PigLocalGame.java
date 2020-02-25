package edu.up.cs301.pig;

import edu.up.cs301.game.GameFramework.GamePlayer;
import edu.up.cs301.game.GameFramework.LocalGame;
import edu.up.cs301.game.GameFramework.actionMessage.GameAction;
import edu.up.cs301.game.GameFramework.infoMessage.GameState;
import java.util.Random;

import android.util.Log;

/**
 * class PigLocalGame controls the play of the game
 *
 * @author Andrew M. Nuxoll, modified by Steven R. Vegdahl
 * @version February 2016
 */
public class PigLocalGame extends LocalGame {
    private PigGameState pgState;
    private Random ran;

    /**
     * This ctor creates a new game state
     */
    public PigLocalGame() {
        //TODO  You will implement this constructor
        pgState = new PigGameState();
    }

    /**
     * can the player with the given id take an action right now?
     */
    @Override
    protected boolean canMove(int playerIdx) {
        //TODO  You will implement this method
        if(pgState.getPlayerID() == playerIdx){
            return true;
        }
        return false;
    }

    /**
     * This method is called when a new action arrives from a player
     *
     * @return true if the action was taken or false if the action was invalid/illegal.
     */
    @Override
    protected boolean makeMove(GameAction action) {
        //TODO  You will implement this method
        if(action instanceof PigHoldAction){
            if(pgState.getPlayerID() == 0) {
                pgState.setP0Score(pgState.getRunningTotal() + pgState.getP0Score());
                pgState.setRunningTotal(0);
                if(players.length >= 1){
                    pgState.setPlayerID(1);
                }
                return true;
            } else if(pgState.getPlayerID() == 1){
                pgState.setP1Score(pgState.getRunningTotal() + pgState.getP1Score());
                pgState.setRunningTotal(0);
                if(players.length >= 1){
                    pgState.setPlayerID(0);
                }
                return true;
            }
        }
        if(action instanceof PigRollAction){
            ran = new Random();
            int ranNum = ran.nextInt(6);
            pgState.setCurrentVal(ranNum+1);
            if(pgState.getCurrentVal() > 1){
                pgState.setRunningTotal(pgState.getCurrentVal());
            }
            if(pgState.getCurrentVal() == 1){
                pgState.setRunningTotal(0);
                if(players.length >= 1){
                    if(pgState.getPlayerID() == 0){
                        pgState.setPlayerID(1);
                    } else if(pgState.getPlayerID() == 1){
                        pgState.setPlayerID(0);
                    }
                }
            }
            return true;
        }
        return false;
    }//makeMove

    /**
     * send the updated state to a given player
     */
    @Override
    protected void sendUpdatedStateTo(GamePlayer p) {
        //TODO  You will implement this method
        PigGameState copyState = new PigGameState();
        p.sendInfo(copyState);
    }//sendUpdatedSate

    /**
     * Check if the game is over
     *
     * @return
     * 		a message that tells who has won the game, or null if the
     * 		game is not over
     */
    @Override
    protected String checkIfGameOver() {
        //TODO  You will implement this method
        if(pgState.getP0Score() >= 50){
           System.out.println("Player 0 has won" + pgState.getP0Score());
        }
        if(pgState.getP1Score() >= 50){
            System.out.println("Player 1 has won" + pgState.getP1Score());
        }
        return null;
    }

}// class PigLocalGame
