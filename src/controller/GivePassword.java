package controller;

import model.Game;

/**
 * Created by victor on 07/01/16.
 */
public class GivePassword {
    public static void give(Game game){
        game.getCurrentPlayer().lostPassword(game.getSelectedPass());
        game.getSelectedPlayer().addPassword(game.getSelectedPass());

        game.getCurrentPlayer().setNbActions(game.getCurrentPlayer().getNbActions()+1);
        if(game.getCurrentPlayer().getNbActions()>=4) {
            game.getCurrentPlayer().setNbActions(0);
            game.nextTurn();
        }

    }

}
