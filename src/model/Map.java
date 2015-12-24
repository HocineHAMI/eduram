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
            buildings.add(new Building(3,3,100,100));
            buildings.add(new Building(6,3,200,100));
            buildings.add(new Building(3,5,300,100));
            buildings.add(new Building(3,4,400,100));


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
