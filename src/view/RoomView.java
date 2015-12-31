package view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Created by victor on 16/12/15.
 */
public class RoomView {
    private ImageView room;


    public RoomView(int positionX, int positionY, int buildingPositionX, int buildingPositionY){
        room = new ImageView(new Image("file:img/cisco-router-icon.png"));
        room.setFitHeight(60);
        room.setFitWidth(70);


        //Test to know if equipments are in the building
        if (positionX >= buildingPositionX+250){
            //Change this if we change size of image
            positionX = buildingPositionX + 30;
            positionY = positionY + 80;
        }
        room.setX(positionX);
        room.setY(positionY);
    }

    public ImageView getRoom(){
        return room;
    }
    public int getPositionX() { return (int)room.getX();}
    public int getPositionY() { return (int)room.getY();}
}
