package model;

import java.util.ArrayList;

/**
 * Created by victor on 08/12/15.
 */
public class Map {
    private ArrayList<Building> buildings;

    //generate a map with 4 statics buildings

    public Map(){

            buildings = new ArrayList<Building>();
            buildings.add(new Building(3,2,50,80));
            buildings.add(new Building(5,2,330,80));
            buildings.add(new Building(4,2,610,80));
            buildings.add(new Building(3,2,890,80));
        for (int i = 0; i < buildings.size(); i++) {
            buildings.get(i).deleteLinks();
        }
            linkBuildings();


        }

    public void linkBuildings(){

        buildings.get(0).link(buildings.get(1));
        buildings.get(1).link(buildings.get(2));
        buildings.get(2).link(buildings.get(3));
        //buildings.get(0).link(buildings.get(3));
    }

    public String toString(){
        return "I am a map : "+buildings;
    }


    public ArrayList<Building> getBuildings() {
        return buildings;
    }

    public static void main(String[] args){
        System.out.println(new Map());
    }

}
