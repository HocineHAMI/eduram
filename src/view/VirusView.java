package view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Virus;
import model.VirusType;

import java.util.Random;

/**
 * Created by victor on 27/12/15.
 */
public class VirusView {
    private ImageView virus;

    public VirusView(VirusType type, int positionX, int positionY){
        switch (type){
            case GREEN:
                virus = new ImageView(new Image("file:img/greenVirus.png"));
                virus.setFitWidth(50);
                virus.setFitHeight(50);
                virus.setX(positionX);
                virus.setY(positionY);
                break;
            case GOLD:
                virus = new ImageView(new Image("file:img/goldVirus.png"));
                virus.setFitWidth(50);
                virus.setFitHeight(30);
                virus.setX(positionX);
                virus.setY(positionY);
                break;
            case RED:
                virus = new ImageView(new Image("file:img/redVirus.png"));
                virus.setFitWidth(60);
                virus.setFitHeight(40);
                virus.setX(positionX);
                virus.setY(positionY);
                break;
            case BLUE:
                virus = new ImageView(new Image("file:img/blueVirus.png"));
                virus.setFitWidth(60);
                virus.setFitHeight(40);
                virus.setX(positionX);
                virus.setY(positionY);
                break;
        }

    }

    public ImageView getVirus(){ return virus;}
}
