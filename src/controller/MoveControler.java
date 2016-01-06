package controller;

import model.Game;
import model.Player;
import model.Room;

/**
 * Created by kwidz on 04/01/16.
 */
public class MoveControler {

    public static boolean move(Game p, Room r){
        if(p.getCurrentPlayer().move(r))
        {
            p.getCurrentPlayer().setNbActions(p.getCurrentPlayer().getNbActions()+1);
            if(p.getCurrentPlayer().getNbActions()==4)
                p.nextTurn();
            return true;
        }

        return false;


    }

}
