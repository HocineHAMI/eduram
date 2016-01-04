package model;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by victor on 08/12/15.
 */
public class Building
{
    private ArrayList<Room> rooms;
    private Room roomsTmp;
    private int positionX;
    private int positionY;

    public Building(int width, int height, int x, int y)
    {
        rooms = new ArrayList<Room>();
        //create a tmp array in order to search neighbours easier
        Room[][] roomsTmp;
        roomsTmp = new Room[height][width];
        positionX = x;
        positionY = y;

        //create all rooms in the building
        for (int i = 0; i < height; i++)
        {
            for (int j = 0; j < width; j++)
            {
                rooms.add(new Room(this, i*130, j*90));
                roomsTmp[i][j] = rooms.get(rooms.size()-1);
            }
        }

        //affects neighbours for all rooms in the building
        for (int i = 0; i < height; i++)
        {
            for (int j = 0; j < width; j++)
            {
                try {
                    roomsTmp[i][j].addNeighbor(roomsTmp[i - 1][j - 1]);
                }
                catch(ArrayIndexOutOfBoundsException e){};
                try {
                    roomsTmp[i][j].addNeighbor(roomsTmp[i - 1][j]);
                }
                catch (ArrayIndexOutOfBoundsException e){};
                try {
                    roomsTmp[i][j].addNeighbor(roomsTmp[i - 1][j + 1]);
                }
                catch (ArrayIndexOutOfBoundsException e){};
                try {
                    roomsTmp[i][j].addNeighbor(roomsTmp[i][j - 1]);
                }
                catch (ArrayIndexOutOfBoundsException e){};
                try {
                    roomsTmp[i][j].addNeighbor(roomsTmp[i][j + 1]);
                }
                catch (ArrayIndexOutOfBoundsException e){};
                try {
                    roomsTmp[i][j].addNeighbor(roomsTmp[i + 1][j - 1]);
                }
                catch (ArrayIndexOutOfBoundsException e){};
                try {
                    roomsTmp[i][j].addNeighbor(roomsTmp[i + 1][j]);
                }
                catch (ArrayIndexOutOfBoundsException e){};
                try {
                    roomsTmp[i][j].addNeighbor(roomsTmp[i + 1][j + 1]);
                }
                catch (ArrayIndexOutOfBoundsException e){};
            }
        }

    }

    public void link(Building b){

        Random randomGenerator = new Random();
        int index = randomGenerator.nextInt(rooms.size());
        Room r1 = rooms.get(index);
        index = randomGenerator.nextInt(b.rooms.size());
        Room r2 = b.rooms.get(index);
        r1.addNeighbor(r2);
        r2.addNeighbor(r1);

    }
    public void deleteLinks()
    {

        for (int i = 0; i < rooms.size(); i++) {
            Random randomGenerator = new Random();
            int index = randomGenerator.nextInt(rooms.size());
            Room r1 = rooms.get(index);
            r1.deleteNeighbors();
        }
    }

    public String toString(){


        return "I am a building \n"+rooms;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }
    public Room getRoomsTmp() {return roomsTmp;}
    public int getPositionX() { return positionX; }
    public int getPositionY() { return positionY; }

    public static void main(String[] args){

        Building b = new Building(5,3,99,99);
        System.out.println(b);


    }

}
