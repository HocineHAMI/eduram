package model;

/**
 * Created by victor on 08/12/15.
 */
public class Virus {

    private Room position;

    public Virus(Room room){
        this.position = room;
    }

    public static void ajouterVirus(Room r){
        r.infect(new Virus(r));;
    }

//TODO
    public static void propagation(Room room) {

        for (int i = 0; i < room.getNeighborsRooms().size(); i++) {
            room.getNeighborsRooms().get(i).infect(new Virus(room.getNeighborsRooms().get(i)));
        }

    }
}
