package controller;

import model.Game;
import model.Password;

/**
 * Created by kwidz on 08/01/16.
 */
public class PasswordSelectControler {

    public static void selectPass(Game game, Password password){
        game.setSelectedPass(password);

    }

}
