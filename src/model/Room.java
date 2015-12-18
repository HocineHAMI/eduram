package model;

import java.util.ArrayList;

/**
 * Created by victor on 08/12/15.
 */
public class Room {
    private ArrayList<Room> neighboorsRooms;
    private Building building;
    private ArrayList<Virus> viruses;

        public Room(Building building){
            viruses = new ArrayList<Virus>();
            neighboorsRooms = new ArrayList<Room>();
            this.building = building;

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
}
