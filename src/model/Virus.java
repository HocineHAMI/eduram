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

    /*public static void ajouterVirus(Room r, VirusType type){
        r.infect(new Virus(r, type));
    }*/

    public static void propagation(Room room, Virus v, Game g) {
        g.setNbPropagation(g.getNbPropagation() + 1);
        if(g.getNbPropagation()>5){
            System.out.println("Game Over propagation !!!");
        }
        else {
            for (int i = 0; i < room.getNeighborsRooms().size(); i++) {
                room.getNeighborsRooms().get(i).infect(new Virus(room.getNeighborsRooms().get(i), v.type));
            }

        }
    }

    public VirusType getVirusType(){ return type; }
}
