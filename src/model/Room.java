package model;

import java.util.ArrayList;

/**
 * Created by victor on 08/12/15.
 */
public class Room {
    private ArrayList<Room> neighboorsRooms;
    private Building building;

        public Room(Building building){

            neighboorsRooms = new ArrayList<Room>();
            this.building = building;

        }

    public void addNeighboor(Room room){

        this.neighboorsRooms.add(room);

    }

    public boolean isNeighboor(Room r1){

        return (neighboorsRooms.contains(r1));

    }


    public String toString(){

        return "# I am a room and I've : #"+neighboorsRooms.size()+" neighboors\n";

    }
}
