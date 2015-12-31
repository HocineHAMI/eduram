package model;

import java.util.ArrayList;

/**
 * Created by victor on 08/12/15.
 */
public /*abstract*/ class Player {
    private Room position;
    private ArrayList<Password> passwords;


    public Player(Room position){
        this.position = position;
    }

    public void move(Room next){

        if(this.position.isNeighboor(next)){
            this.position = next;

            System.out.println("Deplacement Terminé !");
        }
        else{
            System.out.println("we can't move here !");

        }

    }

    public ArrayList<Password> getListPassword(){ return passwords;}
    public static void main(String[] args){
        Map m = new Map();
        Player p1 = new Player(m.getBuildings().get(1).getRooms().get(1));
        p1.move((m.getBuildings().get(2).getRooms().get(1)));
        p1.move((m.getBuildings().get(1).getRooms().get(2)));

    }

}
