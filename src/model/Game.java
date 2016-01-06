package model;

import java.util.ArrayList;
import java.util.Random;

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

            Random r1 = new Random();

            int noBuilding = r1.nextInt(map.getBuildings().size());
            int noRoom = r1.nextInt(map.getBuildings().get(noBuilding).getRooms().size());
            map.getBuildings().get(noBuilding).getRooms().get(noRoom).infect(new Virus(map.getBuildings().get(noBuilding).getRooms().get(noRoom), map.getBuildings().get(noBuilding).getColor()));
            noBuilding = r1.nextInt(map.getBuildings().size());
            noRoom = r1.nextInt(map.getBuildings().get(noBuilding).getRooms().size());
            map.getBuildings().get(noBuilding).getRooms().get(noRoom).infect(new Virus(map.getBuildings().get(noBuilding).getRooms().get(noRoom), map.getBuildings().get(noBuilding).getColor()));

    }
}
