package view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import model.VirusType;

/**
 * Created by victor on 24/12/15.
 */
public class BuildingView {
    private Rectangle building;

    public BuildingView(int x, int y, VirusType color){
        building = new Rectangle(250,500);
        building.setX(x);
        building.setY(y);
        building.setArcHeight(5);
        building.setArcWidth(5);
        building.setFill(Color.ORANGE);
        building.setStrokeWidth(5);
        switch (color){
            case GREEN:
                building.setStroke(Color.GREEN);
                break;
            case GOLD:
                building.setStroke(Color.GOLD);
                break;
            case RED:
                building.setStroke(Color.RED);
                break;
            case BLUE:
                building.setStroke(Color.BLUE);
                break;
        }
    }

    public Rectangle getBuilding(){
        return building;
    }
}
