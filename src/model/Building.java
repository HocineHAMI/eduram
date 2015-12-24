package model;

import java.util.ArrayList;

/**
 * Created by victor on 08/12/15.
 */
public class Building
{
    private ArrayList<Room> rooms;
    private int positionX;
    private int positionY;

    public Building(int width, int height, int x, int y)
    {
        rooms = new ArrayList<Room>();
        //create a tmp array in order to search neighbours easyer
        Room[][] roomsTmp;
        roomsTmp = new Room[height][width];
        positionX = x;
        positionY = y;

        //create all rooms in the building
        for (int i = 0; i < height; i++)
        {
            for (int j = 0; j < width; j++)
            {
                rooms.add(new Room(this));
                roomsTmp[i][j] = rooms.get(rooms.size()-1);
            }
        }

        //affects neighbours for all rooms in the building
        for (int i = 0; i < height; i++)
        {
            for (int j = 0; j < width; j++)
            {
                try {
                    roomsTmp[i][j].addNeighboor(roomsTmp[i - 1][j - 1]);
                }
                catch(ArrayIndexOutOfBoundsException e){};
                try {
                    roomsTmp[i][j].addNeighboor(roomsTmp[i - 1][j]);
                }
                catch (ArrayIndexOutOfBoundsException e){};
                try {
                    roomsTmp[i][j].addNeighboor(roomsTmp[i-1][j+1]);
                }
                catch (ArrayIndexOutOfBoundsException e){};
                try {
                    roomsTmp[i][j].addNeighboor(roomsTmp[i][j-1]);
                }
                catch (ArrayIndexOutOfBoundsException e){};
                try {
                    roomsTmp[i][j].addNeighboor(roomsTmp[i][j+1]);
                }
                catch (ArrayIndexOutOfBoundsException e){};
                try {
                    roomsTmp[i][j].addNeighboor(roomsTmp[i+1][j-1]);
                }
                catch (ArrayIndexOutOfBoundsException e){};
                try {
                    roomsTmp[i][j].addNeighboor(roomsTmp[i+1][j]);
                }
                catch (ArrayIndexOutOfBoundsException e){};
                try {
                    roomsTmp[i][j].addNeighboor(roomsTmp[i+1][j+1]);
                }
                catch (ArrayIndexOutOfBoundsException e){};
            }
        }

    }

    public String toString(){


        return "I am a building \n"+rooms;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }
    public int getPositionX() { return positionX; }
    public int getPositionY() { return positionY; }

    public static void main(String[] args){

        Building b = new Building(5,3,99,99);
        System.out.println(b);


    }

}
