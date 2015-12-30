package model;

import java.util.ArrayList;

/**
 * Created by victor on 08/12/15.
 */
public class Room {
    private ArrayList<Room> neighboorsRooms;
    private Building building;
    private ArrayList<Virus> viruses;
    private int positionX;
    private int positionY;

    public Room(Building building, int i, int j){
        viruses = new ArrayList<Virus>();
        neighboorsRooms = new ArrayList<Room>();
        this.building = building;
        positionX = building.getPositionX() + i +30;
        positionY = building.getPositionY() + j +30;
    }

    public void addNeighboor(Room room){

        this.neighboorsRooms.add(room);

    }

    public boolean isNeighboor(Room r1){

        return (neighboorsRooms.contains(r1));

    }

    public void infect(Virus virus){
        if(viruses.size()>=3){
            System.out.println("PROPAGATION !!! ");
            Virus.propagation(this);
        }
        else{
            System.out.println("Infection !");
            viruses.add(virus);
        }
    }


    public String toString(){

        return "# I am a room and I've : #"+neighboorsRooms.size()+" neighboors\n";

    }
    public ArrayList<Virus> getViruses(){ return viruses;}
    public ArrayList<Room> getNeighboorsRooms(){ return neighboorsRooms;}

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }
}
