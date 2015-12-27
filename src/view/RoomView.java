package view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Created by victor on 16/12/15.
 */
public class RoomView {
    private ImageView room;
    private int positionX;
    private int positionY;

    public RoomView(int prevPositionX, int prevPositionY, int buildingPositionX, int buildingPositionY){
        room = new ImageView(new Image("file:img/cisco-router-icon.png"));
        room.setFitHeight(60);
        room.setFitWidth(70);

        positionX = prevPositionX+90;
        positionY = prevPositionY;

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
    public int getPositionX() { return positionX;}
    public int getPositionY() { return positionY;}
}
