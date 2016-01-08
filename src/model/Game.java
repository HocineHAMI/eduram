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
    private Player currentplayer;
    private Player selectedPlayer;
    private Password selectedPass;
    private int nbPropagation = 0;
    private boolean antidoteJaune=false;
    private boolean antidoteVert=false;
    private boolean antidoteRouge=false;
    private boolean antidoteBleu=false;

    public boolean isAntidoteJaune() {
        return antidoteJaune;
    }

    public boolean isAntidoteVert() {
        return antidoteVert;
    }

    public boolean isAntidoteRouge() {
        return antidoteRouge;
    }

    public boolean isAntidoteBleu() {
        return antidoteBleu;
    }

    public void setAntidoteVert(boolean antidoteVert) {
        this.antidoteVert = antidoteVert;
    }

    public void setAntidoteRouge(boolean antidoteRouge) {
        this.antidoteRouge = antidoteRouge;
    }

    public void setAntidoteBleu(boolean antidoteBleu) {
        this.antidoteBleu = antidoteBleu;
    }

    public void setAntidoteJaune(boolean antidoteJaune) {
        this.antidoteJaune = antidoteJaune;
    }


    public PasswordStack getPstack() {
        return pstack;
    }

    private PasswordStack pstack;


    public Game(int Nbplayers)
    {

        map = new Map(this);
        pstack = new PasswordStack(map);

        this.nbPlayers = Nbplayers;

        players = new ArrayList<Player>();
        players.add(new Technician(map.getBuildings().get(0).getRooms().get(2), pstack, this));

        players.add(new AdminSys(map.getBuildings().get(1).getRooms().get(2), pstack, this));
        players.add(new Scientist(map.getBuildings().get(1).getRooms().get(2), pstack, this));
        currentplayer = players.get(0);

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
        return(currentplayer);
    }
    public Player getSelectedPlayer() { return selectedPlayer;}
    public Password getSelectedPass() { return selectedPass;}

    public void setSelectedPass(Password selectedPass) { this.selectedPass = selectedPass;}
    public void setSelectedPlayer(Player selectedPlayer) { this.selectedPlayer = selectedPlayer;}



    public void nextTurn(){

        currentplayer.getCardFromStack(pstack);
        if(players.indexOf(currentplayer)+1<nbPlayers)
            this.currentplayer = players.get(players.indexOf(currentplayer)+1);
        else
            this.currentplayer = players.get(0);

            Random r1 = new Random();

            int noBuilding = r1.nextInt(map.getBuildings().size());
            int noRoom = r1.nextInt(map.getBuildings().get(noBuilding).getRooms().size());
            map.getBuildings().get(noBuilding).getRooms().get(noRoom).infect(new Virus(map.getBuildings().get(noBuilding).getRooms().get(noRoom), map.getBuildings().get(noBuilding).getColor()));
            noBuilding = r1.nextInt(map.getBuildings().size());
            noRoom = r1.nextInt(map.getBuildings().get(noBuilding).getRooms().size());
            map.getBuildings().get(noBuilding).getRooms().get(noRoom).infect(new Virus(map.getBuildings().get(noBuilding).getRooms().get(noRoom), map.getBuildings().get(noBuilding).getColor()));

    }

    public int getNbPropagation() {
        return nbPropagation;
    }

    public void setNbPropagation(int nbPropagation) {
        this.nbPropagation = nbPropagation;
    }
}
