package model;

/**
 * Created by victor on 08/12/15.
 */
public class Virus {

    private Room position;
    private VirusType type;

    public Virus(Room room, VirusType color){

        this.position = room;
        type = color;
    }

    public static void ajouterVirus(Room r, VirusType type){
        r.infect(new Virus(r, type));
    }

    public static void propagation(Room room) {

        for (int i = 0; i < room.getNeighborsRooms().size(); i++) {
            room.getNeighborsRooms().get(i).infect(new Virus(room.getNeighborsRooms().get(i), VirusType.BLUE));
        }

    }

    public VirusType getVirusType(){ return type; }
}
