package view;

import javafx.event.EventHandler;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import model.Room;

/**
 * Created by victor on 16/12/15.
 */
public class RoomView {
    private ImageView room;
    private Room currentRoom;
    private MapView mapView;

    public RoomView(Room r, MapView slctRoom, int positionX, int positionY, int buildingPositionX, int buildingPositionY){
        currentRoom = r;
        mapView = slctRoom;
        room = new ImageView(new Image("file:img/cisco-router-icon.png"));
        room.setOnMouseClicked(new EventHandler<MouseEvent>() {
               @Override
               public void handle(MouseEvent event) {
                   mapView.setSelectedRoom(currentRoom);
                   room.setEffect(new DropShadow(BlurType.THREE_PASS_BOX, Color.WHITE.deriveColor(0, 0, 0, 0.75), 25, 0, 10, 10));
                   System.out.println("room selected : "+currentRoom);
                   //slctRoom.draw();
                   //mapView.draw();
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

        currentRoom.setRoomView(this);
    }

    public ImageView getRoom(){
        return room;
    }

    public int getPositionX() { return (int)room.getX();}
    public int getPositionY() { return (int)room.getY();}
}
