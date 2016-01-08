package controller;

import model.Game;
import model.Password;
import model.VirusType;

import java.util.ArrayList;

/**
 * Created by kwidz on 07/01/16.
 */
public class CreateAntidoteControler {
    public static boolean creerAntidote(Game game) {
        return game.getCurrentPlayer().createAntidote();
    }
}
