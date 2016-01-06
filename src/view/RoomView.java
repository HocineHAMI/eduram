package view;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import model.Room;

/**
 * Created by victor on 16/12/15.
 */
public class RoomView {
    private ImageView room;
    private Room currentRoom;
    private Room selectedRoom;

    public RoomView(Room r, Room slctRoom, int positionX, int positionY, int buildingPositionX, int buildingPositionY){
        currentRoom = r;
        selectedRoom = slctRoom;
        room = new ImageView(new Image("file:img/cisco-router-icon.png"));
        room.setOnMouseClicked(new EventHandler<MouseEvent>() {
               @Override
               public void handle(MouseEvent event) {
                   selectedRoom = currentRoom;
               }
           });
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
