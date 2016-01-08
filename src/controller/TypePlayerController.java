package controller;

import model.*;
import view.AdminSysView;
import view.PlayerView;
import view.ScientistView;
import view.TechnicianView;

/**
 * Created by victor on 08/01/16.
 */
public class TypePlayerController {
    public static PlayerView chooseTypePlayer(int i, Game game, Player p, PlayerView tmpPlayer){
        if (p instanceof Scientist){
            tmpPlayer = new ScientistView(i, game, p);
        }
        else if(p instanceof Technician){
            tmpPlayer = new TechnicianView(i, game, p);
        }
        else if(p instanceof AdminSys){
            tmpPlayer = new AdminSysView(i, game, p);
        }else {
            tmpPlayer = new PlayerView(i, game, p);
        }

        return tmpPlayer;
    }
}
