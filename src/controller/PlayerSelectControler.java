package controller;

import model.Game;
import model.Player;

/**
 * Created by kwidz on 08/01/16.
 */
public class PlayerSelectControler {
    public static void selectPlayer(Game game, Player player){
        game.setSelectedPlayer(player);
    }
}
