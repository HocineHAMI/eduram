package view;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Created by victor on 24/12/15.
 */
public class BuildingView {
    private Rectangle building;

    public BuildingView(int x, int y){
        building = new Rectangle(300,500);
        building.setX(x);
        building.setY(y);
        building.setArcHeight(5);
        building.setArcWidth(5);
        building.setFill(Color.ORANGE);
        building.setStroke(Color.GOLD);
        building.setStrokeWidth(5);
    }

    public Rectangle getBuilding(){
        return building;
    }
}
