package model;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by victor on 08/12/15.
 */
public class Room {
    private ArrayList<Room> neighborsRooms;
    private Building building;
    private ArrayList<Virus> viruses;
    private int positionX;
    private int positionY;

    public Room(Building building, int i, int j){
        viruses = new ArrayList<Virus>();
        neighborsRooms = new ArrayList<Room>();
        this.building = building;
        positionX = building.getPositionX() + i +30;
        positionY = building.getPositionY() + j +30;
    }

    public void addNeighbor(Room room){

        this.neighborsRooms.add(room);

    }
    public void deleteNeighbors()
    {
        Random randomGenerator = new Random();
        int index = randomGenerator.nextInt(neighborsRooms.size());
        Room r = neighborsRooms.get(index);
        if(this.neighborsRooms.size()>2 && r.neighborsRooms.size()>2)
        {
            this.neighborsRooms.remove(r);
            r.neighborsRooms.remove(this);
        }
    }

    public boolean isNeighbor(Room r1){

        return (neighborsRooms.contains(r1));

    }

    public void infect(Virus virus){
        if(viruses.size()>=3){
            System.out.println("PROPAGATION !!! ");
            Virus.propagation(this, this.getViruses().get(0));
        }
        else{
            System.out.println("Infection !");
            viruses.add(virus);
        }
    }


    public String toString(){

        return "# I am a room and I've : #"+ neighborsRooms.size()+" neighboors\n";

    }
    public ArrayList<Virus> getViruses(){ return viruses;}
    public ArrayList<Room> getNeighborsRooms(){ return neighborsRooms;}

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }
}
