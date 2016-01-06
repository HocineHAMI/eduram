package controller;

import model.Game;
import model.Player;
import model.Room;

/**
 * Created by kwidz on 04/01/16.
 */
public class MoveControler {

    public static boolean move(Game game, Room r){
        if(game.getCurrentPlayer().move(r))
        {
            game.getCurrentPlayer().setNbActions(game.getCurrentPlayer().getNbActions()+1);
            if(game.getCurrentPlayer().getNbActions()==4) {
                game.getCurrentPlayer().setNbActions(0);
                game.nextTurn();
            }
            return true;
        }

        return false;


    }

}
