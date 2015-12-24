package view;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Created by victor on 24/12/15.
 */
public class BuildingView {
    private Rectangle building;

    public BuildingView(int x, int y){
        building = new Rectangle(100,100);
        building.setX(x);
        building.setY(y);

        building.setFill(Color.ORANGE);
        building.setStroke(Color.GOLD);
        building.setStrokeWidth(5);
    }

    public Rectangle getBuilding(){
        return building;
    }
}
