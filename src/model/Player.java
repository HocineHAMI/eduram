package model;

import javafx.scene.paint.Color;

import java.util.ArrayList;

/**
 * Created by victor on 08/12/15.
 */
public /*abstract*/ class Player {
    private Game game;
    private Room position;
    private ArrayList<Password> passwords;
    private int nbActions=0;


    public Player(Room position, PasswordStack passStack, Game game){
        this.game=game;
        passwords = new ArrayList<Password>();
        getCardFromStack(passStack);
        System.out.println("Creation Player !!!!!");
        this.position = position;
    }

    public boolean move(Room next){

        if(this.position.isNeighbor(next)){
            this.position = next;

            System.out.println("Deplacement Terminé !");
            return true;
        }
        else{
            System.out.println("we can't move here !");

        }
        return false;

    }

    public boolean moveTP(Room next, Password pass){

        if(next==null)
            return false;
            this.position = next;
            this.passwords.remove(pass);
        System.out.println(next);
            System.out.println("Deplacement Terminé !");
            return true;

    }

    public void addPassword(Password givePass){
        this.passwords.add(givePass);
    }
    public void lostPassword(Password lostPass){
        this.passwords.remove(lostPass);
    }

    public void getCardFromStack(PasswordStack pstack){
        if (!pstack.isEmpty()){
            passwords.add(pstack.getOnePass());
        }
    }
    public boolean delVirus(Room r)
    {

        if((r.getViruses().size()!=0)&&(this.position==r))
        {
            switch (r.getBuilding().getColor()){
                case GREEN:
                    if(game.isAntidoteVert()){
                        r.deleteAllVirus(VirusType.GREEN);
                        return true;
                    }
                case GOLD:
                    if(game.isAntidoteJaune()){
                        r.deleteAllVirus(VirusType.GOLD);
                        return true;
                    }
                case RED:
                    if(game.isAntidoteRouge()){
                        r.deleteAllVirus(VirusType.RED);
                        return true;
                    }
                case BLUE:
                    if(game.isAntidoteBleu()){
                        r.deleteAllVirus(VirusType.BLUE);
                        return true;
                    }
            }
            System.out.println("appel Supression "+r);
            r.delVirus();
            return true;
        }
        return false;
    }

    public ArrayList<Password> getListPassword(){ return passwords;}
    public Room getPositionRoom(){ return position;}

    public int getNbActions() {
        return nbActions;
    }

    public void setNbActions(int nbActions) {
        this.nbActions = nbActions;
    }
}
