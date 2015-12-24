package view;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Created by victor on 24/12/15.
 */
public class BuildingView {
    private Rectangle building;

    public BuildingView(int j){
        building = new Rectangle(100,100);
        building.setX(100+j*60);
        building.setY(100+j*50);

        building.setFill(Color.ORANGE);
        building.setStroke(Color.GOLD);
        building.setStrokeWidth(5);
    }

    public Rectangle getBuilding(){
        return building;
    }
}
