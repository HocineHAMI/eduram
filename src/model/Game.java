package model;

import java.util.ArrayList;

/**
 * Created by kwidz on 06/01/16.
 */
public class Game {


    private ArrayList<Player> players;
    private Map map;
    private int nbPlayers;
    private Player curentplayer;


    public Game(int Nbplayers)
    {

        map=new Map();
        this.nbPlayers = Nbplayers;

        players = new ArrayList<Player>();
        for (int i = 0; i < Nbplayers; i++)
        {
            players.add(new Player(map.getBuildings().get(0).getRooms().get(2)));
        }
        curentplayer=players.get(0);


    }


    public Map getMap()
    {
        return map;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public int getNbPlayers() {
        return nbPlayers;
    }

    public void setNbPlayers(int nbPlayers) {
        this.nbPlayers = nbPlayers;
    }

    public Player getCurrentPlayer()
    {
        return(curentplayer);
    }


    public void nextTurn() {
        if(players.indexOf(curentplayer)+1<nbPlayers)
            this.curentplayer = players.get(players.indexOf(curentplayer)+1);
        else
            this.curentplayer = players.get(0);
    }
}
