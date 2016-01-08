package controller;

import model.Game;
import model.Password;
import view.MapView;

/**
 * Created by kwidz on 08/01/16.
 */
public class PasswordSelectControler {

    public static void selectPass(Game game, Password password, MapView map){
        game.setSelectedPass(password);
        map.setSelectedTpRoom(password.getBond());
        map.setSelectedPass(password);

    }

}
