package controller;

import model.Game;
import model.Room;

/**
 * Created by kwidz on 07/01/16.
 */
public class DeleteVirusControler {

    public static boolean deleteVirus(Game game, Room r){
        if(game.getCurrentPlayer().delVirus(r))
        {
            game.getCurrentPlayer().setNbActions(game.getCurrentPlayer().getNbActions()+1);
            if(game.getCurrentPlayer().getNbActions()>=4) {
                game.getCurrentPlayer().setNbActions(0);
                game.nextTurn();
            }
            return true;
        }

        return false;


    }

}
