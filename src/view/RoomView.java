package view;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * Created by victor on 16/12/15.
 */
public class RoomView {
    private Circle room;

    public RoomView(int windowsSizeX, int windowsSizeY, int i, int j){
        room = new Circle();
        room.setCenterX(100+i*60);
        room.setCenterY(100+j*50);
        room.setRadius(20);
        room.setFill(Color.BLUE);
        room.setStroke(Color.SKYBLUE);
        room.setStrokeWidth(5);
    }

    public Circle getRoom(){
        return room;
    }
}
