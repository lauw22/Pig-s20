package edu.up.cs301.pig;

import java.util.Random;

import edu.up.cs301.game.GameFramework.GameComputerPlayer;
import edu.up.cs301.game.GameFramework.actionMessage.GameAction;
import edu.up.cs301.game.GameFramework.infoMessage.GameInfo;
import edu.up.cs301.game.GameFramework.utilities.Tickable;

/**
 * An AI for Pig
 *
 * @author Andrew M. Nuxoll
 * @version August 2015
 */
public class PigComputerPlayer extends GameComputerPlayer {
    Random ran = new Random();

    /**
     * ctor does nothing extra
     */
    public PigComputerPlayer(String name) {
        super(name);
    }

    /**
     * callback method--game's state has changed
     *
     * @param info
     * 		the information (presumably containing the game's state)
     */
    @Override
    protected void receiveInfo(GameInfo info) {
        if(info instanceof PigGameState) {
            PigGameState pgState;
            pgState = (PigGameState) info;
            int ranNum = ran.nextInt(1);
            if(playerNum != pgState.getPlayerID()){
                return;
            }else{
                PigHoldAction hold = new PigHoldAction(this);
                PigRollAction roll = new PigRollAction(this);
                if(ranNum == 0){
                    game.sendAction(hold);
                }else if(ranNum == 1){
                    game.sendAction(roll);
                }
            }
        }
        // TODO  You will implement this method
    }//receiveInfo

}
