package model;

import java.util.ArrayList;

/**
 * Created by kwidz on 06/01/16.
 */
public class Game {


    private ArrayList<Player> players;
    private Map map;
    private int nbTours = 0;
    private int nbPlayers;

    public Game(int Nbplayers)
    {

        map=new Map();
        this.nbPlayers = Nbplayers;

        players = new ArrayList<Player>();
        for (int i = 0; i < Nbplayers; i++)
        {
            players.add(new Player(map.getBuildings().get(0).getRooms().get(2)));
        }


    }

    public void finTour()
    {
        nbTours++;

    }

    public Map getMap()
    {
        return map;
    }

    public Player getCurrentPlayer()
    {
        return(players.get(0));
    }



}
