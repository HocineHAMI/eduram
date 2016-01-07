package controller;

import model.Game;
import model.Password;
import model.Player;

/**
 * Created by victor on 07/01/16.
 */
public class GivePassword {
    public static void give(Game game){
        game.getCurrentPlayer().givePassword(game.getSelectedPass(), game.getSelectedPlayer());
        game.getCurrentPlayer().setNbActions(game.getCurrentPlayer().getNbActions()+1);
        if(game.getCurrentPlayer().getNbActions()>=4) {
            game.getCurrentPlayer().setNbActions(0);
            game.nextTurn();
        }

    }

}
