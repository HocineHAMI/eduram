package model;

import java.util.ArrayList;

/**
 * Created by victor on 08/12/15.
 */
public /*abstract*/ class Player {
    private Room position;
    private ArrayList<Password> passwords;
    private int nbActions=0;


    public Player(Room position, PasswordStack passStack){
        passwords = new ArrayList<Password>();
        getCardFromStack(passStack);
        System.out.println("test !!!!!");
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
    public void givePassword(Password givePass, Player toPlayer){
        this.passwords.remove(givePass);
        toPlayer.passwords.add(givePass);
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
            r.delVirus();
            return true;
        }
        return false;
    }

    public ArrayList<Password> getListPassword(){ return passwords;}
    public Room getPositionRoom(){ return position;}
    public static void main(String[] args){
        Map m = new Map();
        Player p1 = new Player(m.getBuildings().get(1).getRooms().get(1), new PasswordStack(m));
        p1.move((m.getBuildings().get(2).getRooms().get(1)));
        p1.move((m.getBuildings().get(1).getRooms().get(2)));

    }

    public int getNbActions() {
        return nbActions;
    }

    public void setNbActions(int nbActions) {
        this.nbActions = nbActions;
    }
}
